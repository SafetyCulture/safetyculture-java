package com.safetyculture.model;

public class Results {

	private int count;
	private int total;
	private Audit[] audits;
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the audits
	 */
	public Audit[] getAudits() {
		return audits;
	}
	/**
	 * @param audits the audits to set
	 */
	public void setAudits(Audit[] audits) {
		this.audits = audits;
	}
	
	
}
