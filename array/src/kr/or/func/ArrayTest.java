package kr.or.func;

import java.util.Iterator;
import java.util.Scanner;

public class ArrayTest {
	
	public void test1() {
		int num0 = 1;
		int num1 = 2;
		int num2 = 3;
		int num3 = 4;
		int num4 = 5;
		
		System.out.println("변수를 출력");
		System.out.println(num0);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);

		//배열을 이용해서 1~5를 대입하고 출력하는 코드
		
		int[] arr = new int[5];
		// int[] arr : arr이라는 이름으로 선언
		// new int[5] : 길이 5짜리 기본값이 들어가있는 공간이 생김
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		System.out.println("배열로 출력");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);

		for(int i=0; i<5 ; i++) {
			System.out.println("for문을 이용한 출력 "+arr[i]);
		}

	}
	

	public void test2() {
		Scanner sc = new Scanner(System.in);
		// 길이 3짜리 배열을 만들어서 순서대로 1,2,3 데이터 대입하기
		// 방법1. 길이 3인 배열 생성 후 각 인덱스에 값 직접 대입
		int[] arr1 = new int[3]; // 길이 3인 배열 생성 후 0 0 0으로 초기화 과정!!!!!!!
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		
		// 방법2. 길이 3인 배열 생성 후 각 index에 값 for문 이용한 대입
		int[] arr2 = new int[3];
		for(int i=0;i<3;i++) {
			arr2[i] = i+1;
		}
		
		// 방법3. 중괄호를 이용하는 방법. 특정한 경우가 아닌 이상 잘 안 쓰인다고.....
		int[] arr3 = {1,2,3} ;
		
		
		// 변수를 5개 선언해서 스캐너로 값을 5번 입력받아 저장하는 코드
		int num0 = 0 ;
		int num1 = 0 ;
		int num2 = 0 ;
		int num3 = 0 ;
		int num4 = 0 ;
		System.out.print("첫번째 정수를 입력하세요 : ");
		num0 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("세번째 정수를 입력하세요 : ");
		num2 = sc.nextInt();
		System.out.print("네번째 정수를 입력하세요 : ");
		num3 = sc.nextInt();
		System.out.print("다섯번째 정수를 입력하세요 : ");
		num4 = sc.nextInt();
		
		//길이가 5인 배열
		int[] arr = new int[5];
		for(int i=0;i<5;i++) {
			System.out.print((i+1)+"번째 정수를 입력하세요 : ");
			arr[i] = sc.nextInt();
		}
		for(int i =0;i<5;i++) {
			System.out.println(arr[i]);
		}
		
		
	}
	
	
	public void exam1() {
		String[] arr1 = {"딸기","복숭아","키위","사과","바나나"};
		String[] arr = new String[5];
		arr[0] = "딸기";
		arr[1] = "복숭아";
		arr[2] = "키위";
		arr[3] = "사과";
		arr[4] = "바나나";
		System.out.println("1-1. 배열 인덱스를 이용해서 바나나 출력");
		System.out.println("나는 : "+arr[4]);
		
		System.out.println("1-2. for문을 쓰지 않고 전체 출력");
		System.out.println(arr[0]+", "+arr[1]+", "+arr[2]+", "+arr[3]+", "+arr[4]);
		
		System.out.println("1-3. for문을 이용하여 전체 출력");
		for(int i = 0; i<5 ; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	public void exam2() {
		//길이가 100인 배열을 선언
		int[] arr = new int[100];
		for(int i=0 ; i<100 ; i++) { //배열에 값넣기
			arr[i] = i+1 ;
		}
		System.out.println("for문을 이용해서 값 출력하기");
		for(int i=0 ; i<100; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		
	
		String[] sub = {"국어","영어","수학","과학","음악"};
		int[] arr = new int[(sub.length+1)]; //+1은 합계 들어갈 공간임
		//배열이름.length --> 배열의 길이 를 가져온다~~ 그럼 int인가?
		//sub.length --> 4
		
		for(int i=0; i<sub.length ; i++) {
			System.out.print(sub[i]+"점수를 입력하세요 :");
			arr[i] = sc.nextInt();

			arr[arr.length-1] += arr[i];
		}
		double avg = (double)arr[arr.length-1]/sub.length;
		System.out.println("================");
		for(int i=0 ; i<sub.length ; i++) {
			System.out.println(sub[i]+"점수 : "+arr[i]);
		}
			System.out.println("합계 : "+arr[arr.length-1]);
			System.out.printf("평균 : %.2f",avg);
			
	}
	
	
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[7];
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print((i+1)+"번째 숫자 입력 : ");
			arr[i] = sc.nextInt();
		}
		
		//배열 버블 정렬하기
		//arr[0]과 [1]값을 비교해서 더 크면 자리를 바꾸는 로직
		//if : 값에 따라서 어쩌구......
	/*	if(arr[0]>arr[1]) {
			int tmp = arr[0];
			arr[0] = arr[1];
			arr[1] = tmp;
		}
		if(arr[1]>arr[2]) {
			int tem=arr[1];
			arr[1]=arr[2];
			arr[2]=tem;
		}
		if(arr[2]>arr[3]) {
			int tem = arr[2];
			arr[2] = arr[3];
			arr[3] = tem;	
		}
		if(arr[3]>arr[4]) {
			int tem = arr[3];
			arr[3] = arr[4];
			arr[4] = tem;
		}
		*/
		
	/*	for(int i = 0 ; i<arr.length-1 ; i++) { // 숫자 한개에 대한 자리비교행위 = 자리길이-1
			for(int j = 0 ; j<arr.length-1-i ; j++) { // [숫자 비교 행위]를 몇번 해줘야 하는가 = 자리길이-1 . * i는 자리비교를 각 턴마다 조금씩 줄여주기 위해 넣음.
				if(arr[j]>arr[j+1]) {
					int tem = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tem;
				}
			}
		} */// 오름차순 정렬~~~~~ 
		
		
		  
//		   버블정렬의 원리를 이용해서!!!!!!!!!!
		 for(int i = 0 ; i<arr.length-1 ; i++) { 
			for(int j = 0 ; j<arr.length-1-i ; j++) { 
				if(arr[j]<arr[j+1]) {
					int tem = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tem;
				}
			}
		}
		
		/*
		 * 이렇게 내림차순 정렬도 해 줄 수 있다!!!! '숫자가 클 때 오른쪽으로 밀어주는가?'를 응용해서 '숫자가 작을 때 오른쪽으로
		 * 밀어주는가?'로 사용한 것이다!
		 */
		 
		
		
		
	/*	for(int i = 0 ; i<arr.length-2 ; i++) {
			if(arr[i]>arr[i+1]) {
				int tem = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = tem;
			}
		}		
	*/	
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	
	
}
