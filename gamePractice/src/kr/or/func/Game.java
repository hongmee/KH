package kr.or.func;

import java.util.Random;
import java.util.Scanner;

public class Game {
	
	
	public void upAndDown() {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		boolean bool = true;
		
		int rank = 0;
		
		while(bool) {
			int count = 0;
			System.out.println("=====[Up & Down Game]=====");
			System.out.println("[1] Game Start");
			System.out.println("[2] Game Score");
			System.out.println("[3] End Game");
			System.out.print("실행 메뉴 선택 > ");
			int menu = sc.nextInt();
		
			int correct = r.nextInt(99);
			
			switch (menu) {
			case 1:
				while(true) {
					count++;
					System.out.printf("%d회차 번호 입력 : ",count);
					int userNum = sc.nextInt();
				
					if(userNum == correct) {
						System.out.println("정답입니다!!");
						if(rank == 0 || count < rank) { //한 번도 게임을 안했거나, 최고기록이 됐으면 
							rank = count;
						}
						break;
					}else if(userNum < correct) {
						System.out.println("<< UP >>");
						continue;
					}else if(userNum > correct) {
						System.out.println("<< DOWN >>");
						continue;
					}
				}
				break;
				
			case 2:
				System.out.printf("현재 최고 기록은 %d회 입니다\n",rank);
				break;
				
			case 3:
				System.out.println("게임을 종료합니다. 안녕히가세요~");
				bool = false;
				break;
			default:
				System.out.println("올바르지 않은 입력입니다.");
				break;
			}//switch문 닫는괄호
		}//전체게임 닫는괄호
	}//메소드 괄호
	
	
	public void baskin() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int win = 0;
		int lose = 0;
		boolean bool = true;
		
		while(bool) {
		System.out.println("===== [Baskin Robbins31 Game] =====");
		System.out.println("[1] Game Start");
		System.out.println("[2] Gmae Score");
		System.out.println("[3] End Game");
		System.out.print("실행 번호 입력 > ");
		int menu = sc.nextInt();
		
		switch (menu) {
		case 1:
			
			int num=0;
			boolean bool2=true;
			
			
			System.out.println("<<게 임 시 작>>");
			while(bool2) {
				System.out.println("<< your turn >>");
				System.out.print("1~3사이의 숫자를 입력하세요 : ");
				int userNum = sc.nextInt();
				if(userNum<1 || 3 < userNum) {
					System.out.println("유효하지 않은 요청입니다");
					continue;
				}
				for(int i=0;i<userNum;i++) {
					num++;
					System.out.println(num+"!");
					if(num>=30) {
						System.out.println("축하합니다 이겼습니다");
						win++;
						break;
					}
				}
				if(num>=30) {
					System.out.println("게임을 종료합니다"); 
					break;
					}
				
				System.out.println("<< computer turn >>");
				int comNum = r.nextInt(3)+1	;		
				for(int i=0;i<comNum;i++) {
					num++;
					System.out.println(num+"...");
					if(num>=30) {
						System.out.println("당신은 졌습니다");
						lose++;
						break;
					}
				}
				if(num>=30) {
					System.out.println("게임을 종료합니다"); 
					break;
					}
			}//-메뉴 1번 게임 반복 while 괄호
		
			break;
			
			/*
			 * int nowNum = 0; boolean bool2 = true;
			 * 
			 * while(bool2){
			 * 
			 * System.out.println("1 ~ 3까지의 번호를 입력하세요"); System.out.print("당신 : "); int user
			 * = sc.nextInt();
			 * 
			 * if(user==1) { System.out.println("<< Your Turn >>"); if(nowNum>=30) {
			 * System.out.println("당신이 이겼습니다 ~!!!"); System.out.println("게임을 종료합니다"); break;
			 * } nowNum++; System.out.println("당신 : "+nowNum+" !!");
			 * 
			 * System.out.println("<< Computer Turn >>"); if(nowNum<31) { int com =
			 * r.nextInt(3)+1; // 1 2 3 for(int i=nowNum; i<(nowNum+com) ; i++){
			 * System.out.println((i+1)+"..."); } nowNum=(nowNum+com); if(nowNum>=30) {
			 * System.out.println("당신은 졌습니다. ㅠㅠ"); System.out.println("게임을 종료합니다"); break; }
			 * }
			 * 
			 * }else if(user==2){ System.out.println("<< Your Turn >>"); if(nowNum<31) {
			 * for(int i=nowNum; i<(nowNum+2) ; i++) {
			 * System.out.println("당신 : "+(i+1)+" !!"); } nowNum +=1; if(nowNum>=30) {
			 * System.out.println("당신이 이겼습니다 ~!!!"); break; } }
			 * 
			 * System.out.println("<< Computer Turn >>"); if(nowNum<31) { int com =
			 * r.nextInt(3)+1; // 1 2 3 for(int i=nowNum; i<(nowNum+com) ; i++){
			 * System.out.println((i+1)+"..."); } nowNum=(nowNum+com); if(nowNum>=30) {
			 * System.out.println("당신은 졌습니다. ㅠㅠ"); break; } } }else if(user==3){
			 * System.out.println("<< Your Turn >>"); for(int i=nowNum; i<(nowNum+3) ; i++)
			 * { System.out.println("당신 : "+i+" !!"); } nowNum+=2; if(nowNum>=30) {
			 * System.out.println("당신이 이겼습니다 ~!!!"); break; }
			 * 
			 * System.out.println("<< Computer Turn >>");
			 * 
			 * int com = r.nextInt(3)+1; // 1 2 3 for(int i=nowNum; i<(nowNum+com) ; i++){
			 * System.out.println((i+1)+"..."); } nowNum=(nowNum+com); if(nowNum>=30) {
			 * System.out.println("당신은 졌습니다. ㅠㅠ"); break; } }else {
			 * System.out.println("1~3사이의 값을 입력해주세요"); continue; } }//[1]번 메뉴의 게임을 무한반복
			 * break;
			 */
			
			
			 case 2:
				 System.out.println("<<스코어 확인>>");
				 System.out.println("win : "+win);
				 System.out.println("lose :"+lose);
			 break;
			 
			 case 3:
				 System.out.println("게임을 종료합니다. 감사합니다.");
				 bool = false;
			 break;
			 
			 default: System.out.println("유효하지 않은 요청입니다."); break;
			
		}//전체 스위치 메뉴 괄호
		
	}//전체 프로그램을 무한반복
		
		
}//업다운 메소드 괄호
	
	

}
