package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class SymptomWriterDataToFile implements ISymptomWriter {
	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to the file where symptoms with counts will be written
	 */
	public SymptomWriterDataToFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Writes to file the list of symptoms with counts
	 * File is overwritten
	 * 
	 * @param symptoms symptoms  Map with lists of symptoms and counts
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		FileWriter writer;
		try {
			writer = new FileWriter (filepath);
			for(Map.Entry m:symptoms.entrySet()){    
				writer.write(m.getKey()+" :"+m.getValue()+ "\n");
			} 
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
