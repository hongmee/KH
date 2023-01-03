package kr.or.iei.member.vo;

import java.sql.Date;

public class Member {

	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberAddr;
	private String memberPhone;
	private int age;
	private String memberGender;
	private Date enrollDate;
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Member(String memberId, String memberPw, String memberName, String memberAddr, String memberPhone, int age,
			String memberGender, Date enrollDate) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAddr = memberAddr;
		this.memberPhone = memberPhone;
		this.age = age;
		this.memberGender = memberGender;
		this.enrollDate = enrollDate;
	}


	public Member(String memberId, String memberPw, String memberName, String memberAddr, String memberPhone, int age,
			String memberGender) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAddr = memberAddr;
		this.memberPhone = memberPhone;
		this.age = age;
		this.memberGender = memberGender;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberPw() {
		return memberPw;
	}


	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberAddr() {
		return memberAddr;
	}


	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}


	public String getMemberPhone() {
		return memberPhone;
	}


	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getMemberGender() {
		return memberGender;
	}


	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}


	public Date getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	
	
	
}//Member
