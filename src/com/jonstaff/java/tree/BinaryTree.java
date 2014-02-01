package com.jonstaff.java.tree;

//  Created by jonstaff on 2/1/14.

public abstract class BinaryTree {

	Node root;

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public abstract Comparable find(Comparable x);

	public abstract Comparable findMin();

	public abstract Comparable findMax();

	public abstract void insert(Comparable x);

	public abstract void remove(Comparable x);

	public abstract void printTree();
}
