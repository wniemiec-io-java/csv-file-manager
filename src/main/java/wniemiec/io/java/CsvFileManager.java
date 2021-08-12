/**
 * Copyright (c) William Niemiec.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package wniemiec.io.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Responsible for handling CSV files.
 * 
 * @author		William Niemiec &lt; williamniemiec@hotmail.com &gt;
 */
public class CsvFileManager {
	
	//-------------------------------------------------------------------------
	//		Attributes
	//-------------------------------------------------------------------------
	private File csvFile;
	
	
	//-------------------------------------------------------------------------
	//		Constructor
	//-------------------------------------------------------------------------
	/**
	 * Handles CSV files. 
	 * 
	 * @param		directory Directory where CSV will be stored
	 * @param		filename CSV filename (without '.csv')
	 * 
	 * @throws		IllegalArgumentException If directory or filename is null
	 */
	public CsvFileManager(File directory, String filename) {
		if (directory == null)
			throw new IllegalArgumentException("Directory cannot be null");
		
		if (filename == null)
			throw new IllegalArgumentException("Filename cannot be null");
		
		csvFile = new File(directory, filename + ".csv");
	}
	
	
	//-------------------------------------------------------------------------
	//		Methods
	//-------------------------------------------------------------------------
	/**
	 * Reads exported CSV file and returns a Map with its content.
	 * 
	 * @param		separator Symbol that separates items
	 *
	 * @return		Matrix with CSV content
	 * 
	 * @throws		IOException If CSV file cannot be read
	 * @throws		IllegalArgumentException If separator is null
	 */
	public List<List<String>> readLines(String separator) throws IOException {
		if (separator == null)
			throw new IllegalArgumentException("Separator cannot be null");
		
		List<List<String>> content = new ArrayList<>();
		String line;
		
		try (BufferedReader csv = new BufferedReader(new FileReader(csvFile))) {
			while ((line = csv.readLine()) != null) {
				content.add(stringToList(line, separator));
			}
		}
		
		return content;
	}
	
	private List<String> stringToList(String str, String separator) {
		return Arrays.asList(str.split(separator));
	}
	
	/**
	 * Reads exported CSV file and returns a Map with its content. Using this
	 * method, separator will be a comma.
	 *
	 * @return		Matrix with CSV content
	 * 
	 * @throws		IOException If CSV file cannot be read 
	 */
	public List<List<String>> readLines() throws IOException {
		return readLines(",");
	}

	/**
	 * Writes a content to a CSV file. Using this method, separator will be a 
	 * comma.
	 * 
	 * @param		lines Content to be written (lines)
	 * 
	 * @throws		IOException If an error occurs while writing the file 
	 * @throws		IllegalArgumentException If content is null
	 */
	public void writeLines(List<List<String>> lines) throws IOException {
		if (lines == null)
			throw new IllegalArgumentException("Content cannot be null");
		
		for (List<String> line : lines) {
			writeLine(line);
		}
	}
	
	/**
	 * Writes a content to a CSV file. Using this method, separator will be a 
	 * comma.
	 * 
	 * @param		line Content to be written (line)
	 * 
	 * @throws		IOException If an error occurs while writing the file 
	 * @throws		IllegalArgumentException If content is null
	 */
	public void writeLine(List<String> line) throws IOException {
		writeLine(line, ",");
	}
	
	/**
	 * Writes a content to a CSV file.
	 * 
	 * @param		line Content to be written (line)
	 * @param		separator Symbol that separates items
	 * 
	 * @throws		IOException If an error occurs while writing the file 
	 * @throws		IllegalArgumentException If content or separator is null
	 */
	public void writeLine(List<String> line, String separator) throws IOException {
		if (line == null)
			throw new IllegalArgumentException("Content cannot be null");
		
		if (separator == null)
			throw new IllegalArgumentException("Separator cannot be null");
		
		try (BufferedWriter csv = new BufferedWriter(new FileWriter(csvFile, csvFile.exists()))) {
			csv.write(listToString(line, separator));
			csv.newLine();
		}
	}

	/**
	 * Writes a content to a CSV file. Using this method, separator will be a 
	 * comma.
	 * 
	 * @param		lines Content to be written (lines)
	 * @param		separator Symbol that separates items
	 * 
	 * @throws		IOException If an error occurs while writing the file 
	 * @throws		IllegalArgumentException If content is null
	 */
	public void writeLines(List<List<String>> lines, String separator) throws IOException {
		if (lines == null)
			throw new IllegalArgumentException("Content cannot be null");

		if (separator == null)
			throw new IllegalArgumentException("Separator cannot be null");
		
		for (List<String> line : lines) {
			writeLine(line, separator);
		}
	}
	
	private String listToString(List<String> list, String separator) {
		StringBuilder str = new StringBuilder();

		for (String element : list) {
			str.append(element);
			str.append(separator);
		}
			
		// Removes last separator
		str = str.deleteCharAt(str.length()-1);
		
		return str.toString();
	}
	
	public void delete() {
		csvFile.delete();
	}
	
	public boolean exists() {
		return csvFile.exists();
	}
	
	
	//-------------------------------------------------------------------------
	//		Getters
	//-------------------------------------------------------------------------
	public String getAbsolutePath() {
		return csvFile.getAbsolutePath();
	}
}
