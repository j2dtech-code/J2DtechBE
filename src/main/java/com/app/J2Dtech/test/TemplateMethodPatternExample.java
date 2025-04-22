package com.app.J2Dtech.test;

public class TemplateMethodPatternExample {

	public static void main(String args[]) {
		DataProcessor csvProcessor = new CSVProcessor();
		csvProcessor.processData();
		DataProcessor jsonProcessor = new JSONProcessor();
		jsonProcessor.processData();
	}
	
}
