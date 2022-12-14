package kr.or.iei.func;

import java.util.Scanner;

public class Tv {
	
	/* 속성 : 크기(int-inch) 전원(boolean-power) 채널(int-ch) 볼륨(int-vol)
	 * 기능 : 전원(power();) 채널(chUp(); chDown(); 현재 채널을 1 증가or감소 / chChange(); 숫자를 받아서 채널변경) 볼륨(volUp(); volDown(); 현재 볼륨을 1 증가or감소)
	 */
	
	/* 더 있으면 좋은 기능
	 * 볼륨 최소 0 / 최대 100
	 * 채널 최소 0 / 최대 999
	 * 전원이 켜진 상태에서만 기능 사용 가능 
	 * */
	

	private int inch; //TV크기
	private boolean power; //전원
	private int ch; //채널
	private int vol; //볼륨          // <--- 전역변수!! 
	
	
	//[필수] 기본생성자 생성
	public Tv() {
	 //기본생성자라고 꼭 비워들 필요는 없고 필요에 따라 소스코드를 써 준다~~~
	}
	//[필수] 매개변수가 있는 생성자(오버로딩 활용하기). 생성자 메소드의 이름은 클래스와 같아야 하기 때문에 무조건 오버로딩을 활용해 줘야 한다 !!
	public Tv(int inch, boolean power, int ch, int vol) {
		this.inch = inch;
		this.power = power;
		this.ch = ch;
		this.vol = vol;
	}
	
	public Tv(int inch) { //[선택] 인치를 받아서 해주는 생성자
		this.inch = inch;
	}
	
	
	
	
	//변수에 대한 getter 생성
	public int getVol() {
		return vol;
	}
	
	public int getCh() {
		return ch;
	}
	
	public boolean isPower() { //자료형이 boolean일때 getter를 조금 수정해줘야 한다~~ 예외사항임~~~~
		//메소드 이름을 get->is라고 바꿔주세요
		return power;
	}
	
	public int getInch() {
		return inch;
	}
	
	//변수에 대한 setter 생성
	public void setVol(int vol) {//<--setter는 되돌려 줄 값이 없다(void). 값을 받으면 그 값으로 변수를 변경해주고 끝임
		this.vol = vol; //<--전역변수와 매개변수는 변수이름이 같아도 가능하다. 구분해주고 싶을땐 전역변수쪽에 this.를 붙여준다
	}
	
	public void setCh(int ch) {
		this.ch = ch;
	}
	
	public void setPower(boolean power) {
		this.power = power;
	}


	
	
	public void play() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("========[ TV 리모콘 ]========");
			System.out.println("[1] 전원");
			System.out.println("[2] 채널 ↑");
			System.out.println("[3] 채널 ↓");
			System.out.println("[4] 채널변경");
			System.out.println("[5] vol ↑");
			System.out.println("[6] vol ↓");
			System.out.println("[0] 프로그램 종료");
			System.out.print("선택 > ");
			int menu = sc.nextInt();
			
			if(menu == 1){
				menu += 0;
			}else if(!power) {
				menu += 0;
				System.out.println("TV 전원이 꺼져 있습니다.");
				continue;
			}
			
			/*
			if(2<=menu && menu<=6){
				if(power = false) {
					System.out.println("전원을 켜고 사용하세요.");
					continue;
				}
			}
			*/	
			
			switch (menu) {
			case 1:
				power(); //전원 기능을 수행하는 메소드 호출
				break;
			case 2:
				chUp();
				break;
			case 3:
				chDown();
				break;
			case 4:
				System.out.print("[채널 입력]> ");
				int changeCh = sc.nextInt();
				chChange(changeCh); //<--메소드를 호출하면서 입력받은 채널값을 매개변수로 전달.
				break;
			case 5:
				volUp();
				break;
			case 6:
				volDown();
				break;
			case 0:
				System.out.println("[ 리모콘 프로그램을 종료합니다. ]");
				return; //<--메소드를 바로 종료시켜버림. 반환값은 void기 때문에 딱히 리턴값은 없다. public void play();에 종속되는 return입니다. 
			default:
				System.out.println("지원하지 않는 메뉴입니다.");
				//원래 이 자리에 break;넣는게 형식이지만 마지막자리니까 break 안 넣어도 됨
			}//menu 선택 후 switch
		}//TV리모콘 While문
		
	}//실행클래스에서 실행해줄 Play
	
	
	public void power() {//현재 전원상태를 반전 (T↔F)
		power = !power;
		if(power) {
			System.out.println("전원이 켜졌습니다");
		}else {
			System.out.println("전원이 꺼졌습니다");
		}
		
		
	/*		if(power) {
			System.out.println("전원이 꺼졌습니다.");
			power = false; 
		}else {
			power = true;
			System.out.println("전원이 켜졌습니다.");
		}
	*/	
			
	}//power
	
	public void chUp() {//현재 채널을 +1
		if(ch != 999) {
			ch++;
		}else {
			ch = 0;
		}
		
		System.out.println("** 현재 채널 : "+ch);
	}//chUp
	
	public void chDown() {//현재 채널을 -1
		if(ch != 0) {
			ch--;
		}else {
			ch = 999;
		}
		System.out.println("** 현재 채널 : "+ch);
	}//chDown
	
	public void chChange(int changeCh) {//숫자를 받아서 받은숫자로 채널 변경
		if( 0<=changeCh && changeCh<=999) {
			ch = changeCh;
			System.out.println("** 현재 채널 : "+ch);
		}else {
			System.out.println("** 채널 "+changeCh+"은 존재하지 않습니다.");
		}
		
	}//chChange
	
	public void volUp() {//현재 볼륨을 +1
		if(vol != 10) {
			vol++;
			System.out.println("볼륨 "+vol);
		}else {
			System.out.println("** 현재 최대 볼륨(10) 입니다. 더 이상 올릴 수 없습니다.");
		}
	}//volUp
	
	public void volDown() {//현재 볼륨을 -1, 최소값은 0
		if(vol != 0) { //<--0이 아닐때는 1을 빼주는데, 0일때는 빼주지 마라 
			vol--;
			System.out.println("볼륨 "+vol);
		}else {
			System.out.println("** 현재 최소 볼륨(0) 입니다. 더 이상 내릴 수 없습니다.");
		}
	}//volDown
	
	
	
	
	
	
	
	
}//Tv
