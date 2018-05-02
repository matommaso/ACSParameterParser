package it.maior.icaroxt.poc.parser;

import java.util.HashMap;

public class Airport {

	public String firstLine;
	public HashMap<String, String> airportParameters;

	public Airport(String firstLine) {
		this.firstLine = firstLine;
		this.airportParameters= new HashMap<String,String>();
	}
}
