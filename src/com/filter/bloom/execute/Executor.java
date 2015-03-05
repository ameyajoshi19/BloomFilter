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
		String[] disallowedStrings = {"test", "code", "Ameya"};
		String[] testStrings = {"This", "is", "a", "test", "Code", "written", "by", "Ameya"};
		
		BloomFilter filter = new BloomFilter();
		
		System.out.println("Adding disallowed string to the filer...");
		for(String disallowed : disallowedStrings) {
			System.out.println("Adding: " + disallowed);
			filter.add(disallowed.toLowerCase());
		}
		
		System.out.println("\nTesting strings from the test strings...");
		for(String test : testStrings) {
			System.out.print("String: '" + test + "' -> " + (filter.isDisallowed(test.toLowerCase()) ? "disallowed" : "allowed"));
			System.out.println();
		}
		
	}
}
