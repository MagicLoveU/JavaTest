package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Split_Files {

	public static void main(String[] args) throws IOException {
		// Դ�ļ�·��
		File f1 = new File("D:/1.txt");

		// �ֽ�������
		FileInputStream fis = new FileInputStream(f1);
		byte[] all = new byte[10];
		// �ֽ������
		FileOutputStream fos = null;

		// ���д����ǵڼ����ļ�
		int len = 0;
		int i = 1;

		// ѭ��д��·��...��
		while ((len = fis.read(all)) != -1) {
			File f2 = new File("D:/1/" + i + ".txt");
			i++;// �����ļ���
			f2.getParentFile().mkdirs();
			fos = new FileOutputStream(f2);
			fos.write(all, 0, len);//��all������д��
			fos.flush();
			System.out.println("�ļ���Ϊ " + f2.getName() + ",���ļ��Ĵ�СΪ " + f2.length() + "�ֽ�");

		}

		// �ر����������
		fis.close();
		if (fos != null) {
			fos.close();
		}
	}
}
