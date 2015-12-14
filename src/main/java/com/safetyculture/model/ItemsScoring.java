package com.safetyculture.model;

public class ItemsScoring {

	private Long score;
	private Long max_score;
	private Long score_percentage;
	private Long combined_score;
	private Long combined_max_score;
	private Long combined_score_percentage;
	
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public Long getMax_score() {
		return max_score;
	}
	public void setMax_score(Long maxScore) {
		max_score = maxScore;
	}
	public Long getScore_percentage() {
		return score_percentage;
	}
	public void setScore_percentage(Long scorePercentage) {
		score_percentage = scorePercentage;
	}
	public Long getCombined_score() {
		return combined_score;
	}
	public void setCombined_score(Long combinedScore) {
		combined_score = combinedScore;
	}
	public Long getCombined_max_score() {
		return combined_max_score;
	}
	public void setCombined_max_score(Long combinedMaxScore) {
		combined_max_score = combinedMaxScore;
	}
	public Long getCombined_score_percentage() {
		return combined_score_percentage;
	}
	public void setCombined_score_percentage(Long combinedScorePercentage) {
		combined_score_percentage = combinedScorePercentage;
	}
	@Override
	public String toString() {
		return "ItemsScoring [combined_max_score=" + combined_max_score
				+ ", combined_score=" + combined_score
				+ ", combined_score_percentage=" + combined_score_percentage
				+ ", max_score=" + max_score + ", score=" + score
				+ ", score_percentage=" + score_percentage + "]";
	}
	
	
}
