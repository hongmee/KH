package kr.or.iei.start;

import java.lang.reflect.Method;

import kr.or.iei.func.MethodTest2;
import kr.or.iei.func.MethodTest3;
import kr.or.iei.func.MethodTest4;
import kr.or.iei.func.MethodExam;
import kr.or.iei.func.MethodTest;

public class Start {
	
	public static void main(String[] args) {
		
		MethodTest mt = new MethodTest();
		
//		mt.test1();
		
		MethodTest2 mt2 = new MethodTest2();
		
//		mt2.main();
		
//		mt2.test1();
//		mt2.test2();
		
		MethodTest3 mt3 = new MethodTest3();
		
//		mt3.main();
		
		
		MethodTest4 mt4 = new MethodTest4();
		
//		mt4.main();
		
		MethodExam me = new MethodExam();
		
		me.exam1(); //안녕하세요 메소드 예제 1번입니다 출력
		me.exam2(100); // 매개변수로 받은 값은 100입니다 출력
		me.exam2(100,200); // 매개변수 두 개의 값은 100과 200이며 두 수의 합은 300입니다 출력
		String result = me.exam3(100,200,300); //<--값이 뿅 들어가는게 아니라 이 메소드가 실행되는거임...
		System.out.println(result); 
		//매개변수 3개의 값은 100,200,300이며, 세 수의 합은 600입니다 출력
		
	}

}
