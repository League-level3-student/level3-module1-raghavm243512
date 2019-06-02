package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> a = new ArrayList<String>();
		//2. Add five Strings to your list
		a.add("five strings");
		//3. Print all the Strings using a standard for-loop
		for (int i =0;i<a.size();i++) {
			System.out.println(a.get(i));		
		}
		
		//4. Print all the Strings using a for-each loop
		for (String i : a) {
			System.out.println(i);	
		}
		//5. Print only the even numbered elements in the list.
		for (int i =0;i<a.size();i++) {
			if(i%2==0)
			System.out.println(a.get(i));		
		}
		//6. Print all the Strings in reverse order.
		for (int i =a.size()-1;i>=0;i--) {
			if(i%2==0)
			System.out.println(a.get(i));		
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for (String i : a) {
			if(i.contains("e"))
				System.out.println(i);
		}
	}
}
