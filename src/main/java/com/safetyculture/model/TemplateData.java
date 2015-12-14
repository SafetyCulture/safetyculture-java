package com.safetyculture.model;

public class TemplateData {

	private TemplateMetadata metadata;
	private ResponseSets response_sets;
	private Authorship authorship;
	
	public TemplateMetadata getMetadata() {
		return metadata;
	}
	public void setMetadata(TemplateMetadata metadata) {
		this.metadata = metadata;
	}
	public ResponseSets getResponse_sets() {
		return response_sets;
	}
	public void setResponse_sets(ResponseSets responseSets) {
		response_sets = responseSets;
	}
	public Authorship getAuthorship() {
		return authorship;
	}
	public void setAuthorship(Authorship authorship) {
		this.authorship = authorship;
	}
	@Override
	public String toString() {
		return "TemplateData [authorship=" + authorship + ", metadata="
				+ metadata + ", response_sets=" + response_sets + "]";
	}
	
	
	
}
