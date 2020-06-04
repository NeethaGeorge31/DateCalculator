package com.date.calculator.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.date.calculator.data.DateData;
import com.date.calculator.exception.InvalidException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProcessNumberOfDays {
	
	@Value("${invalid.date.msg}")
	private String invalidInput;
	@Value("${invalid.date.entry}")
	private String invalidEntry;
	
	/**
	 * Number of days between start and end date 
	 */
	public long getNoOfDays(DateData dateData) {
		
		inputValidation(dateData.getStartDate(),dateData.getEndDate()); //Validation
		log.debug("Start Date after Parsing.." + dateData.getStartDate() + "End date after parsing.." + dateData.getEndDate());
		//calculating number of days in between
		long noOfDaysBetween = ChronoUnit.DAYS.between(dateData.getStartDate(), dateData.getEndDate());
		log.info("NoOfDays " + noOfDaysBetween);
		return noOfDaysBetween;
	}
	
	/**
	 * Validating Input
	 */
	private void inputValidation(LocalDate startDate, LocalDate endDate) {
		if(startDate == null || endDate == null) {
			throw new InvalidException(invalidEntry);
		}else if(startDate.isAfter(endDate)) {
			throw new InvalidException(invalidInput); //taking Value from application.properties
		}
	}

}
