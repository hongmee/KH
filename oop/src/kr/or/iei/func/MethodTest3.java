package kr.or.iei.func;

import java.util.Scanner;

public class MethodTest3 {
	
	
	public void main() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세용 : ");
		int num = sc.nextInt();
		System.out.println("main 메소드에서 입력한 정수는 : "+num);
		plusTen(num); // <--num값이 plusTen()이라는 메소드에 들어가서 실행시켜주겠다는 뜻. 근데 plusTen()은 void라 리턴값이 없고 화면출력만 해주는 애다.
		System.out.println(num); 
		
		int[] arr = {1,2,3,4,5};
		System.out.println(arr[2]); //3
		addArr(arr); //100 <-- 메소드에 배열을 넣으면 얕은복사(주소값이 전달)
		
		int[] arr1 = {1,2,3,4,5};
		addData(arr1[2]); //3 <--메소드에 배열[인덱스주소]로 넣으면 깊은복사(값이 전달)
		System.out.println(arr1[2]); //3
	}
	
	public void addData(int num) {
		num +=10;
		System.out.println(num);
	}
	
	
	
	
	
	
	public void addArr(int[] arr) { //<--★☆★ 배열이 얕은복사됩니다!!! 왜냐면 배열인 arr[]은 0x11(예시)이라는 주소값을 가지고 있기 때문임.
		
		arr[2]=100;
		
		System.out.println(arr[2]); // 100
		
	}
	

	//메소드(출력까지하는 메소드)
	//main에서 입력받은 정수에 +10한 결과를 출력한다
	public void plusTen(int num1) { // <--이것도 변수선언 해준거임. 새로운 공간이 생긴거임.
		
		num1 += 10 ;
		
		System.out.println("plusTen메소드로 10 더해서 나온 값 : "+num1);
	}
	
	
	
	
	
	
	
	
}//클래스 끝

