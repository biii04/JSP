package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConnection;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {
		return instance;
	}

	//추가
	@Override
	public void memberJoin(MemberDTO member) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBConnection.getConnection();
			String sql = "insert into memberdb values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getUserid());
			ps.setString(3, member.getPwd());
			ps.setString(4, member.getEmail());
			ps.setString(5, member.getPhone());
			ps.setInt(6, member.getAdmin());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, ps, null);
		}
		
	}

	//전체보기
	@Override
	public ArrayList<MemberDTO> getMember() {
		// TODO Auto-generated method stub
		return null;
	}

	//삭제
	@Override
	public int memberDelete(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	//수정
	@Override
	public int memberUpdate(MemberDTO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	//상세보기
	@Override
	public MemberDTO findById(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	//회원수
	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	//아이디중복확인
	@Override
	public String memberIdCheck(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	//로그인
	@Override
	public MemberDTO memberLoginCheck(String userid, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		MemberDTO member = new MemberDTO();
		//비회원 :-1
		member.setAdmin(-1);
		//회원 : 일반회원(0), 관리자(1) 
		//회원이지만 비번오류 : 2
		try {
			con = DBConnection.getConnection();
			String sql = "select * from memberdb where userid = '"+userid+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) { //id맞음(회원은 맞음)
				if(rs.getString("pwd").equals(pwd)) {//비번맞음
					member.setAdmin(rs.getInt("admin"));
					member.setEmail(rs.getString("email"));
					member.setName(rs.getString("name"));
					member.setPhone(rs.getString("phone"));
					member.setPwd(rs.getString("pwd"));
					member.setUserid(rs.getString("userid"));
				}else {  //비번 틀림
					member.setAdmin(2);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	
	private void closeConnection(Connection con, PreparedStatement ps,
			Statement st, ResultSet rs) {
			try {
				if(con !=null) 			con.close();
				if(ps !=null) 				ps.close();
				if(st !=null) 				st.close();
				if(rs !=null) 				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

}
