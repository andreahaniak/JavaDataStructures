package com.jonstaff.java.tree;

//  Created by jonstaff on 2/1/14.

public abstract class Node<T> {
    Comparable element;
    T left, right;

    @Override
    public String toString() {
        return "{Element: " + element + ", Left: " + left + ", Right: " + right + "}";
    }
}
