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
        System.out.println("加密前的内容：");
        System.out.println(data1);

		for (int i = 0; i < data1.length; i++) {

			// 判断数字
			if (data1[i] == '9') {
				data1[i] = '0';
			} 
			else if (data1[i] > '0' && data1[i] < '9') {
				data1[i] += 1;
			}
			// 判断小写字母
			else if (data1[i] > 'a' && data1[i] < 'z') {

				if (data1[i] == 'z') {
					data1[i] = 'a';
				} else if (data1[i] > 'a' && data1[i] < 'y') {
					data1[i] = (char) (data1[i] + 1);
				}
			}
			// 判断大写字母
			else if (data1[i] > 'A' && data1[i] < 'Z') {

				if (data1[i] == 'Z') {
					data1[i] = 'A';
				} else if (data1[i] > 'A' && data1[i] < 'Y') {
					data1[i] = (char) (data1[i] + 1);
				}
			}
		}//for结束
		
		//写入
		FileWriter fw = new FileWriter(encodedFile);
		fw.write(data1);
        System.out.println("加密后的内容：");
        System.out.println(data1);
        fr.close();
        fw.close();
	}
}
