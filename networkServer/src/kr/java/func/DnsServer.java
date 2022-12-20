package kr.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class DnsServer {

	private Scanner sc;
	HashMap<String, String> dns;
	int num;
	
	public DnsServer() {
		super();
		
		sc = new Scanner(System.in);
		
		dns = new HashMap<String, String>();
		dns.put("www.naver.com", "125.209.222.142");
		dns.put("www.google.com", "172.217.175.4");
		dns.put("www.iei.or.kr", "211.43.14.187");
		
		num = 0;
		
	}//생성자


	public void dnsServer() {
	
		//1. 서버에서 사용할 포트번호
		int port = 8888 ;
		
		//2. 나중에 반환해줄것들을 try밖에 미리 선언?
		ServerSocket server = null;
		DataOutputStream dos = null; 
		DataInputStream dis = null;
		
		try {
			
			server = new ServerSocket(port); //3. 서버 포켓객체 생성
			System.out.println("[DNS서버 준비완료]");
			System.out.println("[클라이언트 요청 대기......]");
			
			Socket socket = server.accept(); //4.클라이언트 요청을 대기하고 접속하면 소켓 객체 생성해서 리턴해준다
			
			//5. 데이터를 주고받을 스트림 추출
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			
			//6. 스트림 성능을 높여줄 보조스트림 생성
			dos = new DataOutputStream(out);
			dis = new DataInputStream(in);
			
			while(true) {
			
				//클라이언트가 접속을 했다고 가정하고??
				String key = dis.readUTF();
				if(dns.containsKey(key)) {
					String value = dns.get(key);
					dos.writeUTF(value);
					num++;
				}else {
					dos.writeUTF("not found");
					num++;
				}
				
				System.out.println("요청 "+num+"건 처리 완료");
				System.out.print("서버를 종료하시겠습니까? [y/n] : ");
				char re = sc.next().charAt(0);
				if(re == 'y') {
					System.out.println("[서버를 종료합니다.]");
					dos.writeBoolean(false);
					break;
				}else{
					dos.writeBoolean(true);
				}
				
			}//while
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				dis.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}//dnsServer
	
	
	
}//DnsServer
