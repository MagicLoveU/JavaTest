package IO;

import java.io.File;

public class Dir_files {
    static File MaxFile = null; // 最大的文件
    static File MinFile = null; // 最小的文件

    static long MaxSize = 0; // 最大文件的大小
    static long MinSize = Long.MAX_VALUE; // 最小文件的大小
	
	public static void Dir(File file){
		if(file.isFile()){
			if(file.length()>MaxSize){
				MaxFile = file;
				MaxSize = file.length();
			}
			else if(file.length()<MinSize && file.length() != 0){
				MinFile = file;
				MinSize = file.length();
			}
			//System.out.println(file.getAbsolutePath());
			return;
		}
		else if(file.isDirectory()){
			File[] files = file.listFiles();
			if(files != null){
				for (File file2 : files) {
					Dir(file2);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		File f1 = new File("D:/");
		Dir(f1);
		System.out.printf("%s文件目录下最大的文件是: %s.\t其大小为: %d字节\n", f1, MaxFile, MaxSize);
        System.out.printf("%s文件目录下最小的文件是: %s.\t其大小为: %d字节", f1, MinFile, MinSize);
		
	}
}
