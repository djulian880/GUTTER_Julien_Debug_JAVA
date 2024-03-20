package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	ISymptomReader reader;
	ISymptomWriter writer;
	
	public static void main(String args[]) throws Exception {
		AnalyticsCounter comptage=new AnalyticsCounter(new ReadSymptomDataFromFile("/Users/juliengutter/git/GUTTER_Julien_Debug_JAVA/Project02Eclipse/symptoms.txt"),
				new SymptomWriterDataToFile("/Users/juliengutter/Documents/result.out"));
		comptage.writeSymptoms(comptage.sortSymptoms(comptage.countSymptoms(comptage.getSymptoms())));
	}
	
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader=reader;
		this.writer=writer;
	}
	
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}
	
	public Map<String, Integer>	countSymptoms(List<String> symptoms) {
		Map<String,Integer> map=new HashMap<String,Integer>(); 
		for(String symptome:symptoms) { 
			  if(map.containsKey(symptome)) {
					int j;
					j=map.get(symptome);
					j++;
					map.replace(symptome, j);
								
				}
				else {
					map.put(symptome, 1);
				}
		}  
		return map;
	}
	
	public Map<String, Integer>	sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<String,Integer>(symptoms); 
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
	
}
