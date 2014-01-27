package com.jonstaff.java.example;

//  Created by jonstaff on 1/27/14.

import com.jonstaff.java.hashtable.ELFHash;
import com.jonstaff.java.hashtable.Hashtable;
import com.jonstaff.java.sort.MergeSort;
import com.jonstaff.java.sort.QuickSort;
import com.jonstaff.java.tree.BinaryTree;

public class ExampleUsage {

	public static void main(String[] args) {
		runMergeSortExample();
		runQuickSortExample();
		runBinaryTreeExample();
        runHashTableExample();
	}

	private static void runMergeSortExample() {
		System.out.println("MergeSort Example:");
		System.out.println("---------------------------------------");

		int[] list = {7, 2, 9, 3, 8, 6, 11, 4, 1, 5, 10, 15, 16, 14, 12, 13};

		System.out.println("The list unsorted:");
		for (int x : list) {
			System.out.println(x);
		}

		MergeSort.sort(list);

		System.out.println("\n And the list sorted:");
		for (int x : list) {
			System.out.println(x);
		}

		System.out.println("---------------------------------------\n\n");
	}

	private static void runQuickSortExample() {
		System.out.println("QuickSort Example:");
		System.out.println("---------------------------------------");

		int[] list2 = {7, 2, 9, 3, 8, 6, 11, 4, 1, 5, 10, 15, 16, 14, 12, 13};

		System.out.println("The list unsorted:");
		for (int x : list2) {
			System.out.println(x);
		}

		QuickSort.sort(list2, 0, list2.length - 1);

		System.out.println("\n And the list sorted:");
		for (int x : list2) {
			System.out.println(x);
		}

		System.out.println("---------------------------------------\n\n");
	}

	private static void runBinaryTreeExample() {
		System.out.println("BinaryTree Example:");
		System.out.println("---------------------------------------");

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

		tree.inOrderTraversal(tree.getRoot());
		System.out.println("---------------------------------------\n\n");
	}

    private static void runHashTableExample() {
        System.out.println("Hashtable Example:");
        System.out.println("---------------------------------------");

        Hashtable table = new Hashtable(20, new ELFHash());

        table.put("name", "Jonathon");
        table.put("age", 21);
        table.put("mother", "Ann");
        table.put("father", "Noll");
        table.put("brother", "Paul");
        table.put("school", "Bellarmine");

        System.out.println(table);
        System.out.println("\nThere are " + table.countCollisions() + " collisions in the table.");

        System.out.println("\nGetting item for key \"name\": " + table.get("name"));
        System.out.println("\nRemoving item for key \"school\": " + table.remove("school") + "\n");

        System.out.println(table);
        System.out.println("---------------------------------------\n\n");
    }
}
