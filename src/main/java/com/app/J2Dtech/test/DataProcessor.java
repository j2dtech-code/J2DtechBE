package com.app.J2Dtech.test;

public abstract class DataProcessor {

	public final void processData() {
		readFile();
		parseData();
		validateData();
		process();
	}

	private void process() {
		System.out.println("Processing Data");

	}

	private void validateData() {
		System.out.println("Validate Data");

	}

	protected abstract void parseData();

	private void readFile() {
		System.out.println("Reading File");
	}

}


