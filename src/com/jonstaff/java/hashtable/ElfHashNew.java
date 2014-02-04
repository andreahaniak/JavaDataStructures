package com.jonstaff.java.hashtable;

//  Created by jonstaff on 1/26/14.
//  Adapted from http://www.partow.net/programming/hashfunctions/

public class ElfHashNew implements HashFunction {
	@Override
	public long hash(String key) {
		long hash = 0;
		long x = 0;

		for (int i = 0; i < key.length(); i++) {
			hash = (hash << 4) + key.charAt(i);

			if ((x = hash & 0xF0000000L) != 0) {
				hash ^= (x >> 24);
			}
			hash &= ~x;
		}

		return hash;
	}
}
