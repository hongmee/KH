package kr.java.func;

import java.util.Scanner;

public class WhileTest {
	
	public void test1() {
		//안녕하세요 5번 출력하기
		
		int i = 0; // (1)초기식을 미리 초기화해준다!!!!!
		while(i<5) {
			System.out.println("안녕하세요 while문 연습입니다("+(i+1)+")");
			i++; // (3)증감식을 실행문 내부에서 해준다!!!!!
			     // but 편의에 따라서 증감식 위치를 자유롭게 바꿔줄 수 있다!!!!! 그냥 첫번째 줄에 넣어도 됨!!!!
		}
	}

	
	public void test2() {
		//안녕하세요 5번 출력
		int i=0;
		do {
			i++;
			System.out.println(i+"번째 실행(do~while) : 안녕하세요");
		}while(i<5);
	}
	
	
	public void test3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("반복 횟수를 입력하세요 : ");
		int count = sc.nextInt();
		//while문을 이용해서 안녕하세요를 입력받은 횟수만큼 출력
		
		int i = 0;
		while(i<count) {
			i++;
			System.out.println(i+"번째 출력 : 안녕하세요~!");
		}
	}
	
	
	public void exam1() {
		System.out.println("구구단 2단 출력하기");
		System.out.println("2단 입니다");
		
		int i = 0;
		while(i<9) {
			i++;
			System.out.println("2 * "+i+" = "+(2*i));
		}
	}
	
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 단을 출력하시겠습니까? : ");
		int input = sc.nextInt();
		
		System.out.println(input+"단 입니다 ========");
		
		int i = 0;
		while(i<9) {
			i++;
			System.out.println(input+" * "+i+" = "+(input*i));
		}
	}
	
	
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		int i = 0;
		while(i<5) {
			System.out.print("정수 값을 입력하세요("+(i+1)+") : ");
			int num = sc.nextInt();
			
			sum += num;
			i++;
		}
		System.out.println("입력한 5개 정수의 합 : "+sum);
	}
	
	
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int num1;
		
		System.out.print("첫번째 수를 입력하세요 : ");
		int i = sc.nextInt();
		System.out.print("두번째 수를 입력하세요 : ");
		int num2 = sc.nextInt();

		num1=i;
		
		while(i<=num2){ //while(i<(num2-num1+1)) 이라고 해도 됨..이 개념을..이해핶
						//while(i<()
			sum += i;
			
			i++;
		}
		System.out.println(num1+"(포함)부터"+num2+"(포함)까지 사이의 합 : "+sum);
	}
	
	
	public void exam5() {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		int i = 0;
		
	/*	while(i<=num) {
			sum += i;
			i+=2;
		}
	*/
		while(i<=num) {
			if(i%2==0) {
				sum+=i;
			}
			i++;
		}
		
		System.out.println("1부터 "+num+"까지의 짝수들의 합은 : "+sum);
	}
	
	
	
}
