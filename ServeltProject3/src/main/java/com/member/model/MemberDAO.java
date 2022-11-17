package com.member.model;

import java.util.ArrayList;

public interface MemberDAO {
	//�߰�
	public void memberJoin(MemberDTO member);
	
	//��ü����
	public ArrayList<MemberDTO> getMember();
	
	//����
	public int memberDelete(String userid);
	
	//����
	public int memberUpdate(MemberDTO member);
	
	//�󼼺���
	public MemberDTO findById(String userid);
	
	//ȸ����
	public int memberCount();
	
	//���̵��ߺ�Ȯ��
	public String memberIdCheck(String userid);
	
	//�α���
	public MemberDTO memberLoginCheck(String userid, String pwd);
	
}
