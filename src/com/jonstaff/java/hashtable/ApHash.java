package com.jonstaff.java.hashtable;

//  Created by jonstaff on 1/26/14.
//  Adapted from http://www.partow.net/programming/hashfunctions/

public class ApHash implements HashFunction {
	@Override
	public long hash(String key) {
		long hash = 0xAAAAAAAA;

		for (int i = 0; i < key.length(); i++) {
			if ((i & 1) == 0) {
				hash ^= ((hash << 7) ^ key.charAt(i) * (hash >> 3));
			} else {
				hash ^= (~((hash << 11) + key.charAt(i) ^ (hash >> 5)));
			}
		}

		return hash;
	}
}
