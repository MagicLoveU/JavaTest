package Thread;

import java.util.HashMap;

public class hashmap {
	public static void main(String[] args) {

		HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
		a.put(null, null);
		System.out.println(a.get(null));
//		// 增
//		for (int i = 1; i < 9; i++) {
//			a.put(i, i);
//			a.put(5, 11111);// hashmap按key从小到大的顺序输出
//			System.out.println(a);
//		}
		// 增
				for (int i = 8; i > 0; i--) {
					a.put(i, i);
					a.put(5, 11111);// hashmap按key从小到大的顺序输出
					System.out.println(a);
				}
		// 改
		for (int i = 1; i < 9; i++) {
			a.put(i, i * i);
			System.out.println(a);
		}
		// 删
		for (int i = 1; i < 9; i++) {
			a.remove(i);
			System.out.println(a);
		}
	}
}
