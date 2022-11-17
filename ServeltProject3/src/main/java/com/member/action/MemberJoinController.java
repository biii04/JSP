package com.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDAO;
import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;
import com.util.SHA256;

/**
 * Servlet implementation class MemberJoinController
 */
@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDTO member = new MemberDTO();
		member.setAdmin(Integer.parseInt(request.getParameter("admin")));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		//member.setPwd(request.getParameter("pwd"));
		String userid = request.getParameter("userid");
		member.setUserid(userid);
		
		String encPwd //암호화된 비번(db에 저장될때 아무거나 들어가짐)
		= SHA256.getEncrypt(request.getParameter("pwd"),userid);
		member.setPwd(encPwd);
		
		MemberDAO dao = MemberDAOImpl.getInstance();
		dao.memberJoin(member);
		
		response.sendRedirect("login");
		return;
	}

}
