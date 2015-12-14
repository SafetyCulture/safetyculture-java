package com.safetyculture.net;


import java.util.Map;

import com.safetyculture.exception.SafetyCultureException;

public interface SafetyCultureResponseGetter {
	public <T> T request(
			APIResource.RequestMethod method,
			String url,
			Map<String, Object> params,Map<String, Object> pathParams,
			Class<T> clazz,
			APIResource.RequestType type,
			RequestOptions options) throws SafetyCultureException;
}

