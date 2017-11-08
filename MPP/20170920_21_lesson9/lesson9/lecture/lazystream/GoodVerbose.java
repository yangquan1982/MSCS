package lesson9.lecture.lazystream;

import java.util.List;
import java.util.stream.Collectors;


public class GoodVerbose {
	public static void main(final String[] args) {
		GoodVerbose good = new GoodVerbose();
		good.findStartsWithLetterNoTerminal(Folks.friends, "N");
//		System.out.println(String.format("Friends with names that start"
//				+ " with 'N': "+ good.findStartsWithLetter(Folks.friends, "N")));
		
	}
	
	public void findStartsWithLetterNoTerminal(List<String> list, String letter) {
		
		     list.stream()   //convert list to stream
         	     .filter(name -> starts(name,letter)) //returns filtered stream
         	     .map(name -> toUpper(name));  //maps each string to upper case string
         	     
	}
	
	public List<String> findStartsWithLetterOld(List<String> list, String letter) {
		return 
		     list.stream()   //convert list to stream
         	     .filter(name -> name.startsWith(letter)) //returns filtered stream
         	     .map(name -> name.toUpperCase())  //maps each string to upper case string
         	     .collect(Collectors.toList()); //organizes into a list		
	}
	
	public List<String> findStartsWithLetter(List<String> list, String letter) {
		return 
		     list.stream()   //convert list to stream
         	     .filter(name -> starts(name,letter)) //returns filtered stream
         	     .map(name -> toUpper(name))  //maps each string to upper case string
         	     .collect(Collectors.toList()); //organizes into a list		
	}
	public List<String> findStartsWithLetterLimit(List<String> list, String letter) {
		return 
		     list.stream()   //convert list to stream
         	     .filter(name -> starts(name,letter)) //returns filtered stream
         	     .map(name -> toUpper(name))  //maps each string to upper case string
         	     .limit(2)
         	     .collect(Collectors.toList()); //organizes into a list		
	}
	
	public boolean starts(String word, String letr) {
		System.out.println("Looking at " + word + " to check if it starts with " + letr);
		return word.startsWith(letr);
	}
	public String toUpper(String word) {
		System.out.println("Looking at " + word + " to convert to upper case");
		return word.toUpperCase();
	}
	
	
}
