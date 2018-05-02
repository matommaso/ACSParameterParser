package it.maior.icaroxt.poc.parser;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainParser {

	public static void main(String[] args) {

		// The name of the file to open.
		String fileName = "Input/ParametriACS.spar";

		int airportOccurences = 0;
		//String regexAirportParametersFirstLine = "\\w{3} \\w{1} \\w{1} \\w{1} \\w{1} \\w* \\w{2} \\w{2} [\\w \\.]*";
		String regexAirportParametersFirstLine = "\\w{3} \\w{1} -?[0-9]\\d* \\w{1} \\w{1} \\w* \\w* \\w* \\w* \\w* -?[0-9]\\d*(\\.\\d+) \\w{1}";
		
		
		String line = null;
		int number = 0;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				if (Pattern.matches(regexAirportParametersFirstLine, line)) {
					ArrayList<String> airplaneParameters = new ArrayList<String>();
					airplaneParameters.add(line);
					System.out.println(number++ +" "+line);
					while (!(line = bufferedReader.readLine()).equals("FineParametriAPT")) {
						airplaneParameters.add(line);
					}
					ParseAirport(airplaneParameters);
				}
				if (line.startsWith("#AEREOPORTI")) {
					airportOccurences = Integer.parseInt(bufferedReader.readLine());
				}
			}
			System.out.println(airportOccurences);

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

	private static void ParseAirport(ArrayList<String> airplaneParameters) {

		Airport airport = new Airport(airplaneParameters.get(0));
		for (int i = 1; i < airplaneParameters.size(); i++) {
			String[] parsedString = airplaneParameters.get(i).split(" ");
			airport.airportParameters.put(parsedString[0], parsedString[1]);
		}
	}
}
