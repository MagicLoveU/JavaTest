package IO;
  
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
  
public class InputStream_byte {
  
    public static void main(String[] args) {
        try {
            //׼���ļ�lol.txt���е�������AB����Ӧ��ASCII�ֱ���65 66
            File f =new File("D:/1.txt");
            //���������ļ���������
            FileInputStream fis =new FileInputStream(f);
            //�����ֽ����飬�䳤�Ⱦ����ļ��ĳ���
            byte[] all =new byte[(int) f.length()];
            //���ֽ�������ʽ��ȡ�ļ���������,����all����
            fis.read(all);
            for (byte b : all) {
                //��ӡ������65 66
                System.out.println(b);
            }
             
            //ÿ��ʹ����������Ӧ�ý��йر�
            fis.close();
              
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
    }
}