package it.maior.icaroxt.poc.parser.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

import it.maior.icaroxt.poc.parser.Airport;

public class MainParserDemo {

	public static void main(String[] args) {

		// The name of the file to open.
		String fileName = "Input/ParametriACS.spar";

		int airportOccurences = 0;

		String line = null;
		int number = 2;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			PrintWriter writer = new PrintWriter("demoOutput.txt", "UTF-8");

			while ((line = bufferedReader.readLine()) != null) {
				if (line.equals("FineParametriAPT")) {
					String printLine = number++ + " " + bufferedReader.readLine();
					System.out.println(printLine);
					writer.println(printLine);
				}
			}

			// Always close files.
			writer.close();
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}
}
