package kh.java.vo;

public class Silver {

	private String grade;
	private String name;
	private int point;
	private double bonus;
	
	public Silver() {
		
	}
	
	public Silver(String grade, String name, int point, double bonus) {
		
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
		return point*0.02;
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
	public void setBonus(int point) {
		this.bonus = point*0.02;
	}
	
	
	
	
}//Silver 클래스 끝
