package Thread;

import java.util.ArrayList;

public class arraylist {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer>();

		//��
		System.out.println(a.size());
		for (int i = 1; i < 10; i++) {
			a.add(i);
			System.out.println(a);
		}
		//��
		for (int i = 0; i < 9; i++) {
			a.set(i, 0);
			System.out.println(a);
		}
		
		//ɾ
		while (!a.isEmpty()) {
			a.remove(0);
			System.out.println(a);
		}
	}

}
