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

public class shadowDNSServer {

	private Scanner sc;
	HashMap<String, String> dns;
	int num;
	
	public shadowDNSServer() {
		super();
		
		sc = new Scanner(System.in);
		
		dns = new HashMap<String, String>();
		dns.put("www.naver.com", "125.209.222.142");
		dns.put("www.google.com", "172.217.175.4");
		dns.put("www.iei.or.kr", "211.43.14.187");
		
		num = 0;
		
	}//생성자
	
	
	public void server() {
		
		int port = 8888;
		
		ServerSocket server = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		
		try {
			
			server = new ServerSocket(port);
			System.out.println("서버 준비 완료");
			int count = 1;
			while(true) {
				System.out.println("클라이언트 요청 대기 ......");
				Socket socket =  server.accept(); //<--접속
				
				OutputStream out = socket.getOutputStream();
				InputStream in = socket.getInputStream();
				
				dos = new DataOutputStream(out);
				dis = new DataInputStream(in);
				
				
				String domain = dis.readUTF();
				String ipAddr = dns.get(domain);
						
		/*		if(dns.containsKey(domain)) { //데이터가 있을 때
					
				}else { //데이터가 없을 때
					
				}
		*/
				if(ipAddr != null) {
					String sendMsg = "["+domain+"]의 주소는 "+ipAddr+"입니다. ";
					dos.writeUTF(sendMsg);
				}else {
					dos.writeUTF("주소가 없습니다.");
				}
				
				System.out.println("요청 "+count+"건 처리 완료");
				count++;
				System.out.print("서버를 종료하시겠습니까? [y/n]");
				String isEnd = sc.next();
				
				if(isEnd.equals("y")) {
					break;
				}
			}//while
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dis.close();
				dos.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
				
		
	}
	
	
	
}//shadowDNSServer
