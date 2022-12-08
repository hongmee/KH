package kr.or.iei.func;

public class MethodExam {
	
	
	public void exam1() {
		System.out.println("안녕하세요 메소드 예제 1번입니다.");
	}
	
	
	public void exam2(int num) {
		System.out.println("매개변수로 받은 값은 "+num+"입니다.");
	}
	
	
	public void exam2(int num1, int num2) { //<--메소드 오버로딩 중
		int sum = num1+num2;
		System.out.println("매개변수 두 개의 값은 "+num1+"과 "+num2+"이며 두 수의 합은 "+sum+"입니다.");
	}
	
	
	public String exam3(int num1,int num2,int num3) {
		int sum = num1+num2+num3;
		
		String print = "매개변수 3개의 값은 "+num1+", "+num2+", "+num3+"이며, 세 수의 합은 "+sum+"입니다.";
		return print;
		
		
	/*	System.out.println("매개변수 3개의 값은"+num1+","+num2+","+num3+"입니다. 합은"+sum);
		return "";
	*/ //<--이건 안됨!!!!!!!!! 생각해봐
		
	}
	
	

}//클래스 끝
