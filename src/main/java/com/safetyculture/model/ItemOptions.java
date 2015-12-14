package com.safetyculture.model;

import java.util.Arrays;

public class ItemOptions {
	private AuditAssets[] assets;
	private String computed_field;
	private String condition;
	private String element;
	private Boolean enable_date;
	private Boolean enable_signature_timestamp;
	private Boolean enable_time;
	private Boolean hide_barcode;
	private String increment;
	private Boolean is_mandatory;
	private String label;
	private String link;
	private Boolean locked;
	private String max;
	private String media;
	private Boolean media_visible_in_report;
	private String min;
	private Boolean multiple_selection;
	private String response_set;
	private Boolean secure;
	private String type;
	private String url;
	private String values;
	private Boolean visible_in_audit;
	private Boolean visible_in_report;
	private String weighting;
	public AuditAssets[] getAssets() {
		return assets;
	}
	public void setAssets(AuditAssets[] assets) {
		this.assets = assets;
	}
	public String getComputed_field() {
		return computed_field;
	}
	public void setComputed_field(String computedField) {
		computed_field = computedField;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public Boolean getEnable_date() {
		return enable_date;
	}
	public void setEnable_date(Boolean enableDate) {
		enable_date = enableDate;
	}
	public Boolean getEnable_signature_timestamp() {
		return enable_signature_timestamp;
	}
	public void setEnable_signature_timestamp(Boolean enableSignatureTimestamp) {
		enable_signature_timestamp = enableSignatureTimestamp;
	}
	public Boolean getEnable_time() {
		return enable_time;
	}
	public void setEnable_time(Boolean enableTime) {
		enable_time = enableTime;
	}
	public Boolean getHide_barcode() {
		return hide_barcode;
	}
	public void setHide_barcode(Boolean hideBarcode) {
		hide_barcode = hideBarcode;
	}
	public String getIncrement() {
		return increment;
	}
	public void setIncrement(String increment) {
		this.increment = increment;
	}
	public Boolean getIs_mandatory() {
		return is_mandatory;
	}
	public void setIs_mandatory(Boolean isMandatory) {
		is_mandatory = isMandatory;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public Boolean getMedia_visible_in_report() {
		return media_visible_in_report;
	}
	public void setMedia_visible_in_report(Boolean mediaVisibleInReport) {
		media_visible_in_report = mediaVisibleInReport;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public Boolean getMultiple_selection() {
		return multiple_selection;
	}
	public void setMultiple_selection(Boolean multipleSelection) {
		multiple_selection = multipleSelection;
	}
	public String getResponse_set() {
		return response_set;
	}
	public void setResponse_set(String responseSet) {
		response_set = responseSet;
	}
	public Boolean getSecure() {
		return secure;
	}
	public void setSecure(Boolean secure) {
		this.secure = secure;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getValues() {
		return values;
	}
	public void setValues(String values) {
		this.values = values;
	}
	public Boolean getVisible_in_audit() {
		return visible_in_audit;
	}
	public void setVisible_in_audit(Boolean visibleInAudit) {
		visible_in_audit = visibleInAudit;
	}
	public Boolean getVisible_in_report() {
		return visible_in_report;
	}
	public void setVisible_in_report(Boolean visibleInReport) {
		visible_in_report = visibleInReport;
	}
	public String getWeighting() {
		return weighting;
	}
	public void setWeighting(String weighting) {
		this.weighting = weighting;
	}
	@Override
	public String toString() {
		return "ItemOptions [assets=" + Arrays.toString(assets)
				+ ", computed_field=" + computed_field + ", condition="
				+ condition + ", element=" + element + ", enable_date="
				+ enable_date + ", enable_signature_timestamp="
				+ enable_signature_timestamp + ", enable_time=" + enable_time
				+ ", hide_barcode=" + hide_barcode + ", increment=" + increment
				+ ", is_mandatory=" + is_mandatory + ", label=" + label
				+ ", link=" + link + ", locked=" + locked + ", max=" + max
				+ ", media=" + media + ", media_visible_in_report="
				+ media_visible_in_report + ", min=" + min
				+ ", multiple_selection=" + multiple_selection
				+ ", response_set=" + response_set + ", secure=" + secure
				+ ", type=" + type + ", url=" + url + ", values=" + values
				+ ", visible_in_audit=" + visible_in_audit
				+ ", visible_in_report=" + visible_in_report + ", weighting="
				+ weighting + "]";
	}
	
	

}
