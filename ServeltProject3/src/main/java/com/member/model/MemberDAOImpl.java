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

	//�߰�
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

	//��ü����
	@Override
	public ArrayList<MemberDTO> getMember() {
		// TODO Auto-generated method stub
		return null;
	}

	//����
	@Override
	public int memberDelete(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	//����
	@Override
	public int memberUpdate(MemberDTO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�󼼺���
	@Override
	public MemberDTO findById(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	//ȸ����
	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	//���̵��ߺ�Ȯ��
	@Override
	public String memberIdCheck(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	//�α���
	@Override
	public MemberDTO memberLoginCheck(String userid, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		MemberDTO member = new MemberDTO();
		//��ȸ�� :-1
		member.setAdmin(-1);
		//ȸ�� : �Ϲ�ȸ��(0), ������(1) 
		//ȸ�������� ������� : 2
		try {
			con = DBConnection.getConnection();
			String sql = "select * from memberdb where userid = '"+userid+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) { //id����(ȸ���� ����)
				if(rs.getString("pwd").equals(pwd)) {//�������
					member.setAdmin(rs.getInt("admin"));
					member.setEmail(rs.getString("email"));
					member.setName(rs.getString("name"));
					member.setPhone(rs.getString("phone"));
					member.setPwd(rs.getString("pwd"));
					member.setUserid(rs.getString("userid"));
				}else {  //��� Ʋ��
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
