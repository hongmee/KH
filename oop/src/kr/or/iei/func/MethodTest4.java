package kr.or.iei.func;

import java.util.Scanner;

public class MethodTest4 {

	public void main() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력(1) : ");
		int num1 = sc.nextInt();
		System.out.print("정수 입력(2) : ");
		int num2 = sc.nextInt();
		System.out.print("정수 입력(3) : ");
		int num3 = sc.nextInt();
		
		int result = sum(num1,num2);
		System.out.println("sum 메소드를 사용해서 나온 값은 "+result);
		
		int result2 = sum(num1, num2, num3); // <-- 메소드 이름이 같더라도 매개변수의 개수를 통해 구분이 가능하기 때문에 컴퓨터가 헷갈리지 않고 수행가능하다. 
		System.out.println("sum2 메소드를 사용해서 나온 값은 "+result2);
		
	}
	
	public void test(int num1, int num2, String str) {
		
	}
	
	
	public void test(String str, int num0, int num1) {
		
	}
	
	
	public int sum(int one, int two) {
		int result = one+two;
	
		return result;
	}
	
	
	public int sum(int one, int two, int three) {
		int result = one+two+three;
		
		return result;
	}
	

	
	
	
}//클래스 끝
