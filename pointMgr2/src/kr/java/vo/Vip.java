package kr.java.vo;

public class Vip extends Silver{


	public Vip() {
		//super(); <--우리 눈에 보이진 않지만 이게 자동으로 들어가있다. 부모의 생성자를 호출하는 역할을 한다.
		//Vip는 Silver를 상속한 상태, Vip를 만들기 위해서는 Silver가 먼저 만들어져야 하기 때문이다.
	}
	
	public Vip(String grade, String name, int point) { 
	//	this.grade = grade; //<--부모의 private멤버는 가질순 있지만 접근이 안 됨... 
		
		super(grade,name,point); //부모 생성자 중 매개변수 있는 생성자. 데이터 오버로딩을 통해서 Silver의 생성자를 호출한것이다.
		//단!!!!!! super() 위에는 코드가 있으면 안 됨. super()가 맨 위에서 제일 먼저 동작해야함 !!!!!!!!!!
		
	/*  이런 방법으로 호출해도 됨~
	 	setGrade(grade);
		setName(name);
		setPoint(point);
	*/	
	}
	
	@Override //@<--이 표시는 시스템한테 알려주는 표시. 안 해줘도 되긴 하는데, 오버라이딩을 한 건지 새로운 메소드를 생성한건지 확실히 해주기 위해 가급적 써주자!!!
	public double getBonus() {
		return getPoint()*0.07;
	}
	
	
	
}//Vip 클래스 끝
