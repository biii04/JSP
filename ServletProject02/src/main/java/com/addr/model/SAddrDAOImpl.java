package com.addr.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class SAddrDAOImpl implements SAddrDAO {
private static SAddrDAO instance = new SAddrDAOImpl();
public static SAddrDAO getInstance() {
	return instance;
}
	
	//db연결
	private  Connection getConnection() throws Exception {
		Context  initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource  ds = (DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	//추가
	@Override
	public void addrInsert(AddrDTO addr) {
		Connection con= null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "insert into address values(address_seq.nextval,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, addr.getName());
			ps.setString(2,addr.getZipcode());
			ps.setString(3,  addr.getAddr());
			ps.setString(4, addr.getTel());
			ps.executeUpdate();  
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,ps, null, null);
		}
	}
		
	//전체보기
	@Override
	public ArrayList<AddrDTO> addrList() {
		Connection con = null;
		Statement st= null;
		ResultSet rs = null;
		ArrayList<AddrDTO> arr= new ArrayList<AddrDTO>();
		
		try {
			con = getConnection();
			String sql = "select * from address";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AddrDTO addr = new AddrDTO();
				addr.setAddr(rs.getString("addr"));
				addr.setName(rs.getString("name"));
				addr.setNum(rs.getInt("num"));
				addr.setTel(rs.getString("tel"));
				addr.setZipcode(rs.getString("zipcode"));
				arr.add(addr);
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	//상세보기
	@Override
	public AddrDTO addrDetail(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		AddrDTO address = null;
		
		try {
			con = getConnection();
			String sql = "select * from address where num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				address = new AddrDTO();
				address.setNum(rs.getInt("num"));
				address.setName(rs.getString("name"));
				address.setAddr(rs.getString("addr"));
				address.setZipcode(rs.getString("zipcode"));
				address.setTel(rs.getString("tel"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return address;
	}

	//수정
	@Override
	public void addrUpdate(AddrDTO addr) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "update address set name = ?, tel = ?, zipcode = ?, addr = ? where num = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, addr.getName());
			ps.setString(2, addr.getTel());
			ps.setString(3, addr.getZipcode());
			ps.setString(4, addr.getAddr());
			ps.setInt(5, addr.getNum());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	//삭제
	@Override
	public void addrDelete(int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = getConnection();
			String sql = "delete from address where num="+num;
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//전체보기(검색)
	@Override
	public ArrayList<AddrDTO> addrSearchList(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<AddrDTO> arr = new ArrayList<AddrDTO>();
		
		try {
			con = getConnection();
			String sql = "select * from address where"+field+" like '%"+word+"%'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				AddrDTO address = new AddrDTO();
				address.setNum(rs.getInt("num"));
				address.setName(rs.getString("name"));
				address.setAddr(rs.getString("addr"));
				address.setZipcode(rs.getString("zipcode"));
				address.setTel(rs.getString("tel"));
				arr.add(address);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//개수(검색 x)
	@Override
	public int addrCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = getConnection();
			String sql = "select count(*) from address";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		
		return count;
	}

	//개수(검색 o)
	@Override
	public int addrSearchCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con=getConnection();
			String sql = "select count(*) from address where" +field+"like '%"+word+"%'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	//우편번호검색
	@Override
	public ArrayList<ZipDTO> addrZipRead(String dong) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ZipDTO>zarr = new ArrayList<ZipDTO>();
		
		try {
			con=getConnection();
			String sql = "select * from zipcode where dong like '%"+dong+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ZipDTO z = new ZipDTO();
				z.setBunji(rs.getString("bunji"));
				z.setDong(rs.getString("dong"));
				z.setGugun(rs.getString("gugun"));
				z.setSeq(rs.getInt("seq"));
				z.setSido(rs.getString("sido"));
				z.setZipcode(rs.getString("zipcode"));
				zarr.add(z);  //받아온 데이터를 zarr에 담는 작업
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,null,st,rs);
		}
		return zarr;
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
