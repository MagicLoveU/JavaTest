package IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class encodingFile {
	public static void encodeFile(File encodingFile, File encodedFile) throws IOException {

		FileReader fr = new FileReader(encodingFile);

		char[] data1 = new char[(int) encodingFile.length()];

		fr.read(data1);
        System.out.println("����ǰ�����ݣ�");
        System.out.println(data1);

		for (int i = 0; i < data1.length; i++) {

			// �ж�����
			if (data1[i] == '9') {
				data1[i] = '0';
			} 
			else if (data1[i] > '0' && data1[i] < '9') {
				data1[i] += 1;
			}
			// �ж�Сд��ĸ
			else if (data1[i] > 'a' && data1[i] < 'z') {

				if (data1[i] == 'z') {
					data1[i] = 'a';
				} else if (data1[i] > 'a' && data1[i] < 'y') {
					data1[i] = (char) (data1[i] + 1);
				}
			}
			// �жϴ�д��ĸ
			else if (data1[i] > 'A' && data1[i] < 'Z') {

				if (data1[i] == 'Z') {
					data1[i] = 'A';
				} else if (data1[i] > 'A' && data1[i] < 'Y') {
					data1[i] = (char) (data1[i] + 1);
				}
			}
		}//for����
		
		//д��
		FileWriter fw = new FileWriter(encodedFile);
		fw.write(data1);
        System.out.println("���ܺ�����ݣ�");
        System.out.println(data1);
        fr.close();
        fw.close();
	}
}
