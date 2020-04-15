package Thread;

import java.util.LinkedList;
import java.util.List;

public class linkedlist {
	
	public static void main(String[] args) {
		
		List<Integer> a = new LinkedList<Integer>();
		//Ôö
		for (int i = 1; i < 10; i++) {
			a.add(i);
			System.out.println(a);
		}
		//¸Ä
		for (int i = 0; i < 9; i++) {
			a.set(i, 0);
			System.out.println(a);
		}
		//É¾
		while (!a.isEmpty()) {
			a.remove(0);
			System.out.println(a);
		}
		
	}
}
