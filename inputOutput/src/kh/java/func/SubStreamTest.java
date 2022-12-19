package kh.java.func;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SubStreamTest {

	public void test1() {
		//보조스트림을 사용하는 버전
		//quiz.txt 파일에 있는 내용을 읽어오기 위한 보조스트림
		BufferedReader br = null;
		//읽어온 파일을 변환 후 이미지로 내보내기 위한 보조스트림
		BufferedOutputStream bos = null;
		
		try {
			//파일을 읽어오기 위한 주스트림 생성
			FileReader fr = new FileReader("quiz.txt");
			//생성된 주스트림을 이용해서 보조스트림 생성
			br = new BufferedReader(fr);
			
			//"quiz.txt"파일은 한줄짜리 파일이여서 이렇게 해준거임...
			String str = br.readLine();
			//읽어온 문자열은 16진수[공백]16진수[공백]16진수......
			//공백을 제거한 16진수 리스트 생성(16진수가 몇개있을지 모르니까 리스트)
			//읽어온 16진수를 byte 타입으로 저장할 list
			ArrayList<Byte> data = new ArrayList<Byte>();
			//긴문자열에서 공백을 제거하기위한 객체
			StringTokenizer sT = new StringTokenizer(str," ");
			while(sT.hasMoreTokens()) {
				String num = sT.nextToken(); //<--StringTokenizer로 가져온거라 String
				int iNum = Integer.parseInt(num,16);
				byte bNum = (byte)iNum;
				data.add(bNum);
			}
			System.out.println("파일 읽기 완료");
			System.out.println("리스트 길이 : "+data.size());
			
			
			//이미지파일을 내보내기 위한 주스트림 생성
			FileOutputStream fos = new FileOutputStream("test.gif");
			//생성된 주스트림을 이용하여 보조스트림 생성
			bos = new BufferedOutputStream(fos);
			for(byte b : data) {
				bos.write(b);
			}
			System.out.println("파일 내보내기 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}//test1
	
	
	public void test2() {
		//주스트림만 사용해보기
		//읽어오기 위한 주스트림
		FileReader fr = null;
		//test.gif를 내보내기 위한 주스트림
		FileOutputStream fos = null;
		
		try {
			fr = new FileReader("quiz.txt");
			//보조스트림이 없으니까 한글자씩 받아와야 함
			StringBuffer sb = new StringBuffer();
			while(true) {
				int data = fr.read(); //<--문자 1개를 읽어옴. 만약 파일의 끝까지 다읽어서 읽어올게 없으면 .read()가 -1을 리턴하다. (*-1 = 문자가 아님)
				if(data==-1) {
					break;
				}
				char ch = (char)data;
				sb.append(ch);
			}
			
			ArrayList<Byte> data = new ArrayList<Byte>();
			//긴문자열에서 공백을 제거하기위한 객체
			StringTokenizer sT = new StringTokenizer(sb.toString()," ");
			while(sT.hasMoreTokens()) {
				String num = sT.nextToken(); //<--StringTokenizer로 가져온거라 String
				int iNum = Integer.parseInt(num,16);
				byte bNum = (byte)iNum;
				data.add(bNum);
			}
			System.out.println("파일 읽기 완료");
			System.out.println("리스트 길이 : "+data.size());
			
			
			fos = new FileOutputStream("test1.gif");
			for(byte b : data) {
				fos.write(b);
			}
			System.out.println("파일내보내기완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}//test2
	
	
	
}//SubStreamTest
