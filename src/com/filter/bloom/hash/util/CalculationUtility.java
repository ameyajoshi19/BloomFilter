package com.filter.bloom.hash.util;

import com.filter.bloom.impl.BloomFilter;

/**
 * <p>
 * This class has utility functions to be used for conversion.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public class CalculationUtility {

	/**
	 * This method converts a byte array to an integer.
	 */
	public static int byteArrayToInt(byte[] encodedValue) {
	    int index = 0;
	    int value = encodedValue[index++] << Byte.SIZE * 3;
	    value ^= (encodedValue[index++] & 0xFF) << Byte.SIZE * 2;
	    value ^= (encodedValue[index++] & 0xFF) << Byte.SIZE * 1;
	    value ^= (encodedValue[index++] & 0xFF);
	    return value;
	}
	
	/**
	 * This method takes mod of the given integer with the filter size and then returns the absolute value.
	 */
	public static int modWithFilterSize(int hash) {
		return Math.abs(hash % BloomFilter.FILTER_SIZE);
	}
}
