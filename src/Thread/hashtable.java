package Thread;

import java.util.Hashtable;

public class hashtable {

	public static void main(String args[]) {

		Hashtable<Integer, Integer> a = new Hashtable<Integer, Integer>();
		//a.put(null, null);//hashtable������null
		// ��
//		for (int i = 1; i < 9; i++) {
//			a.put(i, i);
//			a.put(5, 11111);// hashtable��key�Ӵ�С��˳�����
//			System.out.println(a);
//		}		
		// ��
		for (int i = 8; i > 0; i--) {
			a.put(i, i);
			a.put(5, 11111);// hashtable��key�Ӵ�С��˳�����
			System.out.println(a);
		}
		// ��
		for (int i = 1; i < 9; i++) {
			a.put(i, i * i);
			System.out.println(a);
		}
		// ɾ
		for (int i = 1; i < 9; i++) {
			a.remove(i);
			System.out.println(a);
		}
	}
}