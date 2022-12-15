package kr.java.func;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StringClass {

	
	public void test1() {
		//java.lang에 있는 클래스는 import없이 사용 가능
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.length()); //<--저장된 문자열의 길이를 가져옴
		sb.append("hi"); //현재 저장된 문자열 맨 뒤에 매개변수로 받은 문자열 추가
		System.out.println(sb.length());
		
		System.out.println(sb.toString());
		sb.append(" 안녕");
		System.out.println(sb.length());
		System.out.println(sb.toString());
		
		sb.append(" test");
		System.out.println(sb);
		
		sb.insert(3, "삽입구문"); //<--첫번째 매개변수 위치에 두번째 값을 삽입. 기존 문자열 중 해당 매개변수 위치부터는 삽입되는 값 뒤로 밀림.
		System.out.println(sb.toString());
		
		sb.insert(7, " 여기 ");
		System.out.println(sb);
		
		sb.replace(0, 2, "수정구문"); //<-- (수정할시작위치, 수정종료위치+1, 수정할글자)...대충 for(int i=0; i<길이; i++)...이 개념으로 생각하면 됨
		System.out.println(sb.toString());
		
		sb.delete(5, 8); //<--replace의 삭제버전! 세 번째 매개변수가 없다.
		System.out.println(sb.toString());
		
		sb.reverse();//문자열 배치 반전
		System.out.println(sb.toString());
	
		
		//sb 사용예시 - 이메일 인증 코드 생성하기
		StringBuffer randomCode = new StringBuffer();
		Random r = new Random();
		for(int i=0; i<6 ; i++) {
			int ranNum = r.nextInt(10);
			randomCode.append(ranNum);
		}
		System.out.println(randomCode); //숫자6자리랜덤코드
		
		StringBuffer randomCode2 = new StringBuffer();
		for(int i=0; i<6 ; i++) {
			int flag = r.nextInt(3);//0:숫자,1:대문자,2:소문자
			if(flag==0) {
				int ranNum = r.nextInt(10);
				randomCode2.append(ranNum);
			}else if(flag==1) {
				int ranNum = r.nextInt(26)+65;
				randomCode2.append((char)ranNum);
			}else {
				int ranNum = r.nextInt(26)+97;
				randomCode2.append((char)ranNum);
			}
		}
		System.out.println(randomCode2); //영대소숫자 6자리코드
		
	}//test1
	
	
	public void test2() {
		
		String str = "김홍미/인천/학생";
		StringTokenizer sT = new StringTokenizer(str,"/"); //<--(자르고싶은 문자열, 구분자)...이렇게 해서 잘린 각각의 문자열을 "토큰"이라고 한다

		int token = sT.countTokens();
		while(sT.hasMoreTokens()) {//--> hasMoreTokens : 꺼내올 토큰이 있으면 True, 엎으면 False;
			System.out.println("토큰("+token+") : "+sT.nextToken());
			token--;
		}
		
/*		while(sT.countTokens()!=0) {
			System.out.println(sT.nextToken());
		}
*/		
		
		/*	System.out.println("토큰 수 : "+sT.countTokens());
		String str1 = sT.nextToken(); //현재 남아있는 토큰들 중 가장 앞 토큰 하나를 꺼내옴. '복사(X)','꺼내온다(O)'라는 개념이라 토큰 수 하나가 사라지는 것이다.
		System.out.println("첫 번째 토큰 : "+str1);
		System.out.println("토큰 수 : "+sT.countTokens());
		System.out.println("두 번째 토큰 : "+sT.nextToken());
		System.out.println("토큰 수 : "+sT.countTokens());
		System.out.println("세 번째 토큰 : "+sT.nextToken());
		System.out.println("토큰 수 : "+sT.countTokens());
*/
		
		//StringTokenizer와 유사한 기능
		String[] arr = str.split("/"); //<--매개변수로 전달한 값 기준으로 문자열을 잘라서 문자열 배열로 리턴한다. 자른데이터가 계속 필요하다면 이게 좋고, 자른 데이터를 한 번 쓰고 말 거면 Tokenizer가 좋고...?
		
	}//test2
	
	
	public void exam() {
		

		String str = "J a v a P r o g r a m";
		
		//--> 전부 대문자로 변환해서 출력, 공백은 없앰.
		
/*		//split을 이용한 방법
 		String[] strUp = str.split(" ");
		for(int i=0 ; i<strUp.length ; i++) {
			char ch = strUp[i].charAt(0);
			if(ch<=90) {
				System.out.print(strUp[i]);
			}else if(97<=ch && ch<=122){
				System.out.print((char)(ch-32));
			}
		}//대문자로 바꾸는 for문
*/
		
		//StringTokenizer를 이용한 방법
		StringTokenizer sT = new StringTokenizer(str," ");
		StringBuffer sb = new StringBuffer();
		
		while(sT.hasMoreElements()) {
			String st = sT.nextToken();
			char ch = st.charAt(0);
			if('a'<=ch && ch<='z') {
				ch -= 32;
			}
			sb.append(ch);
			System.out.print(ch);
		}
		
		
	}//exam 메소드 끝
	
	
	
	
	
	
	
	
}//StringClass 끝
