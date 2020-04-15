package collection;

import java.util.ArrayList;
import java.util.List;

public class HeroTree {
	

	public HeroTree leftNode;
	public HeroTree rightNode;
	public Hero value;
	
	public void add(Hero v) {
		if (value == null)
			value = v;
		else {
			if (value.hp >= v.hp) {
				if (leftNode == null)
					leftNode = new HeroTree();;
				leftNode.add(v);
			} else {
				if (rightNode == null)
					rightNode = new HeroTree();
				rightNode.add(v);
			}
		}
	}

	public List<Object> values() {
		List<Object> values = new ArrayList<>();

		if (leftNode != null)
			values.addAll(leftNode.values());

		values.add(value);

		if (rightNode != null)
			values.addAll(rightNode.values());

		return values;
	}

	public static void main(String[] args) {

		HeroTree heros = new HeroTree();
		
		System.out.println("初始化这10个英雄！");
		
		for (int i = 0; i < 10; i++) {
			Hero hero = new Hero("Hero " + i, (int) (Math.random() * 1000));
			heros.add(hero);
			System.out.print(hero.toString());
		}
		
		System.out.println("按hp排列英雄");
		
		System.out.println(heros.values());

	}

}
