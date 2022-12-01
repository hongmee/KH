package kr.java.func;

import java.util.Scanner;

public class IfTest {
	
	public void test1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 10을 입력해보세요 : ");
		int num = sc.nextInt();
		System.out.println("입력한 숫자 : "+num);
		
		if(num==10) {
			System.out.println("잘했어용~^^");
		}
		System.out.println("끝!!");
	}
	
	
	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=========숫자 구별 프로그램=========");
		System.out.print("임의의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		
	/*	if(num>0) {
			System.out.printf("당신이 입력한 수 %d은(는) 양수입니다.",num);
		}
		if(num==0) {
			System.out.printf("당신이 입력한 수 %d은(는) 0입니다.",num);
		}
		if(num<0) {
			System.out.printf("당신이 입력한 수 %d은(는) 음수입니다.",num);
		}
	*/
		
		System.out.print("당신이 입력한 수 "+num+"은(는) ");
		
		if(num>0) {
			System.out.print("양수입니다.");
		}
		if(num==0) {
			System.out.print("0입니다.");
		}
		if(num<0) {
			System.out.print("음수입니다.");
		}
	}

	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n=====숫자 비교 프로그램======");
		
		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		
		if(num1<num2) {
			System.out.printf("%d<%d\n",num1,num2);
			System.out.println("두 번째 정수가 더 큽니다.");
		}
		if(num1==num2) {
			System.out.printf("%d=%d\n",num1,num2);
			// System.out.println(num1=num2); 만약 이런식으로 썼으면 num2값을 num1변수에 집어넣는다는 뜻이 됨
			// ↑ 이렇게도 나중에 한번 돌려보고 분석해보셈
			System.out.println("두 수가 같습니다.");
		}
		if(num1>num2) {
			System.out.printf("%d>%d\n",num1,num2);
			System.out.println("첫 번째 정수가 더 큽니다.");
		}
		
	}
	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=======[계산기 프로그램]=======");
		
		System.out.print("연산자를 입력하세요(+,-,*,/) : ");
		char oper = sc.next().charAt(0); 
		//next()는 띄어쓰기를 인식안함, nextLine()은 띄어쓰기까지 가능. 문자열로 받은 다음에 한 글자로 추출하는 코드임.
		System.out.print("첫 번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		
		
		//★문자(char)타입의 데이터는 연산할때 아스키코드표로 연산돼서 int자료형으로 연산된다.
		//그래서 아스키코드표에서 +,-,*,/를 참고해서 if(oper==43){} 이런식으로 해도 되긴 함 원리적으로는 그럼(근데 불편함)
		if(oper=='+') {
			System.out.println(num1+"+"+num2+"="+(num1+num2));
		//만약 System.out.println(num1+oper+num2+....)이런 식으로 입력했다면
		//int자료형+char자료형+int자료형으로 연산되기 때문에 char자료형이 또 int형으로 바뀜
			//그래서!!!!!!!!!!!!!!
		//System.out.println(num1+""+oper+""+num2+"="+(num1+num2));	
			//이런 식으로 해도 되긴함!!!!
		//☆☆☆또다른 방법(2) : System.out.printf("%d%c%d=%d",num1,oper,num2,num1+num2); 	
		}
		if(oper=='-') {
			System.out.println(num1+"-"+num2+"="+(num1-num2));
		}
		if(oper=='*') {
			System.out.println(num1+"*"+num2+"="+(num1*num2));
		}
		if(oper=='/') {
		/*	double num3 = num1/(num2-0.0);
			System.out.printf("%d/%d=%.6f",num1,num2,num3); */
		//☆☆☆또다른 방법(2) : System.out.printf("%d%c%d=%.6f",num1,oper,num2,(double)num1/num2); 	
			System.out.printf("%d%c%d=%.6f",num1,oper,num2,(double)num1/num2);
		}
		
	}
	
	
	public void bonus() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\n[참조형 String문자열을 비교하는 연습입니다]=======");
		
		// 참조형 String은 메모리에 값을 바로 저장하는게 아니라 값의 주소를 저장하는 것이므로 ==로 비교하면...
		// 우리 눈으로 보기엔 문자열 값이 똑같아도 컴퓨터는 값의주소1==값의주소2로 연산하고 있다.
		// 그래서 냅다 ==를 이용하면 안 되고, .equals()를 이용해서 해줘야 한다 (해당 데이터를 비교한다는 뜻)
		
		System.out.print("연산자를 입력하세요(+,-,*,/) : ");
		String oper = sc.next();
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		if(oper.equals("+")) {
			System.out.println("더하기 연산 결과가 나와야함");
		}
		
		if("+".equals(oper)) {
			System.out.println(num1+oper+num2+"="+(num1+num2));
		}
		
		if("/".equals(oper)) {
			System.out.printf("%d%s%d=%.6f",num1,oper,num2,(double)num1/num2);
		}
		
		System.out.println("\n끝~~~");
	}
	
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num%2==0) { 
			System.out.println("짝수!");
		}else{
			System.out.println("홀수!");
		}
		
		//if~else 경우의수가 2개일때 써줍니다
		//if를 두 번 쓴다면, 각각 독립적으로 실행되는 거
	}

	
	public void test3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num>1000) {
			System.out.println("1000보다 큰 수입니다.");
		}else if(num>100) {
			System.out.println("100보다 큰 수입니다.");
		}else if(num>10) {
			System.out.println("10보다 큰 수입니다.");
		}else {
			System.out.println("10이하입니다.");
		}
		
		//if~else if : true가 나오면 그 아래 else if는 검사하지 않고 최초 true에서 마침.
		//만약 if를 독립적으로 사용해 준다면, if가 true인건 다 동작해줌
		//즉 !!!!!! if~else if를 사용해서 조건검사를 한다면 "조건범위가 좁은"걸 맨 위로 올려줘야 함 !!!!
		
	}
	
	
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("======[놀이공원 프로그램]======");
		
		int adultPay = 20000;
		int childPay = 1000;
		
		System.out.print("입장하실 인원은 총 몇명입니까? : ");
		int total = sc.nextInt();
		System.out.print("어른은 몇명입니까?(1인당 "+adultPay+"원) : ");
		int adult = sc.nextInt();
		System.out.print("아이는 몇명입니까?(1인당 "+childPay+"원) : ");
		int child = sc.nextInt();
		
		if(adult+child==total) {
			System.out.println("지불하실 금액은 총 "+((adult*adultPay)+(child*childPay))+"원 입니다.");
		}else {
			System.out.println("인원수가 맞지 않습니다.");
		}
		
	/* 	System.out.print("입장하실 인원은 총 몇명입니까? : ");
		int total = sc.nextInt();
		System.out.print("어른은 몇명입니까?(1인당 15,000원) : ");
		int adult = sc.nextInt();
		System.out.print("아이는 몇명입니까?(1인당 5,000원) : ");
		int child = sc.nextInt();
		
		if(adult+child==total) {
			System.out.println("지불하실 금액은 총 "+((adult*15000)+(child*5000))+"원 입니다.");
		}else {
			System.out.println("인원수가 맞지 않습니다.");
		}
	*/	
		//문제는 풀겠지만, 실무에서 코드의 변동성을 위해서는 변수를 따로 만들어주는게 좋다
		
	}
	
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=====[대/소문자 변환 프로그램]=====");
		System.out.print("영문자를 입력하세요 : ");
		char spell = sc.next().charAt(0);
		
		System.out.println("\n=====[결과]======");
		
		//대문자 범위 65~90
		//소문자 범위 97~122
		if(65<=spell && spell<=90) {
			System.out.println("대문자를 입력하셨습니다.");
			char change = (char)(spell+32);
			System.out.printf("소문자로 변환 : %c",change);
		}else if(97<=spell && spell<=122) {
			System.out.println("소문자를 입력하셨습니다.");
			System.out.println("대문자로 변환 : "+(char)(spell^32));
		}else {
			System.out.println("시키는대로 하세요!!!");
		}
	}
	
	
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n===[문제 3번 : 배수 프로그램]===");
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		System.out.println("===[결과]===");
	/*	if(num==0) {
			System.out.println("["+num+"]"+"은 어떤 수의 배수도 아닙니다.");
		}else if(num%12==0) {
			System.out.println("["+num+"]"+"은 3과 4의 공배수입니다.");
		}else if(num%4==0) {
			System.out.println("["+num+"]"+"은 4의 배수입니다.");
		}else if(num%3==0) {
			System.out.println("["+num+"]"+"은 3의 배수입니다.");
		}else if(num%3!=0 && num%4!=0) {
			System.out.println("["+num+"]"+"은 3의 배수도 4의 배수도 아닙니다.");
		}
		 */
		
		if(num==0) { // ♡ 0을 아예 따로 if만들어서 처리해주는게 좋습니다 ♡
			System.out.println("["+num+"]"+"은 어떤 수의 배수도 아닙니다.");
		}else{
			if(num%12==0) {
			System.out.println("["+num+"]"+"은 3과 4의 공배수입니다.");
			}else if(num%4==0) {
			System.out.println("["+num+"]"+"은 4의 배수입니다.");
			}else if(num%3==0) {
			System.out.println("["+num+"]"+"은 3의 배수입니다.");
			}else{
			System.out.println("["+num+"]"+"은 3의 배수도 4의 배수도 아닙니다.");
			}
		}
		
	}
	
	
	public void ghdal() {
	Scanner sc = new Scanner(System.in);
		
		System.out.println("\n=====공부용 숫자 비교 프로그램======");
		
		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		
		if(num1<num2) {
			System.out.printf("%d<%d\n",num1,num2);
			System.out.println("두 번째 정수가 더 큽니다.");
		}
		if(num1==num2) {
			System.out.println(num1=num2);
		
			System.out.println("두 수가 같습니다.");
		}
	}
	
	
}
