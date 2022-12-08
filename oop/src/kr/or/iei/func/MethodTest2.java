package kr.or.iei.func;

import java.util.Scanner;

public class MethodTest2 {
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		//문자 1개 입력받아서
		//입력받은 문자를 메소드의 매개변수로 전달.
		
		System.out.print("영문 한글자를 입력하세요 : ");
		char cha = sc.nextLine().charAt(0); //한글자 받는건 없고 이렇게 해줘야함!! (1)문자열로 받아서 첫번째 한글자를 떼어온다.
		
		char result = change(cha); //(2)변수 cha가 change메소드의 매개변수로 쓰인다.
		System.out.println("=====");
		System.out.print("변환된 문자입니다 : "+result);
		
	}
	
	//메소드 만들 위치.
	//메소드 기능 : 매개변수로 받은 문자를 대-->소, 소-->대로 변경하여 변환.
	
	public char change(char alpha) { //(3)매개변수 cha를 받아서 메소드를 실행한다.
		
		alpha ^=32; //비트 연산자래.................
		
		return alpha;
		
		
/*		char result =' ';
		
		if('A'<=alpha && alpha<='Z') { //<-어차피 정수연산자('1'+'1'하면 98나오는것처럼)이기때문에 알아서 숫자화해서 연산할거임. 
									   //(4) 정수<=문자 && 문자<=정수 
			result += 32;
		}else if(97<=alpha && alpha<=122) {
			result = (char)(alpha-32);
		}else {
			result = '♡';
		}
		
		
		return result;
*/
		
	}
	
	

	MethodTest mt = new MethodTest();
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		
		Calc c = new Calc();
		
		int result1 = c.addFunction(num1, num2); //더하기 기능을 수행하는 메소드 호출
		int result2 = c.subFunction(num1, num2);
		int result3 = c.mulFuntion(num1, num2);
		double result4 = c.divFunction(num1, num2);
		
		System.out.println("더한결과 : "+result1);
		System.out.println("뺀결과 : "+result2);
		System.out.println("곱한결과 : "+result3);
		System.out.printf("나눈결과 : %.2f",result4);
		
		System.out.println("\n====");
		System.out.println("궁금한데 이렇게 쳐도 더한값이 바로 나오나? : "+c.addFunction(num1, num2)); //나오네요!
				
		
	}
	
	
	
	public void main() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("메소드 테스트입니다");
		
		System.out.print("정수를 입력해주세요 ! : ");
		int num1 = sc.nextInt();
		System.out.print("정수를 입력해주세요 ! : ");
		int num2 = sc.nextInt();
		
		int sum1 = sum(num1, num2); //<-- 메소드를 호출해준 자리는, 해당 메소드의 return값이 들어간다.
		System.out.println(sum1); 
		
		System.out.print("정수를 입력해주세요 ! : ");
		int num3 = sc.nextInt();
		System.out.print("정수를 입력해주세요 ! : ");
		int num4 = sc.nextInt();
		int sum2 = sum(num3, num4); 
		System.out.println(sum2);
		
		
		mt.test1();
		
	}
	
	public int sum(int su1, int su2) {
		int sum = su1+su2;
		return sum;
	}
	
}
