package com.date.calculator.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.date.calculator.data.DateData;
import com.date.calculator.exception.InvalidException;
import com.date.calculator.service.ProcessNumberOfDays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CalculatorController {
	
	@Autowired
	ProcessNumberOfDays noOfDaysInput ;
	
	@GetMapping("/calculate_days")
	public String main(Model model) {
		DateData dateData = new DateData();
		model.addAttribute("dateData", dateData);
		return "home";
	}
	
	
	@PostMapping("/calculate_days")
	public String calculate_days(@ModelAttribute DateData dateData, Model model) {
		log.debug(dateData.toString());
		try {
			long dateDataDisplay = noOfDaysInput.getNoOfDays(dateData);
			dateData.setNoOfDays(dateDataDisplay);	
		}catch(InvalidException e) {
			log.error(e.getMessage());
			log.error("Invalid Entry " + e.getMessage());
			dateData.setRemarks(e.getMessage());
		}
		model.addAttribute("dateData", dateData);
		return "home";
	}
}
