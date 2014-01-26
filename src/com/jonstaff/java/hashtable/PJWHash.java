package com.jonstaff.java.hashtable;

//  Created by jonstaff on 1/26/14.
//  Adapted from http://www.partow.net/programming/hashfunctions/

public class PJWHash implements HashFunction {
	@Override
	public long hash(String key) {
		long BitsInUnsignedInt = (long) (4 * 8);
		long ThreeQuarters = ((BitsInUnsignedInt * 3) / 4);
		long OneEighth = (BitsInUnsignedInt / 8);
		long HighBits = (long) (0xFFFFFFFF) << (BitsInUnsignedInt - OneEighth);
		long hash = 0;
		long test = 0;

		for (int i = 0; i < key.length(); i++) {
			hash = (hash << OneEighth) + key.charAt(i);

			if ((test = hash & HighBits) != 0) {
				hash = ((hash ^ (test >> ThreeQuarters)) & (~HighBits));
			}
		}

		return hash;
	}
}
