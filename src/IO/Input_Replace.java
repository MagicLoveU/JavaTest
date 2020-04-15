package IO;
 
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
public class Input_Replace {
 
    public static void main(String[] args) {
        // ���ܿͻ�����
        Scanner s = new Scanner(System.in);
        System.out.println("������������ƣ�");
        String className = s.nextLine();
        System.out.println("���������Ե����ͣ�");
        String type = s.nextLine();
        System.out.println("���������Ե����ƣ�");
        String property = s.nextLine();
        String Uproperty = toUpperFirstLetter(property);
         
        // ��ȡģ���ļ�
        File modelFile = new File("D:\\1.txt");
        String modelContent = null;
        try (FileReader fr = new FileReader(modelFile)) {
            char cs[] = new char[(int) modelFile.length()];
            fr.read(cs);
            modelContent = new String(cs);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }      
         
        //�滻
         
        String fileContent = modelContent.replaceAll("@class@", className);
        fileContent = fileContent.replaceAll("@type@", type);
        fileContent = fileContent.replaceAll("@property@", property);
        fileContent = fileContent.replaceAll("@Uproperty@", Uproperty);
        String fileName = className+".java";
         
        //�滻�������
        System.out.println("�滻������ݣ�");
        System.out.println(fileContent);
        File file = new File("D:\\",fileName);
 
        try(FileWriter fw =new FileWriter(file);){
            fw.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        System.out.println("�ļ�������:" + file.getAbsolutePath());
    }
     
    public static String toUpperFirstLetter(String str){
        char upperCaseFirst =Character.toUpperCase(str.charAt(0));
        String rest = str.substring(1);
        return upperCaseFirst + rest;
         
    }
}