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
            //将没有成功存入hashset1的字符串存入hashset2
            if (b == false) {
                hashSet2.add(str);
            }
        }
        System.out.printf("重复的字符串有%d种%n", hashSet2.size());
        if (hashSet2.size() == 0) {
            System.exit(1);
        }
        System.out.println("分别是:");
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