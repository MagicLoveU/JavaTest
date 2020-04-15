package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Merge_Files {

	public static void main(String[] args) throws IOException {
		
		//合并后文件的路径
		File f2 = new File("D:/1/new.txt");
		//字节输出流
		FileOutputStream fos = new FileOutputStream(f2);
		
		for (int i = 1; i < 4; i++) {
			File f1 = new File("D:/1/" + i + ".txt");
			// 字节输入流
			FileInputStream fis = new FileInputStream(f1);
			byte[] data = new byte[10];
			//写入data数组
			fis.read(data);
			for (int j = 0; j < data.length; j++) {
				byte b = data[j];
				System.out.println(b);
			}
			//由data数组写入f2文件
			fos.write(data);
			
			// 关闭输入流
			fis.close();
		}
		
		// 关闭输出流
		if (fos != null) {
			fos.close();
		}
	}
}
