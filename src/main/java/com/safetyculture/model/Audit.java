package com.safetyculture.model;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

import com.safetyculture.exception.SafetyCultureException;
import com.safetyculture.net.APIResource;
import com.safetyculture.net.RequestOptions;

/**
 * This is the Audit class to get the audit details
 */
public class Audit extends APIResource {
	private String audit_id;
	private String template_id;
	private String created_at;
	private String modified_at;	
	private AuditData audit_data;
	private TemplateData template_data;	
	private AuditItem[] header_items;
	private AuditItem[] items;
	private AuditAssets[] assets;

	public AuditItem[] getItems() {
		return items;
	}
	public void setItems(AuditItem[] items) {
		this.items = items;
	}
	public String getAudit_id() {
		return audit_id;
	}
	public void setAudit_id(String auditId) {
		audit_id = auditId;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String templateId) {
		template_id = templateId;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String createdAt) {
		created_at = createdAt;
	}
	public String getModified_at() {
		return modified_at;
	}
	public void setModified_at(String modifiedAt) {
		modified_at = modifiedAt;
	}
	public AuditData getAudit_data() {
		return audit_data;
	}
	public void setAudit_data(AuditData auditData) {
		audit_data = auditData;
	}
	public TemplateData getTemplate_data() {
		return template_data;
	}
	public void setTemplate_data(TemplateData templateData) {
		template_data = templateData;
	}
	public AuditItem[] getHeader_items() {
		return header_items;
	}
	public void setHeader_items(AuditItem[] headerItems) {
		header_items = headerItems;
	}
	public AuditAssets[] getAssets() {
		return assets;
	}
	public void setAssets(AuditAssets[] assets) {
		this.assets = assets;
	}
	@Override
	public String toString() {
		return "Audit [assets=" + Arrays.toString(assets) + ", audit_data="
				+ audit_data + ", audit_id=" + audit_id + ", created_at="
				+ created_at + ", header_items="
				+ Arrays.toString(header_items) + ", items="
				+ Arrays.toString(items) + ", modified_at=" + modified_at
				+ ", template_data=" + template_data + ", template_id="
				+ template_id + "]";
	}

	public static Audit get(Map<String, Object> params,Map<String, Object> pathParams, RequestOptions options)
			throws SafetyCultureException {
		return request(RequestMethod.GET, classURL(Audit.class), params,pathParams, Audit.class, options);
	}
	
	public static Results search(Map<String, Object> params,Map<String, Object> pathParams, RequestOptions options)
			throws SafetyCultureException {
		return request(RequestMethod.GET, classURL(Results.class), params,pathParams, Results.class, options);
	}


	public static void getMedia(Map<String, Object> params,Map<String, Object> pathParams, RequestOptions options)
			throws SafetyCultureException {
		multipartRequest(RequestMethod.GET, classURL(File.class), params,pathParams, File.class, options);
	}
}
