package kr.or.iei.start;


import kr.or.iei.func.MethodTest2;
import kr.or.iei.func.MethodTest3;
import kr.or.iei.func.MethodTest4;
import kr.or.iei.func.Mouse;
import kr.or.iei.func.Quokka;
import kr.or.iei.func.TestClass;
import kr.or.iei.func.TestClass1;
import kr.or.iei.func.TestClass2;
import kr.or.iei.func.TestInterface;
import kr.or.iei.func.TestInterfaceImpl;
import kr.or.iei.func.Tiger;
import kr.or.iei.func.Tv;
import kr.or.iei.func.Animal;
import kr.or.iei.func.Detective;
import kr.or.iei.func.MethodExam;
import kr.or.iei.func.MethodTest;

public class Start {
	
	public static void main(String[] args) {
		
		MethodTest mt = new MethodTest();
		
//		mt.test1();
		
		MethodTest2 mt2 = new MethodTest2();
		
//		mt2.main();
		
//		mt2.test1();
//		mt2.test2();
		
		MethodTest3 mt3 = new MethodTest3();
		
//		mt3.main();
		
		
		MethodTest4 mt4 = new MethodTest4();
		
//		mt4.main();
		
		MethodExam me = new MethodExam();
		
//		me.exam1(); //안녕하세요 메소드 예제 1번입니다 출력
//		me.exam2(100); // 매개변수로 받은 값은 100입니다 출력
//		me.exam2(100,200); // 매개변수 두 개의 값은 100과 200이며 두 수의 합은 300입니다 출력
//		String result = me.exam3(100,200,300); //<--값이 뿅 들어가는게 아니라 이 메소드가 실행되는거임...
//		System.out.println(result); 
		//매개변수 3개의 값은 100,200,300이며, 세 수의 합은 600입니다 출력
		
		

		
/*		//TV의 크기는 최초에 한 번 만들어지고나면 더 이상 변경될 수 없음 = [만들어 질 때] 세팅이 되어야★ 함
		Tv tv = new Tv(); //<--★바로 이 때가!! [만들어 질 때]임. 객체가 생성될 때 new+생성자(); !!!!
		tv.play();
	
	  tv.setCh(50); tv.setVol(5); System.out.println("tv의 현재 채널 : "+tv.getCh());
	 System.out.println("tv의 현재 볼륨 : "+tv.getVol());
	 System.out.println("tv의 크기 : "+tv.getInch()); Tv tv2 = new Tv(50);
	  System.out.println("tv2의 크기 : "+tv2.getInch());
*/	 
		
		TestClass tc = new TestClass();
		
//		tc.main();
		
		Detective dt = new Detective();
		
		dt.play();
		
		
/*		//다형성 : 부모타입 참조형 변수에 자식타입 객체 주소를 넣는 것.
		Animal ani = new Animal();
		Tiger t = new Tiger();
		Quokka q = new Quokka();
		
		Animal ani2 = new Tiger();//<-- 뉴 어쩌구가 객체 주소임
		Animal ani3 = new Quokka();
		//단. 자식타입 참조형 변수에 부모 타입 객체 주소를 넣는것은 불가능하다.
		//형제(여기서는 호랑이-쿼카)끼리도 다형성은 불가능하다. 부모타입에 자식을 넣는것만 가능!
		
		Mouse m = new Mouse();
		Quokka q2 = new Mouse(); //<--Mouse를 Quokka타입에 저장한 경우... 부모타입 참조형 타입이 가진 기능만 쓸 수 있다!!!!!!!!!!!!!!!!!
		Animal ani4 = q2;
		Animal ani5 = new Mouse(); //<--업캐스팅. 자료형을 내 상위 타입으로 변환했다는 뜻.
		
		//Mouse타입은 현재 (breath,smile,cute 기능이 존재)
		m.breath();
		m.smile();
		m.cute();
		
		//어..?! 근데 q2는 cute가 없다..! 
		q2.breath();
		q2.smile();
		
		//심지어 애니멀에서는 smile도 없다!
		ani4.breath();
		
		//쥐가 애니멀에 들어가는게 업캐스팅이라면, 다운캐스팅도 있다.
//		Mouse m2 = (Mouse)ani4; // 다형성이 적용된 ani4(쿼카타입)을 Mouse타입으로 형변환. 다운캐스팅
//		Tiger t3 = (Tiger)ani4; //<--이건 문법상으론 오류가 나지 않지만 캐스팅 오류 남
		
		System.out.println("---------------------------------------");
		
		Animal ani6 = new Tiger();
		ani6.breath(); //<-- 오버라이딩을 통해서 메소드를 변경한 경우, 부모타입 메소드보다 우선순위가 높아서 오버라이딩 된 메소드가 실행된다(동적바인
*/		
		
		
//		TestClass2 testClass2 = new TestClass2();
		
//		TestClass1 testClass3 = new TestClass2(); //추상클래스도 부모타입 자료형으로 사용은 가능하다.(다형성의 원리?)
		
//		TestInterface ti = new TestInterface(); // <--얘도 미완성된 메소드가 한가득이때문에 객체를 만들지못한다
//		TestInterfaceImpl tii = new TestInterfaceImpl(); // <-- 얘는 가능! 인터페이스를 구현한 클래스를 객체 생성해서 사용
//		TestInterface ti = new TestInterfaceImpl(); //인터페이스도 다형성을 이용한 부모타입변수로는 사용가능
		
		
	}//메인 메소드

}
