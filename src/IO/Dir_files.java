package IO;

import java.io.File;

public class Dir_files {
    static File MaxFile = null; // �����ļ�
    static File MinFile = null; // ��С���ļ�

    static long MaxSize = 0; // ����ļ��Ĵ�С
    static long MinSize = Long.MAX_VALUE; // ��С�ļ��Ĵ�С
	
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
		System.out.printf("%s�ļ�Ŀ¼�������ļ���: %s.\t���СΪ: %d�ֽ�\n", f1, MaxFile, MaxSize);
        System.out.printf("%s�ļ�Ŀ¼����С���ļ���: %s.\t���СΪ: %d�ֽ�", f1, MinFile, MinSize);
		
	}
}
