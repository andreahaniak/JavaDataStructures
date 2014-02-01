package com.jonstaff.java.hashtable;

//  Created by jonstaff on 1/26/14.
//  Adapted from http://www.partow.net/programming/hashfunctions/

public class SdbmHash implements HashFunction {
	@Override
	public long hash(String key) {
		long hash = 0;

		for (int i = 0; i < key.length(); i++) {
			hash = key.charAt(i) + (hash << 6) + (hash << 16) - hash;
		}

		return hash;
	}
}
