package com.jonstaff.java.tree;

//  Created by jonstaff on 1/22/14.
//  Adapted from http://www.youtube.com/watch?v=M6lYob8STMI
public class BinaryTree {

	private Node root;

	public void addNode(int key, Object value) {
		Node newNode = new Node(key, value);

		if (root == null) {
			root = newNode;
		} else {
			Node focus = root;
			Node parent;

			while (true) {
				parent = focus;

				if (key < focus.key) {
					focus = focus.leftChild;

					if (focus == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focus = focus.rightChild;

					if (focus == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void inOrderTraversal(Node focusNode) {
		if (focusNode != null) {
			inOrderTraversal(focusNode.leftChild);
			System.out.println(focusNode.toString());
			inOrderTraversal(focusNode.rightChild);
		}
	}

	public void preorderTraversal(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode);
			preorderTraversal(focusNode.leftChild);
			preorderTraversal(focusNode.rightChild);
		}
	}

	public void postOrderTraversal(Node focusNode) {
		if (focusNode != null) {
			postOrderTraversal(focusNode.leftChild);
			postOrderTraversal(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}

	public Node getRoot() {
		return root;
	}
}

class Node {
	int key;
	Object value;

	Node leftChild, rightChild;

	Node(int key, Object value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node{" + "key=" + key + ", value=" + value + ", leftChild=" + leftChild + ", rightChild=" + rightChild + '}';
	}
}
