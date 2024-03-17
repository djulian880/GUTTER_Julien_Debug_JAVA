package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("/Users/juliengutter/git/GUTTER_Julien_Debug_JAVA/Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0
		int headCount = 0;	// counts headaches
		
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
		
			
	  
		        
		         
		      
		      
		      
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
		
		
		System.out.println("Résultat final:"); 
		for(Map.Entry m:map.entrySet()){    
			System.out.println(m.getKey()+" "+m.getValue());    
		} 
		
	}
}
