package IO;
 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
 
public class InputStream_char {
 
    public static void main(String[] args) {

    	File f = new File("D:/1/1.txt");
        // ���������ļ���Reader
        try (FileReader fr = new FileReader(f)) {
            // �����ַ����飬�䳤�Ⱦ����ļ��ĳ���
            char[] all = new char[(int) f.length()];
            // ���ַ�������ʽ��ȡ�ļ���������
            fr.read(all);
            for (char b : all) {
                // ��ӡ������A B
                System.out.print(b);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
}