package com.hemebiotech.analytics;

import java.util.Map;
/**
 * Anything that will write symptom data from a list with the number of occurrences for each symptom
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomWriter {
	/**
	 * Write symptoms with counts
	 * @param symptoms symptoms  Map with lists of symptoms and counts
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
}
