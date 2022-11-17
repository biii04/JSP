package com.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDAOImpl;
import com.board.model.BoardDTO;

/**
 * Servlet implementation class BoardWriteController
 */
@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("boardwrite.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDTO bdto = new BoardDTO();
		
		bdto.setUserid(request.getParameter("userid"));
		bdto.setSubject(request.getParameter("subject"));
		bdto.setEmail(request.getParameter("email"));
		bdto.setContent(request.getParameter("content"));
		
		BoardDAO dao = BoardDAOImpl.getInstance();
		dao.boardInsert(bdto);
		
		response.sendRedirect("board.list");
		return;
	}

}
