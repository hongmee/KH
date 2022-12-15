package kr.java.func;

public class TestClass { //extends Object
	
	private String testStr;
	private int testNum;
	
	
	public TestClass() {
		super();
	}
	
	public TestClass(String testStr, int testNum) {
		super();
		this.testStr = testStr;
		this.testNum = testNum;
	}



// G/S
	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}


	public int getTestNum() {
		return testNum;
	}

	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}



//추가 메소드
	public void test() {
		
	}
	
	@Override
	public String toString() {
		String str = "TestClass(testStr : "+getTestStr()+", testNum : "+getTestNum()+")";
		
		return str;
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}//TestClass 끝
