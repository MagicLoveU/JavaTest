package collection;

import java.util.ArrayList;

public class Arraylist {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// ������ArrayList�����ڴ�Ŷ���
		ArrayList heros = new ArrayList();
		heros.add(new Hero("����"));

		// ����������"capacity"�����Ŷ�������ӣ��Զ�����
		// ֻ��Ҫ����������������Ӣ�ۼ��ɣ����õ��Ļ��������ı߽����⡣
		heros.add(new Hero("��Ī"));

		Hero specialHero = new Hero("special hero");
		heros.add(1, specialHero);
		System.out.println(heros.contains("��Ī"));
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
		// ��ʼ��5������
        for (int i = 0; i < 5; i++) {
            heros1.add(new Hero("hero " + i));
        }
 
        System.out.println("ArrayList heros:\t" + heros1);
        heros.addAll(heros1);
        System.out.println(heros);
        
		
		
	}

}