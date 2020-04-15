package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream_byte {

	public static void main(String[] args) {
		try {
			File f1 = new File("D:/1/2/3/1.txt");
			//如果父文件夹不存在，就创建父文件夹并创建文件
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
