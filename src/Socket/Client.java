package Socket;

import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		try {
			Socket s = new Socket("127.0.0.1", 9999);
			System.out.println("��������˳ɹ��������ӣ�");
			
			new SendThread(s).start();
			new RecieveThread(s).start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
