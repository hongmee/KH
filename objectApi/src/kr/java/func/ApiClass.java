package kr.java.func;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ApiClass {

	public void Math() {
		//Math클래스 : 수학에서 자주 사용하는 상수들과 메소드들을 구현해 놓은 클래스
		//Math클래스는 기본적으로 항상 만들어져 있는 상태. => 객체 생성 없이 바로 사용 가능
		//Math.메소드(); <--이렇게 바로 사용해준다. Math클래스의 메소드는 모두 static method기 때문에 가능하다~!
		
		//절대값 : 부호 무시
		System.out.println(Math.abs(10));
		System.out.println(Math.abs(-10));
		
		//올림, 버림, 반올림
		System.out.println(Math.ceil(10.1)); //11
		System.out.println(Math.floor(10.9)); //10
		System.out.println(Math.round(10.5)); //11
		System.out.println(Math.round(10.4)); //10
		//예시 > 1.3456을 1.35로 바꾸고 싶음... => 134.56으로 변환 => 135로 바꾸기 => 100.0으로 나누기... 머임? 개귀찮음?
		double num = 1.3456;
		System.out.println(Math.round((num*100))/100.0); //<--.round메소드는 소숫점을 없애주는 애라서... 리턴값이 정수이기 때문에.! 
		
		//랜덤한 숫자 뽑아내기(0.0~1.0사이의 실수가 랜덤으로 나옴)
		System.out.println((int)Math.floor(Math.random()*100));
		
		//숫자를 비교해주는 메소드
		System.out.println(Math.max(10, 20));
		System.out.println(Math.min(651, 653));
		
	}//Math메소드 끝
	
	
	public void date() {
		//날짜 관련 API (java.util)
		Date today = new Date();
		System.out.println(today); //Date자체에서 보기좋게 처리해줄 수 없고 형태가 고정됨, 형태 예쁘게 해주는 클래스가 또 따로 있다--> SimpleDateFormat
	
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일 / HH시 mm분 ss초"); //<--생성자에 패턴을 넣어줍니다
		System.out.println(format1.format(today));
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd ♥ hh:mm:ss EEE요일");
		System.out.println(format2.format(today));
		
		//date는 날짜를 "출력"해주는 거고, 날짜를 "계산"해야 할 때는 calendar를 써줘야 한다
	}//date메소드 끝
	
	
	public void calendar() {
		//날짜 계산 APi !
		Calendar today = Calendar.getInstance(); //<-- Calendar객체 생성 완. 
		//날짜 관련 값(년도,월,일,요일,시간,분,초 등등...)을 얻어올 수 있음

		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(Calendar.MONTH)+1); // 0~11로 月계산을 함....
		System.out.println(today.get(Calendar.DATE));
		System.out.println(today.get(Calendar.HOUR)+"시"); //<-오전 오후 구분이 안됨
		System.out.println(today.get(Calendar.AM_PM)==0?"오전":"오후"); // AM일땐 0이 나오고, PM일땐 1이 나온다
		System.out.println(today.get(Calendar.MINUTE)+"분");
		System.out.println(today.get(Calendar.SECOND)+"초");
		System.out.println(today.get(Calendar.DAY_OF_WEEK)); // (1: 일요일 ~ 7:토요일)
		
		System.out.println("=======================");
		
		Calendar day1 = Calendar.getInstance(); //컴퓨터는 밀리초 단위로 계산하기 때문에 1/1000초 정도는 차이가 날 수 있다~
		System.out.println(day1.get(Calendar.DATE));
		day1.set(Calendar.DATE, 16); //DAY1의 날짜를 16일로 변경
		System.out.println(day1.get(Calendar.DATE));
		System.out.println(day1.get(Calendar.DAY_OF_WEEK)); //두 줄 위에서 set으로 날짜를 16일로 바꿔줬기 때문에, 요일까지 6으로 바꿈!!
		
		day1.set(Calendar.YEAR, 2023);
		day1.set(Calendar.MONTH, 0);
		day1.set(Calendar.DATE, 10);
		System.out.println(day1.get(Calendar.YEAR)+"년 "+(day1.get(Calendar.MONTH)+1)+"월 "+day1.get(Calendar.DATE)+"일 "+day1.get(Calendar.DAY_OF_WEEK));
		
		System.out.println("=======================");
		//컴퓨터 시간계산방법
		Calendar day3 = Calendar.getInstance();
		Calendar day4 = Calendar.getInstance();
		
		day4.set(Calendar.DATE, 16); 
		
		long time1 = day3.getTimeInMillis(); //[1970년 1월 1일]부터 day3의 시간까지 몇 ms가 흘렀는지 그때그때 계산함
		long time2 = day4.getTimeInMillis(); //[1970년 1월 1일]부터 day4의 시간까지 몇 ms가 흘렀는지 그때그때 계산함
		System.out.println("time1 : "+time1);
		System.out.println("time2 : "+time2);
		System.out.println("time2 - time1 : "+(time2-time1)); //하루는 86400초!! ms는 1000분의 1초니까 *1000해주면 86400000초!!!가 빠진것이다.
		
		
	}//calendar메소드 끝
	
	public void test2() {
		
		Calendar day1 = Calendar.getInstance();
		Calendar day2 = Calendar.getInstance();
		
		day2.set(Calendar.DATE, 25); //day2를 2022-12-25일로 변경(요일도 자동으로 변경)
		
		
		//출력을 위해서 SimpleDateFormat을 쓰고싶은 상황....SimpleDateForat은 Date타입의 객체가 필요.
		//형변환 하면 되지않나? 싶어도 Calendar랑 Date는 상속관계가 아니라서 그렇게 해줄 수가 없다. 그렇다면...
		
		long day1Time = day1.getTimeInMillis();
		long day2Time = day2.getTimeInMillis();
		
		
		//Date의 생성자 중에 매개변수 있는 생성자(long)를 사용하면 해당하는 날짜 정보의 Date타입 객체를 생성할 수 있음. 
		Date date1 = new Date(day1Time);
		Date date2 = new Date(day2Time);
		
		System.out.println(date1);
		System.out.println(date2);
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일 ☆ hh:mm:ss EEE요일");
		System.out.println(format1.format(date1));
		System.out.println(format1.format(date2));
		
	}//test2메소드 끝
	
	
	public void dDayExam() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===== D-DAY 계산기 =====");
		System.out.print("D-DAY [년도] 입력 : ");
		int year = sc.nextInt();
		System.out.print("D-DAY [월] 입력 : ");
		int month = sc.nextInt()-1;
		System.out.print("D-DAY [일] 입력 : ");
		int day = sc.nextInt();
		
		Calendar cToday = Calendar.getInstance();
		long todayMs = cToday.getTimeInMillis();
		
		cToday.set(Calendar.YEAR, year);
		cToday.set(Calendar.MONTH, month);
		cToday.set(Calendar.DATE, day);
		long dDayMs = cToday.getTimeInMillis();
		
		
		long result = (todayMs-dDayMs)/86400000;
		
/*		long dDayMs = userInputDay.getTimeInMillis()/1000;
		long todayMs = cToday.getTimeInMillis()/1000;
		
		
		long result = (todayMs-dDayMs)/86400;
*/		
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일 EEE요일");
		
		Date dDay = new Date(dDayMs);
		Date today = new Date();
		
		System.out.println("오늘 날짜 : "+format1.format(today));
		System.out.println("D-DAY 날짜 : "+format1.format(dDay));
		if(result==0) {
			System.out.println("D-DAY입니다.");
		}else if(result<0){
			System.out.println(Math.abs(result)+"일 남았습니다.");
		}else {
			System.out.println(Math.abs(result)+"일 지났습니다.");
		}
		
	}//ddayExam메소드 끝
	
	
	public void reviewDDay() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===== 디데이 계산기 (review) =====");
		System.out.print("D-DAY 년도 입력 : ");
		int year = sc.nextInt();
		System.out.print("D-DAY 월 입력 : ");
		int month = sc.nextInt();
		System.out.print("D-DAY 일 입력 : ");
		int day = sc.nextInt();
		
		Calendar today = Calendar.getInstance();
		long todayMs = today.getTimeInMillis();
		
		today.set(Calendar.YEAR, year);
		today.set(Calendar.MONTH, month-1);
		today.set(Calendar.DATE, day);
		long dDayMs = today.getTimeInMillis();
		
		Date todayDate = new Date(todayMs);
		Date dDayDate = new Date(dDayMs);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");

		System.out.println("오늘 날짜 : "+sdf.format(todayDate));
		System.out.println("D-DAY날짜 : "+sdf.format(dDayDate));
		
		long time = dDayMs - todayMs ; 
		int dayTime = (int)(time/(24*60*60*1000));
		
		if(dDayMs > todayMs) {
			System.out.println(dayTime+"일 남았습니다");
		}else if(dDayMs < todayMs) {
			System.out.println(Math.abs(dayTime)+"일 지났습니다");
		}else {
			System.out.println("디데이입니다!");
		}
		
	}//reviewDDay메소드 끝
	
	public void wrap() {
		
		int num = 10; 
		System.out.println(num);
		
		// wrapper 클래스를 이용한 방법!! java.lang은 import 안 해도 쓸수있음!!!
		Integer num1 = new Integer(10); //<--전문용어로 boxing이라고 한다.. 원랜 걍 숫잔데 객체 안에 포장해놓은거니까. (기본형 데이터를 객체화하는거)
		System.out.println(num1.intValue()); //<--box를 풀어서 쓰는거니까 unboxing이라고 함 (객체화 된 데이터를 기본형 데이터로 변환하는것)
		
		double pi = 3.14;
		System.out.println(pi);
		Double pi2 = new Double(3.14); //boxing
		System.out.println(pi2.doubleValue()); //unboxing
		
		
		//자바는 auto-boxing , auto-unboxing 이라는걸 지원한다
		Integer num2 = 10; // auto-boxing .!! 위에처럼 일일이 안해줘도 되긴 함. 편의를 위해서 자바가 만들어둔 기능
		System.out.println(num2); //auto-unboxing
		
		//뭐.. 길이제한 없이 배열을 쓰고싶다거나..?
		//아무튼 중요한 개념
		
		//String --> 기본자료형으로 변경
		String str1 = "123";
		System.out.println(str1+1); // 1231
		
		int no = Integer.parseInt(str1); // 매개변수로 받은 문자열을 정수형태(int)타입으로 변환
		System.out.println(no+1); // 124
		
		String str2 = "123.123";
		double no2 = Double.parseDouble(str2); //<--Double Wrapper 클래스를 이용해서 더블타입으로 변환해준겁니다! 리턴자체가 double로 나오는 메소드(?내생각)라서 아무튼 unboxing상태임
		System.out.println(no2);
		
		String str3 = "a"; //...를 char로 해주고싶은데! char는 parseChar같은게 없음! 걍 charAt(0) 쓰면 됨~
		char ch = str3.charAt(0);
		
		//기본자료형으로 바꿀수 없는 것들 (예:"123a")을 바꿔주려고 하면 에러가 납니다
//		String str4 = "123a";
//		int no3 = Integer.parseInt(str4);
//		System.out.println(no3);
		
		
		
		// 기본자료형 -> String으로 변환
		double dNo1 = 1.223;
		String str11 = Double.valueOf(dNo1).toString(); // 방법(1) Double Wrapper 클래스가 갖고 있는... Object가 가진 toString을....
		String str111 = String.valueOf(dNo1); // 방법(2)
		
		int iNo1 = 100;
		String str22 = Integer.valueOf(iNo1).toString();
		String str222 = String.valueOf(iNo1); //String Wrapper 클래스에는 이미 .valueOf라는 메소드가 다른 자료형버전으로 다 오버로딩 되어있기 때문에 강사님은 이쪽을 추천함~
		
		String str333 = iNo1 + ""; //방법(3)
		
		System.out.println(str111+","+str222+","+str333);
		
		
	}//wrap메소드 끝
	
	
	
	
}//ApiClass
