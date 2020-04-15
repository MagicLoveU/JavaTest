package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI_Socket_Server {
	protected static int flag = 0;

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		//皮肤
		javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		
		// 主窗体
		JFrame f = new JFrame("服务器");
		f.setSize(600, 400);
		f.setLocation(100, 50);
		f.setLayout(null);

		// 聊天框
		JTextArea ta1 = new JTextArea();
		ta1.setEditable(false);
		ta1.setWrapStyleWord(true);
		ta1.setLineWrap(true);

		// 发送消息框
		JTextArea ta2 = new JTextArea();
		ta2.setWrapStyleWord(true);
		ta2.setLineWrap(true);

		// 滚动条
		JScrollPane sp1 = new JScrollPane(ta1);
		sp1.setBounds(50, 50, 400, 150);
		JScrollPane sp2 = new JScrollPane(ta2);
		sp2.setBounds(80, 220, 220, 60);

		// 面板
		JPanel p = new JPanel();
		p.setBounds(270, 230, 200, 100);

		// 按钮
		JButton b = new JButton("发送消息");

		p.add(b);
		f.add(sp1);
		f.add(sp2);
		f.add(p);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		ServerSocket ss = new ServerSocket(9999);
		Socket s = ss.accept();
		ta1.setText("与客户端连接成功，请开始聊天！\n");

		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		InputStream is = s.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		// 收消息线程
		Thread recieve = new Thread() {
			public void run() {
				try {

					while (true) {
						String msg = dis.readUTF();
						ta1.append(date() + "\n【客户端】: " + msg + "\n");
						if (msg.equals("断开连接")) {
							flag = 1;
							dos.close();
							os.close();
							dis.close();
							is.close();
							s.close();
							ss.close();
							ta1.append("服务器已取消连接！请关闭窗口！");
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		recieve.start();

		// 发消息监听
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = ta2.getText();
				ta2.setText(null);
				try {
					dos.writeUTF(str);
					ta1.append(date() + "\n【服务器】: " + str + "\n");
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				if (str.equals("断开连接")) {
					recieve.interrupt();
					try {
						dos.close();
						os.close();
						dis.close();
						is.close();
						s.close();
						ss.close();
						f.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

	public static String date() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		Date d = new Date();
		String time = sdf.format(d);
		return time;
	}
}
