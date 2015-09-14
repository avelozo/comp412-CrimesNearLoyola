package com.loyola.crimes;

public class Crime {
	
	private String caseNumber;
	private boolean arrest;
	private String date;
	private String time;
	private String locationType;
	private String primaryDescription;
	private String secondaryDescription;
	private String year;
	
	
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
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
	public String getLocationtType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
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
