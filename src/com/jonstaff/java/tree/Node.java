package com.jonstaff.java.tree;

//  Created by jonstaff on 2/1/14.

public class Node {
	Comparable element;
	Node left, right;

	protected Node(Comparable element) {
		this(element, null, null);
	}

	protected Node(Comparable element, Node left, Node right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}
}
