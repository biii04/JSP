package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class informServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String name = req.getParameter("name");
	String id = req.getParameter("id");
	String pwd = req.getParameter("pwd");
	String phone = req.getParameter("phone");
	String address = req.getParameter("address");
	
//	req.setAttribute("name", name);
//	req.setAttribute("id", id);
//	req.setAttribute("pwd", pwd);
//	req.setAttribute("phone", phone);
//	req.setAttribute("address", address);
	
	
//	Info info = new Info();
//	info.setAddress(address);
//	info.setId(id);
//	info.setName(name);
//	info.setPhone(phone);
//	info.setPwd(pwd);
	
	Info info = new Info(name, id, pwd, phone, address);
	
	req.setAttribute("info", info);
	
	RequestDispatcher rd = req.getRequestDispatcher("informResult.jsp"); /* 값을 가지고 .jsp 저기로 가라 */
	rd.forward(req, resp);
}
}
