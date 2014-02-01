package com.jonstaff.java.tree;

//  Created by jonstaff on 2/1/14.
//  Adapted from Data Structures & Algorithm Analysis in Java by Mark Allen Weiss

public class AvlTree {

	private static int heightOf(AvlNode t) {
		return t == null ? -1 : t.height;
	}

	private AvlNode insert(Comparable x, AvlNode t) {
		if (t == null) {
			t = new AvlNode(x);
		} else if (x.compareTo(t.element) < 0) {
			t.left = insert(x, t.left);

			if (heightOf(t.left) - heightOf(t.right) == 2) {
				if (x.compareTo(t.left.element) < 0) {
                    t = 
				}
			}
		}
	}

	private static AvlNode rotateWithLeftChild(AvlNode k2) {
		AvlNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(heightOf(k2.left), heightOf(k2.right)) + 1;
		k1.height = Math.max(heightOf(k1.left), k2.height) + 1;
		return k1;
	}

	private static AvlNode rotateWithRightChild(AvlNode k2) {
		// TODO: refactor this to work with the right child
		AvlNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(heightOf(k2.left), heightOf(k2.right)) + 1;
		k1.height = Math.max(heightOf(k1.left), k2.height) + 1;
		return k1;
	}

	private static AvlNode doubleWithLeftChild(AvlNode k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	private static AvlNode doubleWithRightChild(AvlNode k3) {
		k3.right = rotateWithLeftChild(k3.right);
		return rotateWithRightChild(k3);
	}

    // TODO: deletion
}

class AvlNode {
	Comparable element;
	AvlNode left, right;
	int height;

	AvlNode(Comparable element) {
		this(element, null, null);
	}

	AvlNode(Comparable element, AvlNode left, AvlNode right) {
		this.element = element;
		this.left = left;
		this.right = right;
		height = 0;
	}
}