package collection;

import java.util.ArrayList;

public class Arraylist {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// 容器类ArrayList，用于存放对象
		ArrayList heros = new ArrayList();
		heros.add(new Hero("盖伦"));

		// 容器的容量"capacity"会随着对象的增加，自动增长
		// 只需要不断往容器里增加英雄即可，不用担心会出现数组的边界问题。
		heros.add(new Hero("提莫"));

		Hero specialHero = new Hero("special hero");
		heros.add(1, specialHero);
		System.out.println(heros.contains("提莫"));
		System.out.println(heros.get(2));
		System.out.println(heros.indexOf(specialHero));
		//heros.remove(2);
		//heros.set(1, "111111");
		System.out.println(heros.size());
		Hero hs[] = (Hero[])heros.toArray(new Hero[]{});
		for (Hero hero : hs) {
			System.out.println(hero);
		}
		//heros.clear();
		System.out.println(heros.toString());
		System.out.println("-----------------------------------------------------------");


		ArrayList heros1 = new ArrayList();
		// 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros1.add(new Hero("hero " + i));
        }
 
        System.out.println("ArrayList heros:\t" + heros1);
        heros.addAll(heros1);
        System.out.println(heros);
        
		
		
	}

}