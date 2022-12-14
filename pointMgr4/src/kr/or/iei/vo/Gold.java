package kr.or.iei.vo;

public class Gold extends Grade {

	public Gold() {
		super();
	}

	public Gold(String grade, String name, int point) {
		super(grade, name, point);
	}

	@Override
	public double getBonus() {
		return getPoint()*0.05;
	}

	
	
}//Gold 클래스 끝
