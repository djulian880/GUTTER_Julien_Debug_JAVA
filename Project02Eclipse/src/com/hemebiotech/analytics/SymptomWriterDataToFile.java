package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class SymptomWriterDataToFile implements ISymptomWriter {
	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public SymptomWriterDataToFile (String filepath) {
		this.filepath = filepath;
	}
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
