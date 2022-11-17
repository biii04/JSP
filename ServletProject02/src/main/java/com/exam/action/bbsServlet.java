package com.exam.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bbsServlet
 */
@WebServlet("/exam/bbs")
public class bbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bbsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String memo = request.getParameter("memo");
		
		request.setAttribute("name", name);
		request.setAttribute("subject", subject);
		request.setAttribute("memo", memo);
		
		RequestDispatcher rd = request.getRequestDispatcher("bbsResult.jsp");
		rd.forward(request, response);
		//doGet(request, response);
	}

}
