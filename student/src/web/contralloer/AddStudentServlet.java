package web.contralloer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import service.BusinessService;
import utils.WebUtils;

public class AddStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
		request.setCharacterEncoding("UTF-8");
		Student s = WebUtils.requestToBean(request, Student.class);
		s.setId(WebUtils.makeID());
		BusinessService bs = new BusinessService();
		bs.addStu(s);
		request.setAttribute("message", "��ϲ��ע��ɹ�������");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		return;
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "�û�������ѧ���Ѿ���ע�������");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
	}

}
