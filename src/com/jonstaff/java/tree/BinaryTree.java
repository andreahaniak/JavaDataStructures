package com.jonstaff.java.tree;

//  Created by jonstaff on 2/1/14.

public abstract class BinaryTree<T> {

	T root;

	public abstract Comparable find(Comparable x);

	public abstract Comparable findMin();

	public abstract Comparable findMax();

	public abstract void insert(Comparable x);

	public abstract void remove(Comparable x);

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void printTree() {
		if (isEmpty()) {
			System.out.println("The tree is empty.");
		} else {
			printTree((Node) root);
		}
	}

	private void printTree(Node t) {
		if (t != null) {
			printTree((Node) t.left);
			System.out.println(t.element);
			printTree((Node) t.right);
		}
	}
}
