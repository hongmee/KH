package kr.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
	
	
	public void tcpServer() {
		Scanner sc = new Scanner(System.in);
		
		//1. 서버에서 사용할 포트번호 지정
		//0 ~ 65535 번호 사이에 숫자 1개를 사용(단, 같은 포트를 다른 프로그램이 같이쓸순 없음)
		//0 ~ 1000 사이 번호는 사용중인 경우가 많으므로 1000번 이후 사용
		
		int port = 7777;
		
		
		//나중에 반환해줄 객체들 미리 선언
		ServerSocket server = null; // <--서버에서 포트를 열기 위한 객체
		DataOutputStream dos = null; // <-- 데이터를 주고받을 때 사용할 보조스트림
		DataInputStream dis = null;  // <-- 데이터를 주고받을 때 사용할 보조스트림
		
		try {
			
			server = new ServerSocket(port); //<--(2) 서버 포켓객체 생성 
			System.out.println("[서버는 준비 완료]");
			System.out.println("[클라이언트 접속 요청 대기중...]");
			

			Socket socket = server.accept(); //<--(3) .accept() : 클라이언트 접속 요청을 대기, (4)클라이언트가 접속하면 통신할 소켓 객체를 생성해서 리턴해준다.
			System.out.println("[클라이언트 접속 완료!]");
			
			
			//5. 데이터를 주고받을 스트림을 추출(이미 소켓안에 스트림이 존재하니까)
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			
			//6. 성능개선을 위한 보조스트림 생성
			dos = new DataOutputStream(out);
			dis = new DataInputStream(in);
			
			String startMsg = "(서버측에서 보낸 메시지입니다) 공지사항 어쩌구 \n공지사항입니다 \n네 \n(*종료하려면 1 입력)";
			dos.writeUTF(startMsg); //<--★서버에서 write를 먼저 해줬으니까, 클라이언트는 read가 먼저 이뤄져야 함
			
			dos.writeUTF("★ 두번째 공지사항입니다");
			
			while(true) {
				
				String clinetMsg = dis.readUTF();
				if(clinetMsg.equals("1")) {
					System.out.println("[클라이언트가 퇴장했습니다]");
					break;
				}
				System.out.println("클라이언트 메시지 : "+clinetMsg);
				
				
				System.out.print("보낼 메시지 입력 : ");
				String str = sc.nextLine();
				dos.writeUTF(str);
				if(str.equals("끝")) {
					System.out.println("(!)클라이언트와 연결을 종료합니다.");
					break;
				}
				
			}//while
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try { //사용한 자원 반환
				dis.close();
				dos.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}//tcpServer

}//TcpServer
