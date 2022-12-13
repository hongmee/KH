package kr.java.vo;

public class Gold extends Silver{

	public Gold() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gold(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getBonus() {
		return getPoint()*0.05;
	}
	

/*	private String grade;
	private String name;
	private int point;
	
	
	public Gold() {
		
	}
	
	public Gold(String grade, String name, int point) {
		this.grade = grade;
		this.name = name;
		this.point = point;
	}
	
	//getter
	public String getGrade() {
		return grade;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
	public double getBonus() {
		return point*0.05;
	}
	
	
	//setter
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPoint(int point) {
		this.point = point;
	}
*/	
	
}//Gold 클래스 끝
