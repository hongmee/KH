package ka.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class DnsClient {

	private Scanner sc ;
	
	
	public DnsClient() {
		super();
		sc = new Scanner(System.in);
	}


	public void dnsClinet() {
		
		//1. 접속할 서버의 IP와 port를 지정
		String serverIp = "192.168.10.41";
		int port = 8888;
		
		//2. 나중에 반환해줄 객체? 일단 선언
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			
			socket = new Socket(serverIp, port); //3. 소켓 생성. 이제 하나를 공유하고 있음
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream(); //4.스트림 추출
			
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out); //5. 추출한 스트림 강화
			
			boolean re = true;
			
			while(re) {
			
				System.out.print("알고싶은 도메인 주소를 입력하세요 : ");
				String domain = sc.next();
				dos.writeUTF(domain);
				
				String result = dis.readUTF();
				if(result.equals("not found")) {
					System.out.println("주소가 없습니다");
				}else {
					System.out.println("["+domain+"]의 주소는 "+result+"입니다.");
				}
			
				re = dis.readBoolean();
				if(!re) {
					System.out.println("[서버가 종료되었습니다.]");
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
		
		
		
		
	}//dnsClinet
	
	
}//DnsClient
