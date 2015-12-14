package com.safetyculture.net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.safetyculture.SafetyCulture;
import com.safetyculture.exception.APIConnectionException;
import com.safetyculture.exception.APIException;
import com.safetyculture.exception.AuthenticationException;
import com.safetyculture.exception.InvalidRequestException;
import com.safetyculture.exception.SafetyCultureException;

/**
 * Created by Tannu on 11/3/2015.
 */
public class ResponseGetter implements SafetyCultureResponseGetter {

	private static Logger logger = Logger.getLogger(ResponseGetter.class);

	public <T> T request(APIResource.RequestMethod method, String url,
			Map<String, Object> params, Map<String, Object> pathParams,
			Class<T> clazz, APIResource.RequestType type, RequestOptions options)
			throws SafetyCultureException {
		return _request(method, url, params, pathParams, clazz, type, options);
	}

	private static <T> T _request(APIResource.RequestMethod method, String url,
			Map<String, Object> params, Map<String, Object> pathParams,
			Class<T> clazz, APIResource.RequestType type, RequestOptions options)
			throws SafetyCultureException {
		if (options == null) {
			return null;
		}

		String apiKey = options.getApiKey();
		if (apiKey == null || apiKey.trim().isEmpty()) {
			throw new AuthenticationException(
					"No API key provided. (HINT: set your API key using 'SafetyCulture.apiKey = <API-KEY>'. "
							+ "You can generate API keys from the safety culture web interface. "
							+ "See https://developer.safetyculture.io for details.",
					null, 0);
		}

		try {
			SafetyCultureResponse response = null;
			switch (type) {
			case NORMAL:
				response = getSafetyCultureResponse(method, url, params,
						pathParams, options);
				break;
			case MULTIPART:
				response = getMultipartSafetyCultureResponse(method, url,
						params, pathParams, options);
				break;
			default:
				throw new RuntimeException(
						"Invalid APIResource request type. "
								+ "This indicates a bug in the bindings. Please contact "
								+ "Safety Culture for assistance.");
			}
			int rCode = response.responseCode;
			String rBody = response.responseBody;

			String requestId = null;
			Map<String, List<String>> headers = response.getResponseHeaders();
			List<String> requestIdList = headers == null ? null : headers
					.get("Request-Id");
			if (requestIdList != null && requestIdList.size() > 0) {
				requestId = requestIdList.get(0);
			}

			if (rCode < 200 || rCode >= 300) {
				handleAPIError(rBody, rCode, requestId);
			}

			logger.debug("Response returned: " + rBody);
			if(type== APIResource.RequestType.MULTIPART && rCode == 200){
				return null;	
			}else{
				T resource = APIResource.GSON.fromJson(rBody, clazz);
				return resource;
			}

			
		} finally {

		}
	}

	private static SafetyCultureResponse getMultipartSafetyCultureResponse(
			APIResource.RequestMethod method, String url,
			Map<String, Object> params, Map<String, Object> pathParams,
			RequestOptions options) throws InvalidRequestException,
			APIConnectionException, APIException {

		if (method != APIResource.RequestMethod.GET) {
			throw new InvalidRequestException(
					"Multipart requests for HTTP methods other than GET "
							+ "are currently not supported.", null, null, 0,
					null);
		}

		if (pathParams != null && pathParams.size() > 0) {
			try {
				url = createQuery(url, pathParams);
			} catch (UnsupportedEncodingException e) {
				throw new InvalidRequestException(
						"Unable to encode parameters to "
								+ APIResource.CHARSET
								+ ". Please contact Safety Culture for assistance.",
						null, null, 0, e);
			}
		}

		java.net.HttpURLConnection conn = null;
		try {
			conn = createGetConnection(url, null, options);

			if(params==null || !params.containsKey("filepath")){
				throw new InvalidRequestException(
						"Multipart requests for HTTP methods require a parameter filepath. "
								, null, null, 0,
						null);
			}
			// trigger the request
			int rCode = conn.getResponseCode();
			String rBody;
			Map<String, List<String>> headers;

			if (rCode >= 200 && rCode < 300) {
				String fileName=(String)params.get("filepath");
				getMultiPartResponseBody(conn.getInputStream(),fileName);
				rBody=null;
			} else {
				rBody = getResponseBody(conn.getErrorStream());
			}
			headers = conn.getHeaderFields();
			return new SafetyCultureResponse(rCode, rBody, headers);

		} catch (IOException e) {
			throw new APIConnectionException(
					String.format(
							"IOException during API request to Safety culture (%s): %s "
									+ "Please check your internet connection and try again. If this problem persists,"
									+ "you should check Safety Culture's service status",
							SafetyCulture.getApiBase(), e.getMessage()), e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

	}

	private static SafetyCultureResponse getSafetyCultureResponse(
			APIResource.RequestMethod method, String url,
			Map<String, Object> params, Map<String, Object> pathParams,
			RequestOptions options) throws InvalidRequestException,
			APIConnectionException, APIException {

		if (pathParams != null && pathParams.size() > 0) {
			try {
				url = createQuery(url, pathParams);
			} catch (UnsupportedEncodingException e) {
				throw new InvalidRequestException(
						"Unable to encode parameters to "
								+ APIResource.CHARSET
								+ ". Please contact Safety Culture for assistance.",
						null, null, 0, e);
			}
		}
		String query = null;
		if (params != null && params.size() > 0) {
			try {
				query = createQuery(params);
			} catch (UnsupportedEncodingException e) {
				throw new InvalidRequestException(
						"Unable to encode parameters to "
								+ APIResource.CHARSET
								+ ". Please contact Safety Culture for assistance.",
						null, null, 0, e);
			}
		}

		return makeURLConnectionRequest(method, url, query, options);

	}

	private static void handleAPIError(String rBody, int rCode, String requestId)
			throws SafetyCultureException {
		Error error = APIResource.GSON.fromJson(rBody, Error.class);
		switch (rCode) {
		case 400:
			throw new InvalidRequestException(error.message, error.error,
					requestId, rCode, null);
		case 404:
			throw new InvalidRequestException(error.message, error.error,
					requestId, rCode, null);
		case 401:
			throw new AuthenticationException(error.message, requestId, rCode);
		default:
			throw new APIException(error.message, requestId, rCode, null);
		}
	}

	private static class Error {
		@SuppressWarnings("unused")
		int statusCode;

		String error;

		String message;
	}

	private static java.net.HttpURLConnection createSFConnection(String url,
			RequestOptions options) throws IOException {
		URL scURL;
		scURL = new URL(url);
		HttpURLConnection conn;
		conn = (HttpURLConnection) scURL.openConnection();
		conn.setConnectTimeout(30 * 1000);
		for (Map.Entry<String, String> header : getHeaders(options).entrySet()) {
			conn.setRequestProperty(header.getKey(), header.getValue());
		}

		return conn;
	}

	static Map<String, String> getHeaders(RequestOptions options) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization",
				String.format("Bearer %s", options.getApiKey()));
		return headers;
	}

	private static SafetyCultureResponse makeURLConnectionRequest(
			APIResource.RequestMethod method, String url, String query,
			RequestOptions options) throws APIConnectionException {
		java.net.HttpURLConnection conn = null;
		try {
			switch (method) {
			case GET:
				conn = createGetConnection(url, query, options);
				break;
			default:
				throw new APIConnectionException(
						String.format(
								"Unrecognized HTTP method %s. "
										+ "This indicates a bug in the Safety Culture bindings. Please contact "
										+ "Safety Culture for assistance.",
								method));
			}
			// trigger the request
			int rCode = conn.getResponseCode();
			String rBody;
			Map<String, List<String>> headers;
			// rBody = getResponseBody(conn.getInputStream());

			if (rCode >= 200 && rCode < 300) {
				rBody = getResponseBody(conn.getInputStream());
			} else {
				rBody = getResponseBody(conn.getErrorStream());
			}
			headers = conn.getHeaderFields();
			return new SafetyCultureResponse(rCode, rBody, headers);

		} catch (IOException e) {
			throw new APIConnectionException(
					String.format(
							"IOException during API request to Safety culture (%s): %s "
									+ "Please check your internet connection and try again. If this problem persists,"
									+ "you should check Safety Culture's service status",
							SafetyCulture.getApiBase(), e.getMessage()), e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	private static String getResponseBody(InputStream responseStream)
			throws IOException {
		// \A is the beginning of
		// the stream boundary
		String rBody = null;
		if (responseStream != null) {
			Scanner response = new Scanner(responseStream, APIResource.CHARSET);
			rBody = response.useDelimiter("\\A").next(); //

			response.close();
			responseStream.close();
		}
		return rBody;
	}

	private static void getMultiPartResponseBody(InputStream responseStream,String filePath)
			throws IOException {
		if (responseStream != null) {

	     // opens an output stream to save into file
	        FileOutputStream outputStream = new FileOutputStream(filePath);

	        int bytesRead = -1;
	        byte[] buffer = new byte[4096];
	        while ((bytesRead = responseStream.read(buffer)) != -1) {
	            outputStream.write(buffer, 0, bytesRead);
	        }
	        
	        outputStream.close();
	        responseStream.close();
		}
	}

	private static java.net.HttpURLConnection createGetConnection(String url,
			String query, RequestOptions options) throws IOException {
		String getURL = formatURL(url, query);
		java.net.HttpURLConnection conn = createSFConnection(getURL, options);
		conn.setRequestMethod("GET");

		return conn;
	}

	static String createQuery(String url, Map<String, Object> params)
			throws UnsupportedEncodingException, InvalidRequestException {

		if (params != null) {
			for (String paramName : params.keySet()) {
				if (url.contains(paramName)) {
					url = url
							.replace(paramName, (String) params.get(paramName));
				}
			}

		}

		return url;
	}

	private static String formatURL(String url, String query) {
		if (query == null || query.isEmpty()) {
			return url;
		} else {
			// In some cases, URL can already contain a question mark (eg,
			// upcoming invoice lines)
			String separator = url.contains("?") ? "&" : "?";
			return String.format("%s%s%s", url, separator, query);
		}
	}

	static String createQuery(Map<String, Object> params)
			throws UnsupportedEncodingException, InvalidRequestException {
		StringBuilder queryStringBuffer = new StringBuilder();
		List<Parameter> flatParams = flattenParams(params);
		Iterator<Parameter> it = flatParams.iterator();

		while (it.hasNext()) {
			if (queryStringBuffer.length() > 0) {
				queryStringBuffer.append("&");
			}
			Parameter param = it.next();
			queryStringBuffer.append(urlEncodePair(param.key, param.value));
		}

		return queryStringBuffer.toString();
	}

	private static String urlEncodePair(String k, String v)
			throws UnsupportedEncodingException {
		return String.format("%s=%s", APIResource.urlEncode(k),
				APIResource.urlEncode(v));
	}

	private static List<Parameter> flattenParams(Map<String, Object> params)
			throws InvalidRequestException {
		return flattenParamsMap(params, null);
	}

	private static List<Parameter> flattenParamsList(List<Object> params,
			String keyPrefix) throws InvalidRequestException {
		List<Parameter> flatParams = new LinkedList<Parameter>();
		Iterator<?> it = ((List<?>) params).iterator();
		String newPrefix = String.format("%s", keyPrefix);

		if (params.isEmpty()) {
			flatParams.add(new Parameter(keyPrefix, ""));
		} else {
			while (it.hasNext()) {
				flatParams.addAll(flattenParamsValue(it.next(), newPrefix));
			}
		}

		return flatParams;
	}

	private static List<Parameter> flattenParamsMap(Map<String, Object> params,
			String keyPrefix) throws InvalidRequestException {
		List<Parameter> flatParams = new LinkedList<Parameter>();
		if (params == null) {
			return flatParams;
		}

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			String newPrefix = key;
			if (keyPrefix != null) {
				newPrefix = String.format("%s[%s]", keyPrefix, key);
			}

			flatParams.addAll(flattenParamsValue(value, newPrefix));
		}

		return flatParams;
	}

	@SuppressWarnings("unchecked")
	private static List<Parameter> flattenParamsValue(Object value,
			String keyPrefix) throws InvalidRequestException {
		List<Parameter> flatParams = new LinkedList<Parameter>();

		if (value instanceof Map<?, ?>) {
			flatParams = flattenParamsMap((Map<String, Object>) value,
					keyPrefix);
		} else if (value instanceof List<?>) {
			flatParams = flattenParamsList((List<Object>) value, keyPrefix);
		} else if ("".equals(value)) {
			throw new InvalidRequestException("You cannot set '" + keyPrefix
					+ "' to an empty string. "
					+ "We interpret empty strings as null in requests. "
					+ "You may set '" + keyPrefix
					+ "' to null to delete the property.", keyPrefix, null, 0,
					null);
		} else if (value == null) {
			flatParams = new LinkedList<Parameter>();
			flatParams.add(new Parameter(keyPrefix, ""));
		} else {
			flatParams = new LinkedList<Parameter>();
			flatParams.add(new Parameter(keyPrefix, value.toString()));
		}

		return flatParams;
	}

	private final static class Parameter {
		public final String key;
		public final String value;

		public Parameter(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
}
