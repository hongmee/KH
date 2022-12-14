package kr.or.iei.vo;

public class Silver extends Grade{
	
	//자동생성자생성기 썼는데 생성자가 두 개 생성된 이유? ==> 부모 클래스가 생성자 두 개 가지고 있어서

	public Silver() {
		super();
	}

	public Silver(String grade, String name, int point) {
		super(grade, name, point);
	}

	@Override
	public double getBonus() {
		return getPoint()*0.02;
	}

}//Silver 클래스 끝
