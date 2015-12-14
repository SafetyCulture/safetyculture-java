package com.safetyculture.model;

import java.util.Arrays;

public class AuditItem {
	private String item_id;
	private String parent_id;
	private String label;
	private Integer[] action_item_profile_id;
	private String type;	
	private ItemOptions options;
	private ItemResponses response;
	private Media media;
	private String[] children;
	private ItemsScoring scoring;
	
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parentId) {
		parent_id = parentId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer[] getAction_item_profile_id() {
		return action_item_profile_id;
	}
	public void setAction_item_profile_id(Integer[] actionItemProfileId) {
		action_item_profile_id = actionItemProfileId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String[] getChildren() {
		return children;
	}
	public void setChildren(String[] children) {
		this.children = children;
	}
	public ItemsScoring getScoring() {
		return scoring;
	}
	public void setScoring(ItemsScoring scoring) {
		this.scoring = scoring;
	}
	
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String itemId) {
		item_id = itemId;
	}
	public ItemOptions getOptions() {
		return options;
	}
	public void setOptions(ItemOptions options) {
		this.options = options;
	}
	public ItemResponses getResponse() {
		return response;
	}
	public void setResponse(ItemResponses response) {
		this.response = response;
	}
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	@Override
	public String toString() {
		return "AuditItem [action_item_profile_id="
				+ Arrays.toString(action_item_profile_id) + ", children="
				+ Arrays.toString(children) + ", item_id=" + item_id
				+ ", label=" + label + ", media=" + media + ", options="
				+ options + ", parent_id=" + parent_id + ", response="
				+ response + ", scoring=" + scoring + ", type=" + type + "]";
	}
	
	

}
