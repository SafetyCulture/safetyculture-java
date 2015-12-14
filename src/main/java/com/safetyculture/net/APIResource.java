package com.safetyculture.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safetyculture.SafetyCulture;
import com.safetyculture.exception.InvalidRequestException;
import com.safetyculture.exception.SafetyCultureException;

public abstract class APIResource {
	private static SafetyCultureResponseGetter scResponseGetter = new ResponseGetter();

	public static void setScResponseGetter(SafetyCultureResponseGetter srg) {
		APIResource.scResponseGetter = srg;
	}

	public static final Gson GSON = new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.create();

	private static String className(Class<?> clazz) {
		String className = clazz.getSimpleName().toLowerCase().replace("$", " ");

		if (className.equals("audit")) {
			return "audits/"+RequestOptions.AUDIT_ID;
		} else if (className.equals("results")) {
			return "audits/search";
		} else if (className.equals("file")) {
			return "audits/"+RequestOptions.AUDIT_ID+"/media/"+RequestOptions.MEDIA_ID;
		} else {
			return className;
		}
	}

	protected static String singleClassURL(Class<?> clazz) {
		return singleClassURL(clazz, SafetyCulture.getApiBase());
	}

	protected static String singleClassURL(Class<?> clazz, String apiBase) {
		return String.format("%s%s", apiBase, className(clazz));
	}

	protected static String classURL(Class<?> clazz) {
		return classURL(clazz, SafetyCulture.getApiBase());
	}

	protected static String classURL(Class<?> clazz, String apiBase) {
		return String.format("%s", singleClassURL(clazz, apiBase));
	}

	protected static String instanceURL(Class<?> clazz, String id)
			throws InvalidRequestException {
		return instanceURL(clazz, id, SafetyCulture.getApiBase());
	}

	protected static String instanceURL(Class<?> clazz, String id, String apiBase)
			throws InvalidRequestException {
		try {
			return String.format("%s/%s", classURL(clazz, apiBase), urlEncode(id));
		} catch (UnsupportedEncodingException e) {
			throw new InvalidRequestException("Unable to encode parameters to "
					+ CHARSET
					+ ". Please contact for assistance.",
					null, null, 0, e);
		}
	}

	public static final String CHARSET = "UTF-8";

	public enum RequestMethod {
		GET, POST, DELETE
	}

	public enum RequestType {
		NORMAL, MULTIPART
	}

	public static String urlEncode(String str) throws UnsupportedEncodingException {
		// Preserve original behavior that passing null for an object id will lead
		// to us actually making a request to /v1/foo/null
		if (str == null) {
			return null;
		}
		else {
			return URLEncoder.encode(str, CHARSET);
		}
	}

	protected static <T> T multipartRequest(APIResource.RequestMethod method,
			String url, Map<String, Object> params,Map<String, Object> pathParams, Class<T> clazz,
			RequestOptions options) throws SafetyCultureException {
		return APIResource.scResponseGetter.request(method, url, params,pathParams, clazz,
				APIResource.RequestType.MULTIPART, options);
	}

	protected static <T> T request(APIResource.RequestMethod method,
			String url, Map<String, Object> params,Map<String, Object> pathParams, Class<T> clazz,
			RequestOptions options) throws SafetyCultureException {
		return APIResource.scResponseGetter.request(method, url, params,pathParams, clazz,
				APIResource.RequestType.NORMAL, options);
	}
	
}
