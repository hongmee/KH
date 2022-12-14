package kr.or.iei.func;

import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollPaneUI;

public class Detective {
	
	boolean Character = false;
	String name ;
	
	String[] clue1 = {"○ 화이트 : \"데이비드가 보물을 가졌어요\"","○ 셰이디 : \"블랙은 다이아몬드를 가지지 않았어요.\""};
	String[] clue2 = {"○ 베리 : \"저는 보물이 없습니다.\"","○ 데이비드 : \"화이트의 진술은 거짓입니다.\""};
	String[] clue3 = {"○ 블랙 : \"베리의 말이 맞습니다.\"","○ 단서로 알 수 있는건 총 5명의 진술이다. 그러나, 이 중 2명은 거짓말을 한다."};
	
	String[] specialClue = {"● 화이트는 다이아몬드를 가지지 않았습니다.","● 다이아몬드를 가진 사람 스펠링 중에는 'B'가 있습니다."};
	
	
	boolean tape1 = false;
	boolean tape2 = false;
	boolean tape3 = false;
	
	boolean plusClue1 = false;
	boolean plusClue2 = false;
	boolean plusClue3 = false;
	boolean plusSpecial = false;
	
	public void play() {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("◆ ◇ ◆ ◇ [ 명탐정 다이아몬드 ] ◇ ◆ ◇ ◆");
			System.out.println("[1] 캐릭터 생성 ");
			System.out.println("[2] 단서 ");
			System.out.println("[3] 탐색하기 ");
			System.out.println("[4] 라디오 ");
			System.out.println("[5] 정답 제출 ");
			System.out.println("[*] 미니 게임");
			System.out.println("[0] 게임 종료 ");
			System.out.print("실행 메뉴 선택 > ");
			char menu = sc.next().charAt(0);
			
			if(menu==49 || menu==48) {
				if(menu==49 && Character) {
					System.out.println("[이미 캐릭터를 생성하셨습니다.]");
					continue;
				}
				menu += 0;
			}else if(42!=menu && 48>menu || 53<menu) {
				System.out.println("지원하지 않는 메뉴입니다.");
			}else if(!Character){
				System.out.println("[!!] 캐릭터 생성 후 게임을 이용할 수 있습니다.");
				continue;
			}
			
			switch (menu) {
			case 49:
				addCharacter();
				break;
			case 50:
				clue();
				break;
			case 51:
				search();
				break;
			case 52:
				radio();
				break;
			case 53:
				boolean game = answer();
				if(game==false) {
					return;
				}
				break;
			case 42:
				miniGame();
				break;
			case 48:
				System.out.print("\n[진짜 게임 종료하기]숫자 0 입력 [메뉴로 돌아가기]그 외 다른 숫자 입력 :");
				int end = sc.nextInt();
				if(end==0) {
					System.out.println("게임을 종료합니다.");
					return;
				}else{
					continue;
				}
			}
		}//메뉴 반복 while
		
	}//play메소드 끝
	
	
	public void addCharacter() { //캐릭터 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("플레이어 이름을 입력하세요 : ");
		name = sc.nextLine();
		
		for(int i=0 ; i<3 ; i++) {
			System.out.print(". ");
			sleep(500);
		}
		Character = true;
		System.out.println("명탐정 "+name+"!");
		sleep(500);
		System.out.println("=====[게임 줄거리]=====");
		sleep(1000);
		System.out.println("명탐정 "+name+"는(은) 세계 귀족들의 크루즈 파티에 참석했다.");
		System.out.println("주최자인 데이비드는 파티를 더욱 재미있게 하기 위해 특별 이벤트를 준비했다.");
		System.out.println("파티장엔 다섯 명의 비밀 요원이 숨어있으며, 그 중 한 명은 다이아몬드를 가지고 있다.");
		System.out.println("다이아몬드를 가진 비밀 요원을 찾으면, 이벤트 경품으로 다이아몬드를 얻는다.");
		System.out.println("비밀 관계자에 대한 정보는 파티장 곳곳에 숨겨져 있다.. 비밀 관계자를 지목할 기회는 \"단 한 번\"이다. ");
		System.out.println("지금부터 명탐정인 "+name+"의 번뜩이는 추리로 누구보다 먼저 다이아몬드를 차지해보자.");
		
	}//addCharacter 메소드 끝
	
	
	public void clue() { //단서 보관(출력) 메소드
		
		if(!plusClue1 && !plusClue2 && !plusClue3 && !plusSpecial) {
			System.out.println("[ 아직 습득한 단서가 없습니다. 파티장을 탐색하여 단서를 습득하세요. ]");
		}
		
		if(plusClue1 || plusClue2 || plusClue3 || plusSpecial) {System.out.println("===== [ *획득한 단서 ] =====");}
		if(plusClue1) {
			for(int i=0 ; i<clue1.length ; i++) {
				System.out.println(clue1[i]);
			}
		}if(plusClue2) {
			for(int i=0 ; i<clue2.length ; i++) {
				System.out.println(clue2[i]);
			}
		}if(plusClue3) {
			for(int i=0 ; i<clue3.length ; i++) {
				System.out.println(clue3[i]);
			}
		}if(plusSpecial) {
			for(int i=0 ; i<specialClue.length ; i++) {
				System.out.println(specialClue[i]);
			}
		}
		
	}//clue 메소드 끝
	
	public void search() { //탐색하기 기능
		Scanner sc = new Scanner(System.in);

		if(tape1 && tape2 && tape3) {
			System.out.println("[모든 방을 탐색하였습니다.]");
			return;
		}
		
		System.out.println("세 개의 방이 보입니다.");
		System.out.println("[1] 초록 방");
		System.out.println("[2] 검정 방");
		System.out.println("[3] 황금 방");
		System.out.print("몇 번 방에 들어가시겠습니까? : ");
		int room = sc.nextInt();
		switch (room) {
		case 1:
			if(tape1) {
				System.out.println("[이미 탐색한 방입니다.]");
				return;
			}
			sleep(800);
			System.out.println("끼이익 -...");
			sleep(800);
			System.out.println("문을 열고 들어가니, 방 중앙에 세개의 상자가 놓여있다.");
			System.out.println("그리고 상자 아래 놓여진 쪽지.");
			System.out.println("==========================");
			System.out.println("A : 테이프는 이 상자에 있다.");
			System.out.println("B : 테이프는 A상자에 없다. ");
			System.out.println("C : 테이프는 이 상자에 없다.");
			System.out.println("");
			System.out.println("*상자 하나는 거짓말을 하고 있다.");
			System.out.println("*상자는 방 입장시 1번만 열 수 있습니다.");
			System.out.println("==========================");
			boolean bool=true;
			while(bool) {
				System.out.print("몇 번 상자를 여시겠습니까? : ");
				char answer = sc.next().charAt(0);
				if(answer=='A' || answer=='a') {
					sleep(500);
					System.out.println("달칵.");
					sleep(500);
					System.out.println("상자가 비어있습니다.");
					System.out.println("\"이런! 명탐정의 명예가!\"");
					System.out.println("[단서 습득에 실패했습니다. 메뉴로 돌아갑니다.]");
					bool = false;
				}else if(answer=='B' || answer=='b') {
					sleep(500);
					System.out.println("달칵.");
					sleep(500);
					System.out.println("상자 안에 테이프가 놓여있습니다.");
					System.out.println("\"하하! 난 역시 명탐정이라니까!\"");
					tape1=true;
					System.out.println("[테이프1을 습득했습니다. 메뉴로 돌아갑니다.]");
					bool = false;
				}else if(answer=='C' || answer=='c') {
					sleep(500);
					System.out.println("달칵.");
					sleep(500);
					System.out.println("상자가 비어있습니다.");
					System.out.println("\"이런! 명탐정의 명예가!\"");
					System.out.println("[단서 습득에 실패했습니다. 메뉴로 돌아갑니다.]");
					bool = false;
				}else {
					System.out.println("올바른 값을 입력하세요.");
				}
			}//상자 입력 반복 While
			break;
			
		case 2://단서획득 문제 2번
			if(tape2) {
				System.out.println("[이미 탐색한 방입니다.]");
				return;
			}
			sleep(800);
			System.out.println("끼이익 -...");
			sleep(800);
			System.out.println("방 안에는 굳게 잠긴 금고가 있다. 금고 앞에는 쪽지가 붙어있다.");
			System.out.println("LION");
			boolean bool2 = true;
			while(bool2) {
				System.out.print("금고의 비밀번호를 입력하시오(*hint:1~100)[0:메뉴로 돌아가기] : ");
				int num = sc.nextInt();
				if(num==0) {
					bool2=false;
				}else if(num==17) {
					sleep(500);
					System.out.println("달칵.");
					sleep(500);
					System.out.println("\"열렸다! LION을 거꾸로 보면 NO.17이었어!\"");
					tape2=true;
					sleep(500);
					System.out.println("[테이프2를 습득했습니다. 메뉴로 돌아갑니다.]");
					bool2=false;
				}else {
					System.out.println("[비밀번호가 틀립니다.]");
				}
			}//비밀번호 입력 반복 while
			
			break;
			
		case 3://단서획득 문제 3번
			if(tape3) {
				System.out.println("[이미 탐색한 방입니다.]");
				return;
			}
			sleep(800);
			System.out.println("끼이익 -...");
			sleep(800);
			System.out.println("투명한 케이스에 잠금패드가 붙어있다. 케이스 너머로 테이프 하나가 보인다.");
			sleep(800);
			System.out.println("====Password Hint====");
			System.out.println("MON = 3");
			System.out.println("TUE = 5");
			System.out.println("WED = 4");
			System.out.println("THU = ?");
			System.out.println("=====================");
			boolean bool3 = true;
			while(bool3) {
				System.out.print("비밀번호 한 자리를 입력하시오[0:메뉴로 돌아가기] : ");
				int num = sc.nextInt();
				if(num==0) {
					bool3=false;
				}else if(num==6) {
					sleep(500);
					System.out.println("달칵.");
					sleep(500);
					System.out.println("\"열렸다! 숫자가 의미하는 건 영단어의 최소 총 획수였어! THE는 최소 6획으로 쓸 수 있지!\"");
					tape3=true;
					sleep(500);
					System.out.println("[테이프3을 습득했습니다. 메뉴로 돌아갑니다.]");
					bool3=false;
				}else {
					System.out.println("[비밀번호가 틀립니다.]");
				}
			}//비밀번호 입력 반복 while
			
			break;

		default:
			System.out.println("존재하지 않는 방입니다. 메뉴로 돌아갑니다.");
			break;
		}
	}//search메소드
	
	
	
	public void radio() { //라디오~
		Scanner sc = new Scanner(System.in);
		
		System.out.println("라디오가 놓여져 있다. 테이프를 넣으면 작동할 것 같아 보인다.");
		if(tape1==false && tape2==false && tape3==false) {
			System.out.println("[소지한 테이프가 없습니다. 탐색을 통해 테이프를 찾아봅시다.]");
		}else if(tape1 || tape2 || tape3){
			System.out.println("[습득한 테이프]");
			if(tape1) {System.out.println("▶ 테이프 1");}
			if(tape2) {System.out.println("▶ 테이프 2");}
			if(tape3) {System.out.println("▶ 테이프 3");}
			System.out.print("몇 번 테이프를 재생하시겠습니까? : ");
			int num = sc.nextInt();
				switch (num) {
				case 1:
					if(tape1) {
						System.out.println("치직-...치직...-");
						sleep(1000);
						for(int i=0 ; i<clue1.length ; i++) {
							System.out.println(clue1[i]);
						}
						plusClue1=true;
					}else {
						System.out.println("[1번 테이프를 소지하고 있지 않습니다.]");
					}
					
					break;
				case 2:
					if(tape2) {
						System.out.println("치직-...치직...-");
						sleep(1000);
						for(int i=0 ; i<clue2.length ; i++) {
							System.out.println(clue2[i]);
						}
						plusClue2=true;
					}else {
						System.out.println("[2번 테이프를 소지하고 있지 않습니다.]");
					}
					
					break;
				case 3:
					if(tape3) {
						System.out.println("치직-...치직...-");
						sleep(1000);
						for(int i=0 ; i<clue3.length ; i++) {
							System.out.println(clue3[i]);
						}
						plusClue3=true;
					}else {
						System.out.println("[3번 테이프를 소지하고 있지 않습니다.]");
					}
				
					break;

				default: System.out.println("그런 테이프는 없습니다.");
					break;
				}
		}//테이프 재생 기능
		
	}//radio 메소드
	
	public void miniGame() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("[ M I N I G A M E ]");
		System.out.println("단서를 열심히 모아도, 도저히 추리하기 어려운 플레이어를 위한 미니게임입니다.");
		System.out.println("미니게임에서 승리하면 단서함에 특별하고 강력한 단서가 추가됩니다.");
		System.out.println("(*플레이 방법) 1~20까지의 범위 중에 컴퓨터와 동일한 숫자를 외치면 승리.");
		System.out.println("================");
		boolean bool = true;
		int userNum = 0;
		while(bool) {
			System.out.print("(player)숫자를 입력하세요 : ");
			userNum = sc.nextInt();
			if(userNum<=0 || 20<userNum) {
				System.out.println("범위 내의 숫자를 입력하세요.");
				continue;
			}
			break;
		}
		int comNum = r.nextInt(20)+1;
		System.out.println("=====[미니게임 결과]=====");
		System.out.println("(player) 선택 숫자 : "+userNum);
		System.out.println("(COM) 선택 숫자 : "+comNum);
		if(userNum == comNum) {
			System.out.println("플레이어 승리! 축하합니다!");
			System.out.println("단서함에 특별 단서가 추가되었습니다!");
			plusSpecial = true;
			
		}else {
			System.out.println("FAILD");
			System.out.println("메뉴 화면으로 돌아갑니다.");
			return;
		}
	}//miniGame메소드 끝
	
	
	
	public boolean answer() {//5. 정답 제출 기능
		Scanner sc = new Scanner(System.in);
		
		if(plusClue1==false || plusClue2==false || plusClue3==false) {
			System.out.println("[모든 단서를 찾아야 비밀 요원을 지목할 수 있습니다.]");
		}else if(tape1 && tape2 && tape3){
			sleep(1000);
			System.out.println("\"..정답을 알았어!");
			sleep(500);
			System.out.println("[1]화이트");
			sleep(500);
			System.out.println("[2]베리");
			sleep(500);
			System.out.println("[3]데이비드");
			sleep(500);
			System.out.println("[4]블랙");
			sleep(500);
			System.out.println("[5]셰이디");
			sleep(500);
			boolean bool = true;
				while(bool) {
					System.out.println("..이 중 다이아몬드를 가진 비밀요원은... \"(숫자로 지목하세요): ");
					int result = sc.nextInt();
						if(result==4) {
							System.out.println("\"블랙이야!\"");
							for(int i=0 ; i<3 ; i++) {
								System.out.print(". ");
								sleep(500);
							}
							System.out.println("축하합니다!");
							System.out.println("우와!!!!!! 다이아몬드를 가진 비밀요원은 블랙이었다!!!!!!");
							System.out.println(name+"은 추리에 멋지게 성공했다!!!!!!!!!!!!!");
							System.out.println("~~~.'*'.☆축하합니다☆.'*'.~~~~");
							return false;
						}else if(result!=4 && 0<result && result<6){
							String npcName = npcName(result);
							System.out.println("\"당신이 비밀요원이지?\"");
							for(int i=0 ; i<3 ; i++) {
								System.out.print(". ");
								sleep(500);
							}
							System.out.println("잠깐의 침묵이 흐르고, "+npcName+"이(가) 대답했다.");
							sleep(800);
							System.out.println("\"죄송합니다만. 저는 다이아몬드가 없습니다. "+name+"씨는 이제 비밀요원을 지목하실 수 없습니다.");
							sleep(500);
							System.out.println("이벤트는 끝났지만. 모쪼록 남은 파티를 즐겨 주시길...\"");
							sleep(1000);
							System.out.println("이럴 수가... 명탐정인 내가 추리에 실패하다니. 다이아몬드를 얻을 기회도 잃었다. ");
							String[] gameOver = {"G","A","M","E"," ","O","V","E","R"};	
							for(int i = 0 ; i<gameOver.length ; i++) {
								System.out.print(gameOver[i]+" ");
								sleep(500);
							}
							return false;
						}else{
							System.out.println("올바른 값을 입력하세요.");
						}
				}//정답자 입력 while문
		}//범인지목
		return true;
	}//answer메소드 종료
	
	
	
	
	
	
	public String npcName(int num) {
		switch (num) {
		case 1:
			return "화이트";
		case 2:
			return "베리";
		case 3:
			return "데이비드";
		case 5:
			return "셰이디";
		}
		return " ";
	}
	
	
	public void sleep(int time) {//시간처리
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//sleep 메소드 끝
	

}//Detective 클래스 끝
