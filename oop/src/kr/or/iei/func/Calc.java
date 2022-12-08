package kr.or.iei.func;

public class Calc {
	
	public int addFunction(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}
	
	
	public int subFunction(int num1, int num2) {
		int minus = num1 - num2 ;
		return minus;
	}
	
	public int mulFuntion(int num1, int num2) {
		return (num1*num2); //중요한건 변수가 아니라 값이기 때문에 바로 이렇게 넣어도 된다. 공간을 주는 게 아니라 값을 주는거임.
	}
	
	
	public double divFunction(int num1, int num2) {
		double div = (num1-0.0)/num2;
		return div;
	}
	

}
