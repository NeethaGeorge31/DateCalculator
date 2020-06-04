package com.date.calculator.data;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class DateData {
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	
	private long noOfDays;
	
	private String remarks;
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public DateData() {}
	
	public long getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(long noOfDays) {
		this.noOfDays = noOfDays;
	}	

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "DateData [startDate=" + startDate + ", endDate=" + endDate + ", noOfDays=" + noOfDays + "]";
	}
	
	
}
