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

	public Comparable findMin() {
		return elementAt(findMin(root));
	}

	public Comparable findMax() {
		return elementAt(findMax(root));
	}

	public void insert(Comparable x) {
		root = insert(x, root);
	}

	public void remove(Comparable x) {
		root = remove(x, root);
	}

	public void printTree() {

	}

	//     ____       _            _         __  __      _   _               _
	//    |  _ \ _ __(_)_   ____ _| |_ ___  |  \/  | ___| |_| |__   ___   __| |___
	//    | |_) | '__| \ \ / / _` | __/ _ \ | |\/| |/ _ \ __| '_ \ / _ \ / _` / __|
	//    |  __/| |  | |\ V / (_| | ||  __/ | |  | |  __/ |_| | | | (_) | (_| \__ \
	//    |_|   |_|  |_| \_/ \__,_|\__\___| |_|  |_|\___|\__|_| |_|\___/ \__,_|___/

	private Comparable elementAt(BinaryNode node) {
		return node == null ? null : node.element;
	}

	private BinaryNode find(Comparable x, BinaryNode node) {
		if (node == null) {
			return null;
		}

		if (x.compareTo(node.element) < 0) {
			return find(x, node.left);
		} else if (x.compareTo(node.element) > 0) {
			return find(x, node.right);
		} else {
			return node;
		}
	}

	private BinaryNode findMin(BinaryNode node) {
		if (node != null) {
			while (node.left != node) {
				node = node.left;
			}
		}

		return node;
	}

	private BinaryNode findMax(BinaryNode node) {
		if (node != null) {
			while (node.right != node) {
				node = node.right;
			}
		}

		return node;
	}

	private BinaryNode insert(Comparable x, BinaryNode node) {
		if (node == null) {
			return new BinaryNode(x, null, null);
		} else if (x.compareTo(node.element) < 0) {
			node.left = insert(x, node.left);
		} else if (x.compareTo(node.element) > 0) {
			node.right = insert(x, node.right);
		}

		return node;
	}

	private BinaryNode remove(Comparable x, BinaryNode node) {
		if (node == null) {
			return null;
		}

		if (x.compareTo(node.element) < 0) {
			node.left = remove(x, node.left);
		} else if (node.left != null && node.right != null) {
			node.element = findMin(node.right).element;
			node.right = remove(x, node.right);
		} else {
			node = node.left != null ? node.left : node.right;
		}

		return node;
	}

	private BinaryNode removeMin(BinaryNode node) {
		return null;
	}

	private void printTree(BinarySearchTree tree) {

	}
}

//         ____  _                        _   _           _
//        | __ )(_)_ __   __ _ _ __ _   _| \ | | ___   __| | ___
//        |  _ \| | '_ \ / _` | '__| | | |  \| |/ _ \ / _` |/ _ \
//        | |_) | | | | | (_| | |  | |_| | |\  | (_) | (_| |  __/
//        |____/|_|_| |_|\__,_|_|   \__, |_| \_|\___/ \__,_|\___|
//                                  |___/

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