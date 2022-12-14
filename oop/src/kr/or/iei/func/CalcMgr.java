package kr.or.iei.func;


import java.util.Scanner;
import kr.or.iei.func.CalcInterfaceImpl;

public class CalcMgr {



	public void main() {
		
		//사용자한테 숫자를 입력받아서 계산기 객체에 전달 --> 결과를 받아서 출력
		
		Scanner sc = new Scanner(System.in);
		
		CalcInterfaceImpl calc = new CalcInterfaceImpl();
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("세번째 정수 입력 : ");
		int num3 = sc.nextInt();
		
		int result = calc.sum(num1, num2, num3);
		int result2 = calc.multi(num1, num2, num3);
		
		System.out.println("입력한 정수의 총 합은 : "+result);
		System.out.println("입력한 정수를 모두 곱하면 : "+result2);
		
	}//main 메소드 끝
	
	
	
}
