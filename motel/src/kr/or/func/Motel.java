package kr.or.func;

import java.util.Scanner;

public class Motel {

/*	public void motel() {
		Scanner sc = new Scanner(System.in);
		
		boolean bool = true;
		int[] rooms = new int[10];
		
		while(bool) {
		System.out.println("=================");
		System.out.println("모텔관리프로그램 v1.0");
		System.out.println("[1]입실 [2]퇴실 [3]방보기\t[4]종료");
		System.out.print("메뉴 선택 > ");
		int menu = sc.nextInt();
		
		switch (menu) {
		case 1:
			System.out.print("[몇 번 방에 입실하시겠습니까?] : ");
			int num = sc.nextInt();

			if(rooms[num-1]==0) {
				rooms[num-1] = 1;
				System.out.println("입실 처리 완료 되었습니다.");
			}else{
				System.out.println("현재 "+num+"번 방에는 손님이 있습니다.");
			}
			break;
			
		case 2:
			System.out.print("[몇 번 방에서 퇴실하시겠습니까?] : ");
			int num1 = sc.nextInt();

			if(rooms[num1-1]==1) {
				rooms[num1-1] = 0;
				System.out.println("퇴실 처리 완료 되었습니다.");
			}else{
				System.out.println(num1+"번 방은 빈 방입니다. 퇴실할 수 없습니다.");
			}
			break;
			
		case 3:
			for(int i=0 ; i<rooms.length ; i++) {
				if(rooms[i]==0) {
					System.out.println((i+1)+"번방이 현재 비어있습니다");
				}else{
					System.out.println("["+(i+1)+"번 방에는 현재 손님이 있습니다.]");
				}
			}
			break;
			
		case 4:
			System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
			bool=false;
			break;

		default:
			System.out.println("지원하지 않는 메뉴입니다.");
			break;
		}
		
		}//전체 프로그램 반복 메소드
		
	}//모텔 메소드*/
	
public void boolMotel() {
	Scanner sc = new Scanner(System.in);
	boolean[] rooms = new boolean[10]; // boolean 초기값은 false입니다
	//false : 빈 방, true : 손님 있는 방
	boolean bool = true;
	
	while(bool) {
		System.out.println("===[Boolean MOTEL]===");
		System.out.println("[1]입실 [2]퇴실 [3]방보기\t[4]종료");
		System.out.print("이용할 메뉴를 선택하세요 : ");
		int menu = sc.nextInt();
		
		switch (menu) {
		case 1:
			System.out.print("[몇 번 방에 입실하시겠습니까?] : ");
			int num = sc.nextInt();
			
			if(rooms[num-1]) {
				System.out.println(num+"번 방에는 현재 손님이 있습니다.");
			}else {
				rooms[num-1] = true;
				System.out.println("[입실 처리 완료하였습니다.]");
			}
			
			break;
			
		case 2:
			System.out.print("[몇 번 방에서 퇴실하시겠습니까?] : ");
			int outNum = sc.nextInt();
			
			if(!rooms[outNum-1]) { // if()은 괄호 안이 true가 되어야 실행되는 문장이고, 우리가 다루고자 하는 값은 false임. 그걸 !로 활용해서
				System.out.println(outNum+"번 방은 빈 방입니다. 퇴실할 수 없습니다.");
			}else {
				System.out.println("[퇴실 처리 완료되었습니다.]");
				rooms[outNum-1] = false;
			}

			break;
			
		case 3:
			for(int i=0 ; i<rooms.length ; i++) {
				if(rooms[i]) { //<--어차피 if()조건문에서는 T인지 F인지로 결과 하나 퉤 뱉기 때문에 다루는게 boolean값이라면 그 점을 활용할것!!! 
			//  if(!rooms[i]) <-- 이런식으로 해주면 if(false)인거임 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!		
			//  if(rooms[i]값이 false인게 true이니?) 라는 뜻임!!!!		
					System.out.println((i+1)+"번 방에 손님이 있습니다.");
				}else {
					System.out.println((i+1)+"번 방은 빈 방입니다.");
				}
			}

			break;
			
		case 4:
			System.out.println("이용해주셔서 감사합니다");
			bool = false;
			break;

		default:
			System.out.println("지원하지 않는 메뉴입니다.");
			break;
		}//스위치 반복
		
	}//전체 프로그램 반복 while
	
	
}//boolMotel 메서드 
	


	
}
