package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream_byte {

	public static void main(String[] args) {
		try {
			File f1 = new File("D:/1/2/3/1.txt");
			//������ļ��в����ڣ��ʹ������ļ��в������ļ�
			f1.getParentFile().mkdirs();
				
			byte data[] = { 76, 85, 67, 65, 83 };

			FileOutputStream fot = new FileOutputStream(f1);
			fot.write(data);
			fot.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
