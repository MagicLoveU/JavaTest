package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Merge_Files {

	public static void main(String[] args) throws IOException {
		
		//�ϲ����ļ���·��
		File f2 = new File("D:/1/new.txt");
		//�ֽ������
		FileOutputStream fos = new FileOutputStream(f2);
		
		for (int i = 1; i < 4; i++) {
			File f1 = new File("D:/1/" + i + ".txt");
			// �ֽ�������
			FileInputStream fis = new FileInputStream(f1);
			byte[] data = new byte[10];
			//д��data����
			fis.read(data);
			for (int j = 0; j < data.length; j++) {
				byte b = data[j];
				System.out.println(b);
			}
			//��data����д��f2�ļ�
			fos.write(data);
			
			// �ر�������
			fis.close();
		}
		
		// �ر������
		if (fos != null) {
			fos.close();
		}
	}
}
