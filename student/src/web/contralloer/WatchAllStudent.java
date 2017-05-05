package web.contralloer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import service.BusinessService;
import bean.Page;

public class WatchAllStudent extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			BusinessService bs = new BusinessService();
			String pagenum = request.getParameter("pagenum");
			Page page = bs.findStuForPage(pagenum);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/watchAllStudent.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "≤È—Ø ß∞‹!!!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		doGet(request, response);
	}

}
