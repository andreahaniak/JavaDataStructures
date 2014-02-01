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
		if (isEmpty()) {
			System.out.println("The tree is empty.");
		} else {
			printTree(root);
		}
	}

	//     ____       _            _         __  __      _   _               _
	//    |  _ \ _ __(_)_   ____ _| |_ ___  |  \/  | ___| |_| |__   ___   __| |___
	//    | |_) | '__| \ \ / / _` | __/ _ \ | |\/| |/ _ \ __| '_ \ / _ \ / _` / __|
	//    |  __/| |  | |\ V / (_| | ||  __/ | |  | |  __/ |_| | | | (_) | (_| \__ \
	//    |_|   |_|  |_| \_/ \__,_|\__\___| |_|  |_|\___|\__|_| |_|\___/ \__,_|___/

	private Comparable elementAt(BinaryNode t) {
		return t == null ? null : t.element;
	}

	private BinaryNode find(Comparable x, BinaryNode t) {
		if (t == null) {
			return null;
		}

		if (x.compareTo(t.element) < 0) {
			return find(x, t.left);
		} else if (x.compareTo(t.element) > 0) {
			return find(x, t.right);
		} else {
			return t;
		}
	}

	private BinaryNode findMin(BinaryNode t) {
		if (t != null) {
			while (t.left != t) {
				t = t.left;
			}
		}

		return t;
	}

	private BinaryNode findMax(BinaryNode t) {
		if (t != null) {
			while (t.right != t) {
				t = t.right;
			}
		}

		return t;
	}

	private BinaryNode insert(Comparable x, BinaryNode t) {
		if (t == null) {
			return new BinaryNode(x, null, null);
		} else if (x.compareTo(t.element) < 0) {
			t.left = insert(x, t.left);
		} else if (x.compareTo(t.element) > 0) {
			t.right = insert(x, t.right);
		}

		return t;
	}

	private BinaryNode remove(Comparable x, BinaryNode t) {
		if (t == null) {
			return null;
		}

		if (x.compareTo(t.element) < 0) {
			t.left = remove(x, t.left);
		} else if (t.left != null && t.right != null) {
			t.element = findMin(t.right).element;
			t.right = remove(x, t.right);
		} else {
			t = t.left != null ? t.left : t.right;
		}

		return t;
	}

	private void printTree(BinaryNode t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
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
	BinaryNode left, right;

	BinaryNode(Comparable element) {
		this(element, null, null);
	}

	BinaryNode(Comparable element, BinaryNode left, BinaryNode right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}
}