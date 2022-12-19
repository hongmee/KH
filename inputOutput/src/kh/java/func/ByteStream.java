package kh.java.func;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStream {

	public void primaryStream() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("저장할 파일명 입력 : ");
		String fileName = sc.next();
		sc.nextLine();
		//프로그램 기준으로 파일을 생성하여 입력텍스트를 내보내는 프로그램
		FileOutputStream fos = null; //<-스트림 생성
		
		try {
			//입력받은 파일명으로 파일을 생성
			//생성된 파일과 stream연결(데이터를 내보내는 스트림)
			fos = new FileOutputStream(fileName); //<--제목?파일명?
			System.out.println("["+fileName+"]파일에 저장될 내용 입력");
			System.out.println("(*\'exit\'를 입력하면 종료.)");
			int lineNumber = 1;
			while(true) {
				System.out.print(lineNumber + " : ");
				String str = sc.nextLine()+"\r\n"; //<--입력한 문자열에 윈도우 엔터 추가
				//FileOutputStream는 1바이트 단위로 전송이라 1바이트로 쪼개줘야함
				lineNumber++;
				
				if(str.equals("exit\r\n")){
					break;
				}
				
				byte[] arr = str.getBytes(); //<--자동으로 byte로 쪼개줌
				fos.write(arr); //파일로 데이터 전송
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { //<--입출력 중간에 에러났다는 뜻
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close(); //<--썼던 스트림 돌려주기
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}//primaryStream
	
	
}//ByteStream
