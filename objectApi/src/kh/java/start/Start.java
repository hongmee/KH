package kh.java.start;

import java.util.Scanner;

import kr.java.func.ApiClass;
import kr.java.func.StringClass;
import kr.java.func.TestClass;

public class Start {
	
	public static void main(String[] args) {
	
		StringClass sc = new StringClass();
//		sc.test1();
//		sc.test2();
		sc.exam();
		
		ApiClass ac = new ApiClass();
//		ac.Math();
//		ac.date();
//		ac.calendar();
//		ac.test2();
		
//		ac.dDayExam();
//		ac.reviewDDay();
		
//		ac.wrap();
		
		
		
//		int[] arr = new int[5];
//		TestClass tc = new TestClass();
		//arr.clone <--실제로는 Object의 메소드인데 int[]이 .clone을 오버라이딩 한거다. 
		
		
		
/*		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요(1) : ");
		String str1 = sc.next();
		System.out.print("문자열을 입력하세요(2) : ");
		String str2 = sc.next();
		if(str1.equals(str2)) { //<--equlas : 내부에 들어있는 값이 같은지 다른지 활용하는 메소드. 주로 문자열에 사용이 된다.
			System.out.println("두 문자열이 같습니다");
		}else {
			System.out.println("두 문자열이 다릅니다");
		}
*/		
		
/*		String str3 = "aaa";
		String str4 = "aaa";
		if(str3 == str4) {
			System.out.println("같습니다"); //<--이건 같다고 나옴...!!!!! 
		}else {
			System.out.println("다릅니다");
		}
		// 위와 같은 방식으로, String str3="aaa";로 문자열 값을 냅다 넣으면, 참조형이 맞긴 한데 주소가 가르치는 값이 새 메모리 공간이라기 보단 문자열을 직접 가르킨다(??)
*/		
		
		
/*		TestClass tc = new TestClass();
		
		
		//toString(); 고유값을 준다.
		
		String str = tc.toString();
		System.out.println(str); //<-- 얘네고유값은 같음
		
		TestClass tc1 = new TestClass();
		
		System.out.println(tc1.toString()); //<--얘 고유값은 다름
		
		TestClass tc2 = tc; //<--얕은복사가 됨
		System.out.println(tc2.toString()); //<-- 얘네고유값은 같음
		
		
		System.out.println(tc); //출력할 때, '객체 이름'으로 호출하면 자동으로 toString메소드가 호출된다.
		System.out.println(tc1);
		System.out.println(tc2);
		
		System.out.println("=================");
		tc.setTestNum(1000);
		tc.setTestStr("안녀엉");

		System.out.println(tc);
*/
		
		
		
	}//main 메소드 끝
	
	
	

}
