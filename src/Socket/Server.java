package Socket;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999);

			System.out.println("监听在端口号：9999");
			Socket s = ss.accept();
			System.out.println("与客户端成功建立连接！");
			
			new SendThread(s).start();
			new RecieveThread(s).start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
