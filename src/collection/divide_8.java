package collection;

import java.util.ArrayList;
import java.util.List;

public class divide_8 {

	public static void main(String[] args) {

		List<Hero> h = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			h.add(new Hero("hero " + i));
		}

		System.out.println(h);

		System.out.println("-----------------------------------------------------------");

		for (int i = 99; i > 0; i--) {

			// Hero a = h.get(i);
			// String b = a.toString();
			// String c = b.substring(5);
			// if(0 == (c%8))
			if (i % 8 == 0)
				h.remove(i);
			// System.out.println(c);
		}

		System.out.println("-----------------------------------------------------------");

		System.out.println(h);

	}

}