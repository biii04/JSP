package com.member.model;

import java.util.ArrayList;

public interface MemberDAO {
	//추가
	public void memberJoin(MemberDTO member);
	
	//전체보기
	public ArrayList<MemberDTO> getMember();
	
	//삭제
	public int memberDelete(String userid);
	
	//수정
	public int memberUpdate(MemberDTO member);
	
	//상세보기
	public MemberDTO findById(String userid);
	
	//회원수
	public int memberCount();
	
	//아이디중복확인
	public String memberIdCheck(String userid);
	
	//로그인
	public MemberDTO memberLoginCheck(String userid, String pwd);
	
}
