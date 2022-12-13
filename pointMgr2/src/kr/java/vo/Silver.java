package kr.java.vo;

public class Silver { //<--이런식으로 extends 클래스명....이 없이 == 상속하지 않았으면 자동으로 Object클래스를 상속한거임!!!!!!!!!!

	private String grade;
	private String name;
	private int point;
	
	
	
	public Silver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Silver(String grade, String name, int point) {
		super();
		this.grade = grade;
		this.name = name;
		this.point = point;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public double getBonus() {
		return point*0.02;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
	
/*	private String grade;
	private String name;
	private int point;
	
	
	public Silver() {
		
	}
	
	public Silver(String grade, String name, int point) {//매개변수로 받은걸 전역변수에 집어넣는과정
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
*/	
	
}//Silver 클래스 끝
