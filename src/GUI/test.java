package GUI;
 
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
 
public class test {
    public static void main(String[] args) {
 
    	//主窗体
    	JFrame f = new JFrame("title");
		f.setSize(600, 400);
		f.setLocation(100, 50);
		f.setLayout(null);

		// 文本域
		JTextArea ta1 = new JTextArea();
		ta1.setWrapStyleWord(true);
		ta1.setLineWrap(true);

		//滚动条
		JScrollPane sp1 = new JScrollPane(ta1);
		sp1.setBounds(0, 50, 300, 200);

		//面板
//		JPanel p = new JPanel();

//		p.add(sp1);
		f.add(sp1);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
    }
}