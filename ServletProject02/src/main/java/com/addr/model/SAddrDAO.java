package com.addr.model;

import java.util.ArrayList;

public interface SAddrDAO {
	
	//추가
	public void addrInsert(AddrDTO addr);
	
	//전체보기(검색 x)
	public ArrayList<AddrDTO> addrList();
	
	//상세보기
	public AddrDTO addrDetail(int num);
	
	//수정
	public void addrUpdate(AddrDTO addr);
	
	//삭제
	public void addrDelete(int num);
	
	//검색
	public ArrayList<AddrDTO> addrSearchList(String field, String word);
	
	//개수(검색 x)
	public int addrCount();
	
	//개수(검색 o)
	public int addrSearchCount(String field, String word);
	
	//우편번호검색
	public ArrayList<ZipDTO> addrZipRead(String dong); 
	
}
