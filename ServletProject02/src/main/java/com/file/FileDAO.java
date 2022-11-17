package com.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FileDAO {
private static FileDAO instance = new FileDAO();
public static FileDAO getInstance() {
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
		public void fileInsert(FileDTO addr) {
			Connection con= null;
			PreparedStatement ps = null;
			
			try {
				con = getConnection();
				String sql = "insert into imagetest values(address_seq.nextval,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, addr.getName());
				ps.setString(2, addr.getImage());
				ps.setString(3, addr.getFile());
				ps.executeUpdate();  
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeConnection(con,ps, null, null);
			}
		}
			


		//전체보기
		public ArrayList<FileDTO> fileList() {
			Connection con = null;
			Statement st= null;
			ResultSet rs = null;
			ArrayList<FileDTO> arr= new ArrayList<FileDTO>();
			
			try {
				con = getConnection();
				String sql = "select * from imagetest";
				st = con.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					FileDTO addr = new FileDTO();
					
					addr.setName(rs.getString("name"));
					addr.setFile(rs.getString("file"));
					addr.setImage(rs.getString("image"));
					arr.add(addr);
				}
			}catch(Exception e){
				e.printStackTrace();
			} finally {
				closeConnection(con, null, st, rs);
			}
			return arr;
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
