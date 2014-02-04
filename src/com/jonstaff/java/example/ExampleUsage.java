package com.jonstaff.java.example;

//  Created by jonstaff on 1/27/14.

import com.jonstaff.java.hashtable.ElfHashNew;
import com.jonstaff.java.hashtable.Hashtable;
import com.jonstaff.java.sort.MergeSort;
import com.jonstaff.java.sort.QuickSort;
import com.jonstaff.java.tree.AvlTree;
import com.jonstaff.java.tree.BinarySearchTree;

public class ExampleUsage {

	public static void main(String[] args) {
		runMergeSortExample();
		runQuickSortExample();
		runBinarySearchTreeExample();
        runAvlTreeExample();
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

	private static void runBinarySearchTreeExample() {
		System.out.println("BinarySearchTree Example:");
		System.out.println("---------------------------------------");

		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(17);
		tree.insert(2);
		tree.insert(1);
		tree.insert(34);
		tree.insert(112);
		tree.insert(56);
		tree.insert(8);
		tree.insert(40);
		tree.insert(97);
		tree.insert(5);
		tree.insert(117);
		tree.insert(7);
		tree.insert(9);
		tree.insert(113);

		tree.printTree();

		System.out.println("---------------------------------------\n\n");
	}

    private static void runAvlTreeExample() {
        System.out.println("AvlTree Example:");
        System.out.println("---------------------------------------");

        AvlTree tree = new AvlTree();
        tree.insert(17);
        tree.insert(2);
        tree.insert(1);
        tree.insert(34);
        tree.insert(112);
        tree.insert(56);
        tree.insert(8);
        tree.insert(40);
        tree.insert(97);
        tree.insert(5);
        tree.insert(117);
        tree.insert(7);
        tree.insert(9);
        tree.insert(113);

        tree.printTree();

        System.out.println("\nPrint the value if found: " + tree.find(5));

        System.out.println("---------------------------------------\n\n");
    }

	private static void runHashTableExample() {
		System.out.println("Hashtable Example:");
		System.out.println("---------------------------------------");

		Hashtable table = new Hashtable(20, new ElfHashNew());

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
