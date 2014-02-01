package com.jonstaff.java.tree;

//  Created by jonstaff on 2/1/14.
//  Adapted from Data Structures & Algorithm Analysis in Java by Mark Allen Weiss

public class AVLTree {


}

class AVLNode {
	Comparable element;
	AVLNode left, right;
	int height;

	AVLNode(Comparable element) {
		this(element, null, null);
	}

	AVLNode(Comparable element, AVLNode left, AVLNode right) {
		this.element = element;
		this.left = left;
		this.right = right;
        height = 0;
	}
}