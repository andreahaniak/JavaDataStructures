package com.jonstaff.java.hashtable;

//  Created by jonstaff on 1/26/14.
//  Adapted from http://www.partow.net/programming/hashfunctions/

public class RsHash implements HashFunction {

    @Override
    public long hash(String key) {
        int b = 378551;
        int a = 63689;
        long hash = 0;

        for (int i = 0; i < key.length(); i++) {
            hash = hash * a + key.charAt(i);
            a = a * b;
        }

        return hash;
    }
}
