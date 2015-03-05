package com.filter.bloom.impl;

import java.io.UnsupportedEncodingException;

import com.filter.bloom.hash.HashFunction;
import com.filter.bloom.hash.impl.MD5HashAlgorithm;
import com.filter.bloom.hash.impl.SHA1HashAlgorithm;

/**
 * <p>
 * This class implements the Bloom Filter.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public class BloomFilter {

	public static final int FILTER_SIZE = 128;
	private static HashFunction[] HASH_FUNCTIONS = {new MD5HashAlgorithm(), new SHA1HashAlgorithm()};
	
	private int[] BLOOM_FILTER = new int[FILTER_SIZE]; 
	
	/**
	 * This method is used to add *disallowed* words to the bloom filter.
	 * @throws UnsupportedEncodingException 
	 */
	public void add(String text) throws UnsupportedEncodingException {
		for(HashFunction hf : HASH_FUNCTIONS) {
			BLOOM_FILTER[hf.hashWithMod(text)]++;
		}
	}
	
	/**
	 * This method is used to *remove* a disallowed word from the bloom filter.
	 * @throws UnsupportedEncodingException 
	 */
	public void remove(String text) throws UnsupportedEncodingException {
		for(HashFunction hf : HASH_FUNCTIONS) {
			BLOOM_FILTER[hf.hashWithMod(text)]--;
		}
	}
	
	/**
	 * This method tests a given word to check whether it is disallowed or not.
	 * @param String
	 * 			- the word
	 * @return boolean
	 * 			- whether the word is disallowed or not.
	 * @throws UnsupportedEncodingException 
	 */
	public boolean isDisallowed(String test) throws UnsupportedEncodingException {
		for(HashFunction hf : HASH_FUNCTIONS) {
			if(BLOOM_FILTER[hf.hashWithMod(test)] == 0) {
				return false;
			}
		}
		return true;
	}
}
