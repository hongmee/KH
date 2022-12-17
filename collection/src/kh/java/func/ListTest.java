package kh.java.func;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ListTest {

	public void listTest() {
		String[] arr = new String[3];
		arr[0] = "hi";
		arr[1] = "hello";
		arr[2] = "안녕하세요";
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println((i+1)+": "+arr[i]);
		}
		
		//ArrayList는 배열이랑 비슷한 자료형
		//배열에 저장하고 싶은 자료형을 제네릭으로 지정
		ArrayList<String> list = new ArrayList<String>();
		System.out.println(list.size()); //리스트의 데이터 갯수를 조회
		list.add("hi"); //리스트의 마지막에 추가됨
		System.out.println(list.size()); //처음부터 길이가 정해진 배열과는 다르게 .add할 때마다 한 칸씩 생긴다는걸 보여주고 싶었음 
		list.add("hello");
		System.out.println(list.size());
		list.add("안녕하세요");
		System.out.println(list.size());
		list.add("하나더 추가");
		list.add("난나나난나");
		
		System.out.println(list.get(0)); // 0번 인덱스의 값 출력하는 코드
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
	}//listTest
	
	
	public void listTest2() {
		Scanner sc = new Scanner(System.in);
		//정수를 여러개 저장하는 리스트 만들기
		
		//리스트는 관리할 자료형을 제네릭으로 지정 => 제네릭: 기본자료형 사용 불가능 => 기본자료형을 사용하고 싶은 경우 Wrapper클래스를 활용
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true) {
			System.out.print("리스트에 저장할 정수를 입력하세요: ");
			list.add(sc.nextInt());
			System.out.print("종료하려면 1 / 추가입력하려면 2 : ");
			int sel = sc.nextInt();
			if(sel==1) {
				break;
			}
		}
		System.out.print("list에 들어있는 값 : ");
		for(int i=0 ; i<list.size() ; i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}//listTest2
	
	
	public void listTest3() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(5);
		list.add(100);
		list.add(55);
		list.add(80);
		System.out.println(list.get(2)); //get(원하는값 인덱스번호);
		System.out.println(list); // ArrayList는 .toString이 되어있어서 이렇게 하면 다 나온다
		System.out.println("현재 list의 길이는 : "+list.size());
		int testNum = list.remove(3); //리스트의 데이터를 지우려면 .remove(인덱스번호)
		System.out.println(testNum); //그러나 int testNum에 데이터가 들어가는걸 보면 알 수 있듯이, .remove()는 데이터를 삭제하고 삭제한 데이터값을 리턴해준다!
									//필요시에 잘 활용해주면 된다!!!
		System.out.println(list);
		System.out.println("현재 list의 길이는 : "+list.size());
		
		
		list.add(2, 888); // <--첫번째 매개변수 자리에 두번째 매개변수 값을 추가. 기존 데이터는 뒤로 한 칸씩 밀린다.(추가할 인덱스번호, 추가할 데이터값)
		System.out.println(list);
		
		
		//리스트의 데이터 변경
		//set(param1, param2)
		//첫 번째 매개변수 자리의 데이터를 두 번째 매개변수 값으로 변경
		int testNum2 = list.set(2, 777); //<--얘도 .remove()랑 비슷허게.. 변경 전 데이터를 리턴까지 해 준다
		System.out.println(list);
		System.out.println("사라진 데이터는 : "+testNum2);
		
		
		Collections.sort(list); //list를 정렬해준다~! 얘는 퀵정렬을 하기때문에 버블정렬보다 속도도 빠르다~!
		System.out.println(list);
		Collections.reverse(list); //list 순서 반전
		System.out.println(list);
		
		
		list.clear(); //list의 내부 데이터 전체 삭제
		System.out.println(list);

		
	}//listTest3
	
	
	public void listTest4() {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList<String>();
		while(true) {
			System.out.print("추가할 문자열을 입력하세용 : ");
			sc.nextLine();
			list.add(sc.nextLine());
			System.out.print("그만적고싶으면 0 / 더 적으려면 1 : ");
			int sel = sc.nextInt();
			if(sel==0) {
				break;
			}
		}
		//foreach문 -> collection for문
		//여러 자료를 다루는 자료형(예:배열)의 모든 데이터를 순회
		for(String str : list) { //<--반복횟수를 조절하는건 아니고 배열 전체를 순회하는거임
			System.out.print(str+", ");
		}
		
		/*
		System.out.print("저장한 list 내용 : ");
		for(int i=0 ; i<list.size() ; i++) {
			System.out.print(list.get(i)+" ");
		}
		*/
		
	}//listTest4
	
	
	
	
}//ListTest
