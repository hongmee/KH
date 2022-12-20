package ka.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {

	
	public void tcpClient() {
		
		Scanner sc = new Scanner(System.in);
		
		//1.서버의 ip, port를 지정
		String serverIp = "192.168.10.41"; 
		
		int serverPort = 7777;
		
		//자원반환할때 필요한 객체 일단 선언
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			
			socket = new Socket(serverIp,serverPort); //<--지정한 아이피랑 포트로 소켓객체를 생성
			// ↑ 서버의 소켓 객체랑 똑같음. 하나를 공유하고 있음.
			System.out.println("[서버 접속 완료]");
			
			//3. 데이터를 주고받기 위한 스트림 추출(소켓안에 어차피 스트림 있음)
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			//4. 성능개선을 위한 보조스트림 생성
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			
			String notice = dis.readUTF(); //서버측이 write부터 시작하니까, 접속하면 이걸 읽어옴
			System.out.println(notice);
			System.out.println(dis.readUTF());
			
			while(true) {
			
				System.out.print("서버에 보낼 메시지 입력 : ");
				String str = sc.nextLine();
				dos.writeUTF(str); //<--서버로 문자열을 보냄
				if(str.equals("1")) {
					System.out.println("[서버에서 퇴장했습니다]");
					break;
				}
				
				
				String serverMsg = dis.readUTF();
				if(serverMsg.equals("끝")) {
					System.out.println("(!)서버측에서 강제 종료했습니다");
					break;
				}
				System.out.println("[*서버에서 온 메시지] : "+serverMsg);
				
			}//while
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dos.close();
				dis.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}//tcpClient
	
	
	
}//TcpClient
