package com.jonstaff.java.hashtable;

//  Created by jonstaff on 1/25/14.
//  Adapted from http://www.simonfoucher.com/McGill/COMP250/Assignments/ass4/Question3/HashTable.java

import java.util.ArrayList;
import java.util.LinkedList;

public class Hashtable<V> {

	private ArrayList<LinkedList<HashEntry>> buckets;
	private HashFunction hashFunction;
    private int numBuckets;
	private int itemCount = 0;

	public Hashtable(int numBuckets, HashFunction hashFunction) {

		buckets = new ArrayList<LinkedList<HashEntry>>(numBuckets);

        this.numBuckets = numBuckets;
		this.hashFunction = hashFunction;

		for (int i = 0; i < numBuckets; i++) {
			buckets.add(new LinkedList<HashEntry>());
		}
	}

	/**
	 * Adds a key-value pair to the hash table.
	 * 
	 * @param key
	 *            The key to add
	 * @param value
	 *            The value to add
	 */
	public void put(String key, V value) {
		int oldIndex;

		int hashKey = (int) hashFunction.hash(key) % numBuckets;

		if (hashKey < 0) {
			hashKey = -hashKey;
		}

		HashEntry newEntry = new HashEntry(key, value);

		if ((oldIndex = buckets.get(hashKey).indexOf(newEntry)) == -1) {
			buckets.get(hashKey).add(newEntry);
			itemCount++;
		} else {
			buckets.get(hashKey).set(oldIndex, newEntry);
		}
	}

	/**
	 * Retrieves a value associated with some given key in the hash table.
	 * 
	 * @param key
	 *            The key whose value to retrieve
	 * @return The value associated with the provided key (and null if the key could not be found in the hash table)
	 */
	public V get(String key) {
		LinkedList<HashEntry> chain = buckets.get((int) hashFunction.hash(key) % numBuckets);

		for (int i = 0; i < chain.size(); i++) {
			if (chain.get(i).getKey().equals(key)) {
				return chain.get(i).getValue();
			}
		}

		return null;
	}

	/**
	 * Removes a key-value pair from the hash table.
	 * 
	 * @param key
	 *            The key to remove
	 * @return The value associated with the provided key, and null if no match is found.
	 */
	public V remove(String key) {
		V returnValue = null;
        LinkedList<HashEntry> chain = buckets.get((int) hashFunction.hash(key) % numBuckets);

		for (int i = 0; i < chain.size(); i++) {
			if (chain.get(i).getKey().equals(key)) {
                returnValue = chain.get(i).getValue();
                buckets.get((int) hashFunction.hash(key) % numBuckets).remove(i);
                itemCount--;
			}
		}

		return returnValue;
	}

	public int countCollisions() {
		int collisions = 0;

		for (int i = 0; i < numBuckets; i++) {
			if (buckets.get(i).size() > 1) {
				collisions += buckets.get(i).size() - 1;
			}
		}

		return collisions;
	}

	public int findDepthOfBucket(int bucketNumber) {
		return buckets.get(bucketNumber).size();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buckets.size(); i++) {
			sb.append("Bucket ");
			sb.append(i);
			sb.append(" has ");
			sb.append(buckets.get(i).size());
			sb.append(" items.\n");
		}
		sb.append("There are ");
		sb.append(itemCount);
		sb.append(" items in the hash table altogether.");
		return sb.toString();
	}

	public class HashEntry {

		private String key;
		private V value;

		public HashEntry(String key, V value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}
}