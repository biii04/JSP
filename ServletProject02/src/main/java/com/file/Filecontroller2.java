package com.file;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Filecontroller2
 */
@WebServlet("/file2/upload.do")
public class Filecontroller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filecontroller2() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String savePath="upload";
		int uploadFileSizeLimit=5*1024*1024; //45mb
		String encType="utf-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("서버상의 실제 디렉토리:"+uploadFilePath);
		
		MultipartRequest multi = new MultipartRequest(
				request,
				uploadFilePath,
				uploadFileSizeLimit,
				encType,
				new DefaultFileRenamePolicy());
		
		String filename = multi.getFilesystemName("uploadFile");
		if(filename == null) {
			filename = "";
		}
		String name = multi.getParameter("name");
		String title = multi.getParameter("title");
		String image = multi.getParameter("image");
		FileDTO addr = new FileDTO(name, title, image);
		FileDAO dao = FileDAO.getInstance();
		dao.fileInsert(addr);
		response.sendRedirect("imageList");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
