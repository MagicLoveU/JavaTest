package Socket;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999);

			System.out.println("�����ڶ˿ںţ�9999");
			Socket s = ss.accept();
			System.out.println("��ͻ��˳ɹ��������ӣ�");
			
			new SendThread(s).start();
			new RecieveThread(s).start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
