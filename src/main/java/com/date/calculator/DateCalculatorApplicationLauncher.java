package com.date.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.date.calculator")
public class DateCalculatorApplicationLauncher {

	public static void main(String[] args) {
		SpringApplication.run(DateCalculatorApplicationLauncher.class, args);
	}

}
