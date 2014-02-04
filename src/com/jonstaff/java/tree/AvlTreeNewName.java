package com.jonstaff.java.tree;

//  Created by jonstaff on 2/1/14.
//  Adapted from Data Structures & Algorithm Analysis in Java by Mark Allen Weiss

public class AvlTreeNewName extends BinaryTree<AvlNode> {

	//     ____  _                       _____                __  __      _   _               _
	//    | __ )(_)_ __   __ _ _ __ _   |_   _| __ ___  ___  |  \/  | ___| |_| |__   ___   __| |___
	//    |  _ \| | '_ \ / _` | '__| | | || || '__/ _ \/ _ \ | |\/| |/ _ \ __| '_ \ / _ \ / _` / __|
	//    | |_) | | | | | (_| | |  | |_| || || | |  __/  __/ | |  | |  __/ |_| | | | (_) | (_| \__ \
	//    |____/|_|_| |_|\__,_|_|   \__, ||_||_|  \___|\___| |_|  |_|\___|\__|_| |_|\___/ \__,_|___/
	//                              |___/

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

	//     ____       _            _         __  __      _   _               _
	//    |  _ \ _ __(_)_   ____ _| |_ ___  |  \/  | ___| |_| |__   ___   __| |___
	//    | |_) | '__| \ \ / / _` | __/ _ \ | |\/| |/ _ \ __| '_ \ / _ \ / _` / __|
	//    |  __/| |  | |\ V / (_| | ||  __/ | |  | |  __/ |_| | | | (_) | (_| \__ \
	//    |_|   |_|  |_| \_/ \__,_|\__\___| |_|  |_|\___|\__|_| |_|\___/ \__,_|___/

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
					t = rotateWithLeftChild(t);
				} else {
					t = doubleWithLeftChild(t);
				}
			}
		} else if (x.compareTo(t.element) > 0) {
			t.right = insert(x, t.right);

			if (heightOf(t.right) - heightOf(t.left) == 2) {
				if (x.compareTo(t.right.element) > 0) {
					t = rotateWithRightChild(t);
				} else {
					t = doubleWithRightChild(t);
				}
			}
		}

		t.height = Math.max(heightOf(t.left), heightOf(t.right)) + 1;
		return t;
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
		AvlNode k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
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

	private Comparable elementAt(AvlNode t) {
		return t == null ? null : t.element;
	}

	private AvlNode find(Comparable x, AvlNode t) {
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

	private AvlNode findMin(AvlNode t) {
		if (t != null) {
			while (t.left != t) {
				t = t.left;
			}
		}

		return t;
	}

	private AvlNode findMax(AvlNode t) {
		if (t != null) {
			while (t.right != t) {
				t = t.right;
			}
		}

		return t;
	}

	private AvlNode remove(Comparable x, AvlNode t) {
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
}

//            _        _ _   _           _
//           / \__   _| | \ | | ___   __| | ___
//          / _ \ \ / / |  \| |/ _ \ / _` |/ _ \
//         / ___ \ V /| | |\  | (_) | (_| |  __/
//        /_/   \_\_/ |_|_| \_|\___/ \__,_|\___|

class AvlNode extends Node<AvlNode> {
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