package com.jonstaff.java.tree;

//  Created by jonstaff on 1/22/14.

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
						System.out.println("Node added");
						return;
					}
				} else {
					focus = focus.rightChild;

					if (focus == null) {
						parent.rightChild = newNode;
						System.out.println("Node added");
						return;
					}
				}
			}
		}

		System.out.println("Node added");
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

	public static void main(String[] args) {
		System.out.println("the program is starting");

		BinaryTree tree = new BinaryTree();

		tree.addNode(1, "Jonathon");
		tree.addNode(10, "Paul");
		tree.addNode(9, "Viddi");
		tree.addNode(51, "Chloe");
		tree.addNode(67, "Bob");
		tree.addNode(98, "Sam");
		tree.addNode(13, "Jim");
		tree.addNode(8, "John");
		tree.addNode(23, "Jack");
		tree.addNode(91, "Jill");
		tree.addNode(18, "Betty");

		tree.inOrderTraversal(tree.root);
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
