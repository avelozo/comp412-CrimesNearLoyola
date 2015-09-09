package com.loyola.crimes;

public class Crime {
	
	private String caseNumber;
	private boolean arrest;
	private String date;
	private String time;
	private String location;
	private String primaryDescription;
	private String secondaryDescription;
	
	
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public boolean isArrest() {
		return arrest;
	}
	public void setArrest(boolean arrest) {
		this.arrest = arrest;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPrimaryDescription() {
		return primaryDescription;
	}
	public void setPrimaryDescription(String primaryDescription) {
		this.primaryDescription = primaryDescription;
	}
	public String getSecondaryDescription() {
		return secondaryDescription;
	}
	public void setSecondaryDescription(String secondaryDescription) {
		this.secondaryDescription = secondaryDescription;
	}

}
