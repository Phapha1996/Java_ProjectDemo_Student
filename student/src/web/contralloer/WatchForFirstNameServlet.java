package web.contralloer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import service.BusinessService;

public class WatchForFirstNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
		request.setCharacterEncoding("UTF-8");
		String firstname = request.getParameter("firstname");
		BusinessService bs = new BusinessService();
		List<Student> list = bs.findForFirstName(firstname);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/watchFirstName.jsp").forward(request, response);
		return;
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "您要查找的用户不存在！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
	}

}
