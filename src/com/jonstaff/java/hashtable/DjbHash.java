package com.jonstaff.java.hashtable;

//  Created by jonstaff on 1/26/14.
//  Adapted from http://www.partow.net/programming/hashfunctions/

public class DjbHash implements HashFunction {
	@Override
	public long hash(String key) {
		long hash = 5381;

		for (int i = 0; i < key.length(); i++) {
			hash = ((hash << 5) + hash) + key.charAt(i);
		}

		return hash;
	}
}
