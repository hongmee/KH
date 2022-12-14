package kr.or.iei.controller;

public interface PointMgr {
	
	//메인 메뉴를 반복해서 출력
	public void main();
	
	//회원 정보를 입력하는 메소드
	public void insertMember();
	
	//회원 전체 정보 출력
	public void printAllMember();
	
	//회원 한명 검색
	public void printOneMember();
	
	//회원정보 수정
	public void updateMember();
	
	//회원정보 삭제
	public void deleteMember();
	
	
	//회원이름으로 회원 인덱스 번호 찾아주는 메소드
	public int searchMember(String searchName);
	
	
}//PointMgr 인터페이스 끝
