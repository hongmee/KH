package kr.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

	public void client() {
		
		Scanner sc = new Scanner(System.in);
		
		//1.접속할 서버의 ip와 port
		String serverIp = "192.168.10.96";
		int port = 9999;
		
		//2.반납할 객체 준비
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		
		try {
			
			socket = new Socket(serverIp,port);
			System.out.println("[서버 접속 완료]");
			
			//3. 소켓에서 스트림 추출
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			
			
			while(true) {
			String serverMsg = dis.readUTF();
			System.out.println(serverMsg);
			
				if(serverMsg.charAt(serverMsg.length()-1)=='?') {
					System.out.print("정답 : ");
					String answer = sc.nextLine();
					dos.writeUTF(answer);
				}
				
			char end = serverMsg.charAt(0);
			
				if(end == '끝') { //<--이걸 안해주면 서버는 줄게 없는데 계속 dis.readUTF로 읽어오려 하기 때문에 오류가 남
					System.out.println("[나도끝!]");
					break;
				}
				
			}//while
	
			
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
		
		
	}//client
	
	
}//Client
