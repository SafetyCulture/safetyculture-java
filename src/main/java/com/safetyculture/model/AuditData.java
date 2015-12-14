package com.safetyculture.model;

public class AuditData {
	
	private String name;
	private Double score;
	private Double total_score;
	private Double score_percentage;
	private Double duration;
	private String date_started;
	private String date_modified;
	private String date_completed;
	private Authorship authorship;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Double getTotal_score() {
		return total_score;
	}
	public void setTotal_score(Double totalScore) {
		total_score = totalScore;
	}
	public Double getScore_percentage() {
		return score_percentage;
	}
	public void setScore_percentage(Double scorePercentage) {
		score_percentage = scorePercentage;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public String getDate_started() {
		return date_started;
	}
	public void setDate_started(String dateStarted) {
		date_started = dateStarted;
	}
	public String getDate_modified() {
		return date_modified;
	}
	public void setDate_modified(String dateModified) {
		date_modified = dateModified;
	}
	public String getDate_completed() {
		return date_completed;
	}
	public void setDate_completed(String dateCompleted) {
		date_completed = dateCompleted;
	}
	public Authorship getAuthorship() {
		return authorship;
	}
	public void setAuthorship(Authorship authorship) {
		this.authorship = authorship;
	}
	@Override
	public String toString() {
		return "AuditData [authorship=" + authorship + ", date_completed="
				+ date_completed + ", date_modified=" + date_modified
				+ ", date_started=" + date_started + ", duration=" + duration
				+ ", name=" + name + ", score=" + score + ", score_percentage="
				+ score_percentage + ", total_score=" + total_score + "]";
	}
	
	

}
