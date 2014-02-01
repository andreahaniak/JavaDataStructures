package com.jonstaff.java.tree;

//  Created by jonstaff on 1/31/14.
//  Adapted from Data Structures & Algorithm Analysis in Java by Mark Allen Weiss

public class BinarySearchTree extends BinaryTree {

	public BinarySearchTree() {
		root = null;
	}

	@Override
	public void makeEmpty() {
		root = null;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public Comparable find(Comparable x) {
		return elementAt(find(x, root));
	}

	@Override
	public Comparable findMin() {
		return elementAt(findMin(root));
	}

	@Override
	public Comparable findMax() {
		return elementAt(findMax(root));
	}

	@Override
	public void insert(Comparable x) {
		root = insert(x, root);
	}

	@Override
	public void remove(Comparable x) {
		root = remove(x, root);
	}

	@Override
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

	private Comparable elementAt(Node t) {
		return t == null ? null : t.element;
	}

	private Node find(Comparable x, Node t) {
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

	private Node findMin(Node t) {
		if (t != null) {
			while (t.left != t) {
				t = t.left;
			}
		}

		return t;
	}

	private Node findMax(Node t) {
		if (t != null) {
			while (t.right != t) {
				t = t.right;
			}
		}

		return t;
	}

	private Node insert(Comparable x, Node t) {
		if (t == null) {
			return new Node(x, null, null);
		} else if (x.compareTo(t.element) < 0) {
			t.left = insert(x, t.left);
		} else if (x.compareTo(t.element) > 0) {
			t.right = insert(x, t.right);
		}

		return t;
	}

	private Node remove(Comparable x, Node t) {
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

	private void printTree(Node t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
}