package kr.or.iei.func;


public class CalcInterfaceImpl implements CalcInterface {
	
	
	public CalcInterfaceImpl() {
		super();
	}

	
	public int multi(int num1, int num2, int num3) {
		return num1 * num2 * num3;
	}
	
	@Override
	public int sum(int num1, int num2, int num3) {
		
		return num1 + num2 + num3;
	}

}
