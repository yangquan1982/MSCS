package lesson7.exercise_1;

import java.util.*;


public class MyStringList implements StringList {
	private static final int INITIAL_SIZE = 100;
	String[] strArray;
	int size;
	
	/* constructor */
	public MyStringList() {
		strArray = new String[INITIAL_SIZE];
		size = 0;
	}
	
	
	public String[] strArray() {
		return strArray;
	}
	public void setSize(int x) {
		size = x;
	}
	
	//implementations of interface methods
	
	public void add(String s) {
		strArray[size++] = s;
	}
	
	public String get(int i) {
		if (i < 0 || i >= size) {
			return null;
		}
		return strArray[i];
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size - 1; ++i) {
			sb.append(strArray[i] + ", ");
		}
		if(size > 0)
		   sb.append(strArray[size - 1] + "]");
		return sb.toString();
	}
}
