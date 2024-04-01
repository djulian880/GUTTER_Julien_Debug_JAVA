package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
* Provides the necessary methods to open a source of symptoms and return and ordered list of symptoms with number
* of occurrences for each symptom 
* 
* @author Hemebiotech
* 
*/
public class AnalyticsCounter {
	ISymptomReader reader;
	ISymptomWriter writer;
	
	/**
	* Main method for execution
	*  
	* @param args Not used
	* @throws Exception of every kind
	*/
	public static void main(String args[]) throws Exception {
		System.out.println("Démarrage");
		AnalyticsCounter coounter=new AnalyticsCounter(new ReadSymptomDataFromFile("/Users/juliengutter/git/GUTTER_Julien_Debug_JAVA/Project02Eclipse/symptoms.txt"),
				new SymptomWriterDataToFile("/Users/juliengutter/git/GUTTER_Julien_Debug_JAVA/Project02Eclipse/result.out"));
		coounter.writeSymptoms(coounter.sortSymptoms(coounter.countSymptoms(coounter.getSymptoms())));
		System.out.println("Fin");
	}
	
	/**
	* Affects the sources to read from and write to
	* 
	* @param reader class used to provide the raw list of symtpoms
	* @param writer class used to write the final list of symptoms with counts
	*/
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader=reader;
		this.writer=writer;
	}
	
	/**
	* Returns a list with symptoms from a file
	* 
	* @return  lists of symptoms, one symptom by entry from the reader declared in Class
	*/
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}
	
	/**
	* Returns a list unordered with symptoms as key and number of occurrences as value from the list passed in parameter
	* 
	* @param  symptoms  lists of symptoms, one symptom by line
	* @return list with symptom as key and number of occurrence for each symptom as value 
	*/
	public Map<String, Integer>	countSymptoms(List<String> symptoms) {
		Map<String,Integer> map=new HashMap<String,Integer>(); 
		for(String symptom:symptoms) { 
			  if(map.containsKey(symptom)) {
					int j;
					j=map.get(symptom);
					j++;
					map.replace(symptom, j);					
				}
				else {
					map.put(symptom, 1);
				}
		}  
		System.out.println("Nombre d'éléments dans la liste: "+map.size());
		return map;
	}
	
	/**
	* Returns an alphabetically ordered list from the list passed in parameter
	* 
	* @param  symptoms  lists of symptoms with counts unordered
	* @return the sorted Map
	*/
	public Map<String, Integer>	sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<String,Integer>(symptoms); 
	}
	
	/**
	* Writes the list of symptoms with counts using the SymptomWriter declared in the class
	* 
	* @param  symptoms  Map with lists of symptoms and counts
	*/
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
	
}
