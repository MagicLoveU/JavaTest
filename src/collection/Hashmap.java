package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hashmap {

	// ArrayList查找
	public void ArrayList_serch() {
		List<Hero> heros_arr = new ArrayList<>();

		for (int i = 0; i < 3000 * 1000; i++) {
			heros_arr.add(new Hero("hero-" + (int) (Math.random() * 9000 + 1000)));
		}

		long a = System.currentTimeMillis();

		for (int i = 0; i < heros_arr.size(); i++) {
			if (heros_arr.get(i).name.equals("hero-5555"))
				System.out.println(i);
		}

		long b = System.currentTimeMillis();
		System.out.println("HashMap的查找时间： ");
		System.out.println(b - a);
	}

	// HashMap查找
	public void HashMap_serch() {

		List<Hero> heros_arr = new ArrayList<>();
		HashMap<String, List<Hero>> heros = new HashMap<>();

		//创建hero集合
		for (int i = 0; i < 3000 * 1000; i++) {
			heros_arr.add(new Hero("hero-" + (int) (Math.random() * 9000 + 1000)));
		}

		//初始化hashmap
		for (Hero h : heros_arr) {
			List<Hero> hs = heros.get(h.name);
			if (hs == null){
				hs = new ArrayList<>();
			}
			heros.put(h.name, hs);

		}

		long a = System.currentTimeMillis();

		//查找
		heros.get("hero-5555");

		long b = System.currentTimeMillis();

		System.out.println("ArrayList的查找时间： ");
		System.out.println(b - a);
	}

	public static void main(String[] args) {

		Hashmap hashmap = new Hashmap();
		hashmap.ArrayList_serch();
		hashmap.HashMap_serch();

	}
}