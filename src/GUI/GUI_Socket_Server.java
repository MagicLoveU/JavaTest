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
		//Ƥ��
		javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		
		// ������
		JFrame f = new JFrame("������");
		f.setSize(600, 400);
		f.setLocation(100, 50);
		f.setLayout(null);

		// �����
		JTextArea ta1 = new JTextArea();
		ta1.setEditable(false);
		ta1.setWrapStyleWord(true);
		ta1.setLineWrap(true);

		// ������Ϣ��
		JTextArea ta2 = new JTextArea();
		ta2.setWrapStyleWord(true);
		ta2.setLineWrap(true);

		// ������
		JScrollPane sp1 = new JScrollPane(ta1);
		sp1.setBounds(50, 50, 400, 150);
		JScrollPane sp2 = new JScrollPane(ta2);
		sp2.setBounds(80, 220, 220, 60);

		// ���
		JPanel p = new JPanel();
		p.setBounds(270, 230, 200, 100);

		// ��ť
		JButton b = new JButton("������Ϣ");

		p.add(b);
		f.add(sp1);
		f.add(sp2);
		f.add(p);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		ServerSocket ss = new ServerSocket(9999);
		Socket s = ss.accept();
		ta1.setText("��ͻ������ӳɹ����뿪ʼ���죡\n");

		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		InputStream is = s.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		// ����Ϣ�߳�
		Thread recieve = new Thread() {
			public void run() {
				try {

					while (true) {
						String msg = dis.readUTF();
						ta1.append(date() + "\n���ͻ��ˡ�: " + msg + "\n");
						if (msg.equals("�Ͽ�����")) {
							flag = 1;
							dos.close();
							os.close();
							dis.close();
							is.close();
							s.close();
							ss.close();
							ta1.append("��������ȡ�����ӣ���رմ��ڣ�");
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		recieve.start();

		// ����Ϣ����
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = ta2.getText();
				ta2.setText(null);
				try {
					dos.writeUTF(str);
					ta1.append(date() + "\n����������: " + str + "\n");
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				if (str.equals("�Ͽ�����")) {
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
