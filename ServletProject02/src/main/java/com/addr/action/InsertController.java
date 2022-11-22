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

	    response.sendRedirect("addrList");  //�����̷�Ʈ�� ���谡 �������鼭 list.addr�� �ٲ��
	    //requestDispatcher�� ���谡 �����Ǵ°�
	    return; //������ �־��� �� '������ �̹� Ŀ�Ե� �Ŀ��� forward�� �� �����ϴ�'�̷��� �ߴ°� ���� �������ν� �ذ�
		//doGet(request, response);
	}

}
