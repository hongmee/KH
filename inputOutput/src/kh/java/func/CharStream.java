package kh.java.func;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStream {
	private Scanner sc;
	
	public CharStream() {
		super();
		sc = new Scanner(System.in);
	}


	public void primaryStream() {
		
		System.out.print("저장할 파일명 입력 : ");
		String filename = sc.next();
		sc.nextLine();
		
		FileWriter fw = null;
		
		try {
			//입력받은 파일이름으로 파일을 생성 후 스트림 연결
			fw = new FileWriter(filename);
			System.out.println("["+filename+"]에 저장될 내용");
			System.out.println("*종료는 exit 입력");
			int lineNumber = 1;
			while(true) {
				System.out.print(lineNumber+" : ");
				String str = sc.nextLine()+"\r\n";
				lineNumber++;
				if(str.equals("exit\r\n")) {
					break;
				}
				fw.write(str);
			}//while
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//primaryStream
	
	public void subStream() {
		System.out.print("(서브)저장할 파일명 입력 : ");
		String filename = sc.next();
		sc.nextLine();
		//파일을 생성해서 내보낼 주스트림
		FileWriter fw = null;
		//주스트림에 기능을 부여할 보조스트림
		BufferedWriter bw = null;
		
		try {
			//주스트림 생성(이게 있어야 보조스트림도 쓸수 있음_)
			fw = new FileWriter(filename);
			//생성된 주스트림을 이용해서 보조스트림 생성
			bw = new BufferedWriter(fw); //<--주스트림을 매개변수로 넣어줘야 함
			System.out.println("["+filename+"] 파일에 저장될 내용");
			int lineNumber = 1;
			while(true) {
				System.out.print(lineNumber+" : ");
				String str = sc.nextLine();
				lineNumber++;
				if(str.equals("exit")) {
					break;
				}
				bw.write(str); //보조스트림을 이용한 데이터 전송. 어차피 주스트림 기능을 얘가 다 가지고 있(?)다
				bw.newLine(); // <--보조스트림에 존재하는 기능으로 줄 개행 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close(); //<--보조스트림이 닫히면 주스트림은 같이 종료.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}//subStream
	
	
	public void charReader() {
		System.out.print("읽어올 파일명 입력 : ");
		String filename = sc.next();
		sc.nextLine();
		//데이터를 읽어올 보조스트림
		BufferedReader br = null;
		try {
			//파일을 읽어올 주 스트림 생성
			FileReader fr = new FileReader("C:\\Users\\user1\\Desktop\\"+filename);
			br = new BufferedReader(fr);
			while(true) {
				//파일에서 한줄 읽어옴
				//다시호출하면 다음줄
				//더이상 읽어올게 없으면 null 리턴
				String str = br.readLine();
				if(str == null) {
					break;
				}
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}//CharStream
