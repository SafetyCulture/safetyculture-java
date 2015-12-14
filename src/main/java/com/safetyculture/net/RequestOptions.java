package com.safetyculture.net;

/**
 * Build Request Options to connect to Safety Culture
 */
public class RequestOptions {

    private final String apiKey;
    public static final String AUDIT_ID="<audit ID>";
    public static final String MEDIA_ID="<media ID>";

    private RequestOptions(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestOptions that = (RequestOptions) o;

        if (apiKey != null ? !apiKey.equals(that.apiKey) : that.apiKey != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = apiKey != null ? apiKey.hashCode() : 0;
        return result;
    }

    public static RequestOptionsBuilder builder() {
        return new RequestOptionsBuilder();
    }

    public RequestOptionsBuilder toBuilder() {
        return new RequestOptionsBuilder().setApiKey(this.apiKey);
    }

    public static final class RequestOptionsBuilder {
        private String apiKey;

        public RequestOptionsBuilder() {
            this.apiKey = null;
        }

        public String getApiKey() {
            return apiKey;
        }

        public RequestOptionsBuilder setApiKey(String apiKey) {
            this.apiKey = normalizeApiKey(apiKey);
            return this;
        }

        public RequestOptionsBuilder clearApiKey() {
            this.apiKey = null;
            return this;
        }

        public RequestOptions build() {
            return new RequestOptions(
                    normalizeApiKey(this.apiKey));
        }
    }

    private static String normalizeApiKey(String apiKey) {
        // null apiKeys are considered "valid"
        if (apiKey == null) {
            return null;
        }
        String normalized = apiKey.trim();
        if (normalized.isEmpty()) {
            throw new InvalidRequestOptionsException("Empty API key specified!");
        }
        return normalized;
    }

    public static class InvalidRequestOptionsException extends RuntimeException {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public InvalidRequestOptionsException(String message) {
            super(message);
        }
    }
}

