package com.jonstaff.java.hashtable;

//  Created by jonstaff on 1/25/14.
//  Adapted from http://www.simonfoucher.com/McGill/COMP250/Assignments/ass4/Question3/HashTable.java

import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable<V> {

	// A list of buckets to store the key-value pairs in; we are using
	ArrayList<LinkedList<HashEntry>> buckets;

	// The hash function to use to convert keys to integers
	HashFunction hashFunction;

	// The number of entries stored in this hash table
	int itemCount = 0;

	public HashTable(int numBuckets, HashFunction hashFunction) {

		// Create the buckets
		buckets = new ArrayList<LinkedList<HashEntry>>(numBuckets);

		// Record the hash function to use
		this.hashFunction = hashFunction;

		// Fill the buckets with empty Linked lists
		for (int i = 0; i < numBuckets; i++)
			buckets.add(new LinkedList<HashEntry>());

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
		int oldIndex;						// Used to record old index if entry was already there

		// First extract the hash key
		int hashKey = this.hashFunction.hash(key);

		/*
		 * Even with never returning a negative number in getHashCode method, there are a few times when (...?!?) the hashKey still comes up as negative The
		 * following is a measure to stop those situations from making the program crash and do not affect any "normal" operating conditions.
		 */
		if (hashKey < 0)
			hashKey = -hashKey;

		// Create the hash entry object
		HashEntry newEntry = new HashEntry(key, value);

		// Add the element by appending or overwriting
		if ((oldIndex = buckets.get(hashKey).indexOf(newEntry)) == -1) {
			buckets.get(hashKey).add(newEntry);
			itemCount++;
		} else
			buckets.get(hashKey).set(oldIndex, newEntry);

	}

	/**
	 * Retrieves a value associated with some given key in the hash table.
	 * 
	 * @param key
	 *            The key whose value to retrieve
	 * @return The value associated with the provided key (and null if the key could not be found in the hash table)
	 */
	public V get(String key) {
		int i;						// Random counter index

		// First extract the hash key and
		// Grab the bucket with that key
		// (Not necessary, but makes future code more legible
		LinkedList<HashEntry> tempLL = buckets.get(this.hashFunction.hash(key));

		// Then dig out the entry from the bucket and return it if it matches the key
		for (i = 0; i < tempLL.size(); i++)
			if (tempLL.get(i).getKey() == key)
				return tempLL.get(i).getValue();

		// Otherwise, return null
		return null;
	}

	/**
	 * Removes a key-value pair from the hash table.
	 * 
	 * @param key
	 *            The key to remove
	 * @return The value associated with the provided key
	 */
	public V remove(String key) {
		int i;						// Random counter index
		V returnValue = null;				// Hold the return value

		//System.out.println("Removing: "+key);

		// First extract the hash key and
		// Grab the bucket with that key
		// (Not necessary, but makes future code more legible
		LinkedList<HashEntry> tempLL = buckets.get(this.hashFunction.hash(key));

		for (i = 0; i < tempLL.size(); i++)
			if (tempLL.get(i).getKey() == key) {
				// Extract value
				returnValue = tempLL.get(i).getValue();
				// Remove it
				buckets.get(this.hashFunction.hash(key)).remove(i);
				itemCount--;
			}

		return returnValue;
	}

	/*
	 * Function to count the number of collisions when varying parameters. Returns the number of collisions in the hash table by counting the depth of the
	 * buckets
	 */
	public int countCollisions(int numBuckets) {
		// Number of collisions encountered in the Hash table (for Q3e)
		int collisions = 0;

		for (int i = 0; i < numBuckets; i++) {
			if (buckets.get(i).size() > 1)
				collisions += buckets.get(i).size() - 1;
		}

		return collisions;
	}

	/*
	 * Function to look at the spread of values. Returns the depth of the buckets called.
	 */
	public int findDepthOfBucket(int bucketNumber) {
		return buckets.get(bucketNumber).size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
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