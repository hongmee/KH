package ka.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class shadowDNSClient {

	
	public void client() {
		Scanner sc = new Scanner(System.in);
		
		String serverIP = "192.168.10.41";
		int serverPort = 8888;
		
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			socket = new Socket(serverIP,serverPort);
			
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			
			System.out.print("알고싶은 도메인 주소를 입력하세요 : ");
			String domain = sc.next();
			
			dos.writeUTF(domain);
			
			String result = dis.readUTF();
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dis.close();
				dos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}//shadowDNSClient
