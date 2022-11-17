package com.addr.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addr.model.AddrDTO;
import com.addr.model.SAddrDAO;
import com.addr.model.SAddrDAOImpl;

/**
 * Servlet implementation class InsertController
 */
@WebServlet("/addr/insert.addr")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("addr_insert.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AddrDTO addr = new AddrDTO();

		addr.setName(request.getParameter("name"));
		addr.setZipcode(request.getParameter("zipcode"));
		addr.setAddr(request.getParameter("addr"));
		addr.setTel(request.getParameter("tel"));
		
		SAddrDAO dao = SAddrDAOImpl.getInstance();
	    dao.addrInsert(addr);

	    response.sendRedirect("addrList");  //리다이렉트는 관계가 끊어지면서 list.addr로 바뀌고
	    //requestDispatcher은 관계가 유지되는것
	    return; //정보를 넣었을 때 '응답이 이미 커밋된 후에는 forward할 수 없습니다'이렇게 뜨는걸 리턴 넣음으로써 해결
		//doGet(request, response);
	}

}
