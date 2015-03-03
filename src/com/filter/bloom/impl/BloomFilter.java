package com.filter.bloom.impl;

import com.filter.bloom.hash.HashFunction;
import com.filter.bloom.hash.impl.CrcHashAlgorithm;
import com.filter.bloom.hash.impl.Sha1HashAlgorithm;

/**
 * <p>
 * This class implements the Bloom Filter.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public class BloomFilter {

	private static final int FILTER_SIZE = 128;
	private static HashFunction[] HASH_FUNCTIONS = {new CrcHashAlgorithm(), new Sha1HashAlgorithm()};
	
	private int[] BLOOM_FILTER = new int[FILTER_SIZE]; 
	
	/**
	 * This method is used to add *disallowed* words to the bloom filter.
	 */
	public void add(String text) {
		for(HashFunction hf : HASH_FUNCTIONS) {
			BLOOM_FILTER[hf.hashWithMod(text)]++;
		}
	}
	
	/**
	 * This method is used to *remove* a disallowed word from the bloom filter.
	 */
	public void remove(String text) {
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
	 */
	public boolean isDisallowed(String test) {
		for(HashFunction hf : HASH_FUNCTIONS) {
			if(BLOOM_FILTER[hf.hashWithMod(test)] == 0) {
				return false;
			}
		}
		return true;
	}
}
