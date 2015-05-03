package com.filter.bloom.hash.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import com.filter.bloom.hash.HashFunction;
import com.filter.bloom.hash.util.CalculationUtility;

public class SHA512HashAlgorithm implements HashFunction {

	private static final Logger logger = Logger.getLogger(SHA512HashAlgorithm.class.getName());
	private static final String SHA512_ALGO_NAME = "SHA-512";
	
	@Override
    public int hashWithMod(String text) throws UnsupportedEncodingException {
		MessageDigest algorithm = null;
		try {
	        algorithm = MessageDigest.getInstance(SHA512_ALGO_NAME);
        } catch (NoSuchAlgorithmException e) {
	        logger.info("Could not find " + SHA512_ALGO_NAME + " in the Java library.");
        }
		algorithm.update(text.getBytes("UTF-8"));
		byte[] byteHash = algorithm.digest();
		int hash = CalculationUtility.modWithFilterSize(CalculationUtility.byteArrayToInt(byteHash));
	    return hash;
    }
}
