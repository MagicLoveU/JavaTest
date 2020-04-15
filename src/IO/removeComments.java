package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class removeComments {

	public static void removeComments(File f1) throws IOException {

		
		File f2 = new File("d:/2.txt");

		FileReader fr = new FileReader(f1);
		FileWriter fw = new FileWriter(f2);
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		
		while(true){
			String line = br.readLine();
			if(null == line)
				break;
			else if(line.startsWith("//")){
				continue;
			}
			System.out.println(line);
			bw.write(line);
		}

		br.close();
		bw.close();
		fw.close();
		fr.close();
	}

	public static void main(String[] args) throws IOException {
		
		File f1 = new File("d:/1.txt");
		removeComments.removeComments(f1);
		
	}
}