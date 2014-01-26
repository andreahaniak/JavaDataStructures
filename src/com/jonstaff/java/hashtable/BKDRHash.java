package com.jonstaff.java.hashtable;

//  Created by jonstaff on 1/26/14.
//  Adapted from http://www.partow.net/programming/hashfunctions/

public class BKDRHash implements HashFunction {
	@Override
	public long hash(String key) {
		long seed = 131; // 31 131 1313 13131 131313 etc..
		long hash = 0;

		for (int i = 0; i < key.length(); i++) {
			hash = (hash * seed) + key.charAt(i);
		}

		return hash;
	}
}
