package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Split_Files {

	public static void main(String[] args) throws IOException {
		// 源文件路径
		File f1 = new File("D:/1.txt");

		// 字节输入流
		FileInputStream fis = new FileInputStream(f1);
		byte[] all = new byte[10];
		// 字节输出流
		FileOutputStream fos = null;

		// 标记写入的是第几个文件
		int len = 0;
		int i = 1;

		// 循环写入路径...中
		while ((len = fis.read(all)) != -1) {
			File f2 = new File("D:/1/" + i + ".txt");
			i++;// 区分文件名
			f2.getParentFile().mkdirs();
			fos = new FileOutputStream(f2);
			fos.write(all, 0, len);//将all的内容写入
			fos.flush();
			System.out.println("文件名为 " + f2.getName() + ",该文件的大小为 " + f2.length() + "字节");

		}

		// 关闭输入输出流
		fis.close();
		if (fos != null) {
			fos.close();
		}
	}
}
