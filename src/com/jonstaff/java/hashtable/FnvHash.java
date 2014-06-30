package com.jonstaff.java.hashtable;

//  Created by jonstaff on 1/26/14.
//  Adapted from http://www.partow.net/programming/hashfunctions/

public class FnvHash implements HashFunction {
    @Override
    public long hash(String key) {
        long fnv_prime = 0x811C9DC5;
        long hash = 0;

        for (int i = 0; i < key.length(); i++) {
            hash *= fnv_prime;
            hash ^= key.charAt(i);
        }

        return hash;
    }
}
