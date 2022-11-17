package com.board.model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConnection;

public class BoardDAOImpl implements BoardDAO {
	private static BoardDAO instance = new BoardDAOImpl();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	//추가
	@Override
	public void boardInsert(BoardDTO board) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBConnection.getConnection();
			String sql = "insert into simpleboard values(simpleboard_seq.nextval,?,?,?,0,?,sysdate)";
			ps=con.prepareStatement(sql);
			ps.setString(1, board.getUserid());
			ps.setString(2, board.getSubject());
			ps.setString(3, board.getEmail());
			ps.setString(4, board.getContent());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,ps, null, null);
		}
	}
	
	//수정
	@Override
	public void boardUpdate(BoardDTO board) {
		// TODO Auto-generated method stub
		
	}
	
	//전체보기
	@Override
	public ArrayList<BoardDTO> boardList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> board = new ArrayList<BoardDTO>();
		
		try {
			con = DBConnection.getConnection();
			String sql = "select * from simpleboard";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				BoardDTO bdto = new BoardDTO();
				bdto.setNum(rs.getInt("num"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setSubject(rs.getString("subject"));
				bdto.setEmail(rs.getString("email"));
				bdto.setContent(rs.getString("content"));
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setRegdate(rs.getString("regdate"));
				board.add(bdto);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		return board;
	}
	
	//전체보기2
	@Override
	public ArrayList<BoardDTO> boardList(int startRow, int endRow, String field, String word) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//삭제
	@Override
	public void boardDelete(int num) {
		// TODO Auto-generated method stub
		
	}
	
	//게시글 수
	@Override
	public int boardCount(String field, String word) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//상세보기
	@Override
	public BoardDTO findByNum(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BoardDTO board = null;
		
		try {
			con = DBConnection.getConnection();
			String sql = "select * from simpleboard where num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				board = new BoardDTO();
				board.setUserid(rs.getString("num"));
				board.setSubject(rs.getString("subject"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}
	
	//댓글추가
	@Override
	public void commentInsert(CommentDTO comment) {
		// TODO Auto-generated method stub
		
	}
	
	//전체보기
	@Override
	public ArrayList<CommentDTO> findAllComment(int bnum) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//댓글
	@Override
	public int commentCount(int num) {
		// TODO Auto-generated method stub
		return 0;
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
