package kr.or.iei.func;

import java.util.Scanner;

public class MethodTest {
	
	public void test1() {
		System.out.println("테스트 1입니다");
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("첫번째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		test5(num2, num1, str);

	}
	
	private int test2() {
		System.out.println("테스트 2입니다"); // <--(2) 메소드가 실행됐으니 일단 이 문구가 콘솔창에 뜬다
		return 100; // <--(3) test2에 리턴값이 들어간다
	}
	
	public String test3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("테스트 3입니다");
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num==1) {
			return "1";
		}
		return "2";
	}
	
	
	public void test4(int num) {
		System.out.println("test4입니다");
		System.out.print("매개변수로 받은 값 : "+num);
	}
	
	
	public void test5(int num1, int num2, String str) { // <--이 메소드 쓰려면 꼭!! 값을 세개!! 써줘야함!!
		System.out.println("test5 입니다!!");
		System.out.println("매개변수로 받은 num1 : "+num1);
		System.out.println("매개변수로 받은 num2 : "+num2);
		System.out.println("매개변수로 받은 str : "+str);
	}
	
	
	
	

} // 클래스 마침
