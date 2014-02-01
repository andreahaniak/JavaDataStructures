package com.jonstaff.java.tree;

//  Created by jonstaff on 1/31/14.
//  Adapted from Data Structures & Algorithm Analysis in Java by Mark Allen Weiss

public class BinarySearchTree {
	private BinaryNode root;

	public BinarySearchTree() {
		root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public Comparable find(Comparable x) {
		return elementAt(find(x, root));
	}

    public void remove(Comparable x) {
        root = remove(x, root);
    }

    public void printTree() {
        
    }

	// private methods
	private Comparable elementAt(BinaryNode node) {
		return node == null ? null : node.element;
	}

	private BinaryNode find(Comparable x, BinaryNode node) {
		return null;
	}

	private BinaryNode findMin(BinaryNode node) {
		return null;
	}

	private BinaryNode insert(Comparable x, BinaryNode node) {
		return null;
	}

	private BinaryNode remove(Comparable x, BinaryNode node) {
		return null;
	}

	private BinaryNode removeMin(BinaryNode node) {
		return null;
	}

	private void printTree(BinarySearchTree tree) {

	}
}

class BinaryNode {
	Comparable element;
	BinaryNode left;
	BinaryNode right;

	BinaryNode(Comparable element) {
		this(element, null, null);
	}

	BinaryNode(Comparable element, BinaryNode left, BinaryNode right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}
}