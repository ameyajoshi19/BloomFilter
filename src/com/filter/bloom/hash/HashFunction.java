package com.filter.bloom.hash;

import java.io.UnsupportedEncodingException;

/**
 * <p>
 * Interface for hash functions.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public interface HashFunction {

	/* Hashing function. */
	public int hashWithMod(String text) throws UnsupportedEncodingException;
}
