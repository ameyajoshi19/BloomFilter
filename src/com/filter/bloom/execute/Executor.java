package com.filter.bloom.execute;

import java.io.UnsupportedEncodingException;

import com.filter.bloom.impl.BloomFilter;

/**
 * <p>
 * This is a demo class to run the bloom filter.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public class Executor {

	public static void main(String args[]) throws UnsupportedEncodingException {
		String[] disallowedStrings = {"shit", "crap", "bullshit"};
		String testSentence = "This bullshit and crap code is written by Ameya";
		
		BloomFilter filter = new BloomFilter();
		
		System.out.println("Adding disallowed strings to the filer...");
		for(String disallowedString : disallowedStrings) {
			System.out.println("Adding: " + disallowedString);
			filter.add(disallowedString.toLowerCase());
		}
		
		System.out.println("\nTesting strings from the test strings...");
		System.out.println("Original sentence: " + testSentence);
		String[] testStrings = testSentence.split(" ");
		System.out.print("Filtered sentence: ");
		for(String current : testStrings) {
			System.out.print(filter.isDisallowed(current.toLowerCase()) ? "" : (current + " "));
		}
		
	}
}
