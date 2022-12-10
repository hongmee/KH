package kr.or.iei.func;

public class TestClass {

	public void main() {
		for(int i=0 ; i<5 ; i++) {
			System.out.println((i+1)+"번째 출력입니다");
			sleep(500);
		}
		
	}//main 메소드
	
	
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//sleep 메소드
	
	
	
}//테스트클래스 끝
