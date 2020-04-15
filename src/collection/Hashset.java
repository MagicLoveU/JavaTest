package collection;

import java.util.HashSet;

public class Hashset {
    public static void main(String[] args) {
        String[] strArr = new String[100];
 
        HashSet<String> hashSet = new HashSet<>();
 
        HashSet<String> hashSet2 = new HashSet<>();
 
        for (int i = 0; i < strArr.length; i++) {
            String str = randomStr() + randomStr();
            System.out.print(str + "  ");
            if ((i + 1) % 20 == 0) {
                System.out.println("");
            }
            boolean b = hashSet.add(str);
            //��û�гɹ�����hashset1���ַ�������hashset2
            if (b == false) {
                hashSet2.add(str);
            }
        }
        System.out.printf("�ظ����ַ�����%d��%n", hashSet2.size());
        if (hashSet2.size() == 0) {
            System.exit(1);
        }
        System.out.println("�ֱ���:");
        for (String s : hashSet2) {
            System.out.println(s);
        }
    }
 
    // 0-9:48-57 A-Z:65-90 a-z:97-122
    public static String randomStr() {
        // 62
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
//      return String.valueOf((char) ((int) (Math.random() * (127 - 33) + 33)));
 
        return String.valueOf(str.charAt((int) (Math.random() * 62)));
    }
}