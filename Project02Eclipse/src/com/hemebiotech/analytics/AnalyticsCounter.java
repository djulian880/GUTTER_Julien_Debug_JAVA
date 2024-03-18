package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("/Users/juliengutter/git/GUTTER_Julien_Debug_JAVA/Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();
		TreeMap<String,Integer> map=new TreeMap<String,Integer>(); 
		
		while (line != null) {
			// Correction du code
			System.out.println("symptom from file: " + line);
			  
			
			if(map.containsKey(line)) {
				int j;
				j=map.get(line);
				j++;
				map.replace(line, j);
				System.out.println("Déja présent ");
				
			}
			else {
				
				map.put(line, 1);
				System.out.println("Nouveau");
			}
			line = reader.readLine();	// get another symptom
		}
		reader.close();
		
		// next generate outpout
		
		
		System.out.println("Résultat final:"); 
		FileWriter writer = new FileWriter ("/Users/juliengutter/result.out");
		 
		for(Map.Entry m:map.entrySet()){    
			System.out.println(m.getKey()+" :"+m.getValue());    
			writer.write(m.getKey()+" :"+m.getValue()+ "\n");
			
		} 
		writer.close();
		
	}
}
