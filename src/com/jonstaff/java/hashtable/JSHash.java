package com.jonstaff.java.hashtable;

//  Created by jonstaff on 1/26/14.
//  Adapted from http://www.partow.net/programming/hashfunctions/

public class JSHash implements HashFunction {
	@Override
	public long hash(String key) {
		long hash = 1315423911;

		for (int i = 0; i < key.length(); i++) {
			hash ^= ((hash << 5) + key.charAt(i) + (hash >> 2));
		}

		return hash;
	}
}
