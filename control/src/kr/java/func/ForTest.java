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
		/* int sum = 0;

		for(int i=0;i<5;i++) {
			System.out.print("정수 값을 입력하세요("+ (i+1) +") : ");
			int input = sc.nextInt(); //생성한 변수는 그 변수를 감싸고 있는 가장 가까운 중괄호 범위까지만!!!!!!!!!
			
			sum += input;
			}
		System.out.println("입력한 5개의 정수의 합 : "+sum);
		*/
		
		int input = 0;

		for(int i=0;i<5;i++) {
			System.out.print("정수 값을 입력하세요("+ (i+1) +") : ");
			input += sc.nextInt(); //생성한 변수는 그 변수를 감싸고 있는 가장 가까운 중괄호 범위까지만!!!!!!!!!
			}
		System.out.println("입력한 5개의 정수의 합 : "+input);
		
		/*for문을 사용하지 않고 
		   System.out.print("정수 값을 입력하세요("+ (i+1) +") : ");
		   int input = sc.nextInt();
		   System.out.print("정수 값을 입력하세요("+ (i+1) +") : ");
		   int input = sc.nextInt();
		   System.out.print("정수 값을 입력하세요("+ (i+1) +") : ");
		   int input = sc.nextInt();
		   System.out.print("정수 값을 입력하세요("+ (i+1) +") : ");
		   int input = sc.nextInt();
		   System.out.print("정수 값을 입력하세요("+ (i+1) +") : ");
		   int input = sc.nextInt();
		   를 일일이 5번 반복해주면, 한 중괄호에 같은 이름의 변수가 중복 선언되어 에러가 난다
		 */
	}
	
	
	
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		int num2 = sc.nextInt();
		
	/*	
		if(num1 < num2) {
			int sum = num1;
			for(int i=num1;i<=num2;i++) {
				sum += i ;
			}
			System.out.println(num1+"(포함) ~ "+num2+"(포함) 정수의 합 : "+ (sum-num1) );
		}else if(num1 > num2){
			int sum = num2;
			for(int i=num2;i<=num1;i++) {
				sum += i ;
			}
			System.out.println(num1+"(포함) ~ "+num2+"(포함) 정수의 합 : "+ (sum-num2) );
		}
	*/
		
		int sum = 0;
		for(int i=0; i<(num2-num1+1);i++) {
			//num1 ~ num2 사이의 모든 수의 합 --> (num2 - num1 + 1) 만큼 반복해야 함 
			sum += i+num1;
		}
		
		System.out.println(num1+" ~ "+num2+"의 정수의 합 : "+sum);
		
	}
	
	
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		
		/* for(int i=2;i<=num;i+=2) {
			sum += i;
		}
		*/
		
		// !!!!!!!!!!!!!!
		// 증감을 +2씩 해주고 싶으면, for(초기;조건;i++){ 실행문~... 마지막 줄에 i++; 넣기 } 해줘도 된다
		
		for(int i=1;i<=num;i++) {
			if(i%2==0) {
				sum += i;
			}
		}
		
	
		System.out.println("1 부터 "+num+"까지 숫자 중 [짝수]들의 합계 : "+sum);
		
	}
	
	
}
