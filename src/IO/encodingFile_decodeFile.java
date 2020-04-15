package IO;

import java.io.File;
import java.io.IOException;

public class encodingFile_decodeFile {
	public static void main(String[] args) throws IOException {

		File f1 = new File("D:/1.txt");
		File f2 = new File("D:/1/1.txt");
		File f3 = new File("D:/1/2.txt");
		
		encodingFile.encodeFile(f1, f2);
		decodeFile.encodeFile(f2, f3);
	}
}
