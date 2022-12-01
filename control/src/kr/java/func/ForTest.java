package kr.java.func;

import java.util.Scanner;

public class ForTest {

	public void test1() {
		
		//for(초기;조건;증감)
		// 초기 : 반복 횟수를 위한 [변수 선언] 및 [초기화]
		// 조건 : 반복 횟수 조절
		// 증감 : 초기에서 선언된 변수를 증가 또는 감소
		
		// 보통 i를 쓰긴 함 index라는 뜻으로
		
		for(int i=0;i<5;i++) { //for(true)일 동안 코드가 실행됨. false되면 빠져나옴.
			System.out.println("안녕하세요 5번 치기");
			//코드가 끝나면 증감식-->조건식 순서로 순환한다.
			//(내생각) 초기식은 무조건? 한 번은 실행해주는구나...
		} 
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 번 출력하시겠습니까? : ");
		int count = sc.nextInt();
		
		for(int i=0;i<count;i++) {
			System.out.println((i+1)+" : 안녕하세요");
		}
	}
	
	
	public void test3() {
		// 구구단 2단 출력하기
		for(int i=1; i<=9; i++) {
			System.out.println("2 x " + i + " = " + (2*i));
		}
	}
	
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇단을 출력하시겠습니까? : ");
		int input = sc.nextInt();
		
		System.out.println("\n"+input+"단 입니다");
		
		for(int i=0; i<9; i++) { //증감연산자는 인접연산자가 있을때만 반응한다. 독립적으로 쓸때는 상관이없다.
			System.out.println( input + " x " + (i+1) + " = " + (input*(i+1)) );
		}
	}
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;

		for(int i=0;i<5;i++) {
			System.out.print("정수 값을 입력하세요("+ (i+1) +") : ");
			int input = sc.nextInt();
			
			sum += input;
		}
		System.out.println("입력한 5개의 정수의 합 : "+sum);
	}
	
	
	public void ghdal() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Password : ");
		String passWord = sc.nextLine();
		
		System.out.print("암호화된 패스워드 : ");
		for(int i=0;i<passWord.length();i++) {
			System.out.printf("%c",passWord.charAt(i)+10);
		}
	}
	
	
	
}
