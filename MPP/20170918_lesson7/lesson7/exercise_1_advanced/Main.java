package lesson7.exercise_1_advanced;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		MyStringList l = new MyStringList();
		l.add("Bob");
		l.add("Steve");
		l.add("Susan");
		l.add("Mark");
		l.add("Dave");
		System.out.println("Second element: " + l.get(2));
		System.out.println("Removed Bob? " + l.remove("Bob"));
		System.out.println("Modified list: " + l);
		System.out.println("Is Susan in the list? " + l.find("Susan"));
		l = MyStringList.sort(l);
		System.out.println("Sorted list " + l);
		
		// testing iterator
		Iterator<String> iterator = l.iterator();
		System.out.println("\n==================\n");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());			
		}
		System.out.println("\n==================\n");
		//for each style
		for(String str : l) {
			System.out.println(str.toString());
		}
	}
}
