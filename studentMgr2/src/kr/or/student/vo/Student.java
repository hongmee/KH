package kr.or.student.vo;
//VO (Value Object)


public class Student {
	//1. 전역변수 선언
	private String name ;
	private int age;
	private String addr;
	
	//2. 생성자 생성(기본생성자, 매개변수가 있는 생성자)
	public Student() { //기본생성자
		
	}
	
	public Student(String name, int age, String addr) { //매개변수가 있는 생성자(오버로딩)
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	//3. 전역변수에 대한 getter/setter
	//getter
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddr() {
		return addr;
	}
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
	
}//student 클래스 끝
