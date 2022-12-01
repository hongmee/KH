package kr.java.func;

import java.util.Scanner;

public class SwitchTest {

	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~3사이의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		//if ~ else if는 조건범위를 피라미드 형태로 코딩해야 하지만
		//switch는 조건범위가 서로 독립적이다. (코딩 순서가 상관이 없다)
		
		switch(num){ 
		case 1 :
			System.out.println("1을 입력함 !!!");
			break;
		case 2 : //<-- 만약 2를 입력했다면 이 case만 동작하고 break를 통해 switch문을 빠져나가버림. 그리고 순서 무관하기 때문에 case 2를 1보다 더 먼저 써도 상관없음.
			System.out.println("2을 입력함 !!!");
			break;
		case 3 :
			System.out.println("3을 입력함 !!!");
			break;
		default : //else 같은 느낌
			System.out.println("잘못 입력 !!!");
		}
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("일수를 알고싶은 월을 입력하세요 : ");
		int month = sc.nextInt();
		
		//break;를 사용하지 않으면 switch를 벗어나지 않는 특성을 이용하기
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31일");
			break;
			
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30일");
			break;
		
		case 2:
			System.out.println("28일");
			break;
			
		default: //이부분은 비워둬도 상관은 없습니다
			System.out.println("1~12월중에 입력하세요");
			break;
		}
	}
	
	
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		
		//if는 ==로 문자열 비교하는게 안 돼서 .eqauls("문자열") 해 줘야 하는데
		//switch는 문자열도 ==로 비교하는거 해 줌 (자바 1.7이상)
		
		switch (str) {
		case "a":
			System.out.println("aaaa");
			break;
		case "b":
			System.out.println("bbbb");
			break;
		case "c":
			System.out.println("cccc");
			break;
		default:
			System.out.println("그 외의 문자");
			break;
		}
		
	}
	
	
	
	
	
}
