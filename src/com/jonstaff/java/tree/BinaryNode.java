package com.jonstaff.java.tree;

//  Created by jonstaff on 2/3/14.

public class BinaryNode extends Node<BinaryNode> {
	BinaryNode(Comparable element) {
		this(element, null, null);
	}

	BinaryNode(Comparable element, BinaryNode left, BinaryNode right) {
		this.element = element;
		this.left = left;
		this.right = left;
	}
}
