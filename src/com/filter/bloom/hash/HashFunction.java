package com.filter.bloom.hash;

/**
 * <p>
 * Interface for hash functions.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public interface HashFunction {

	/* Hashing function. */
	public int hashWithMod(String text);
}
