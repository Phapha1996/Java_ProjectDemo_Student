package service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dao.StudentDao;
import bean.Page;
import bean.Student;

public class BusinessService {

	//处理增加一名学生
	public void addStu(Student s){
		
		StudentDao dao = new StudentDao();
		dao.add(s);
		
	}
	
	
	//处理查找一名学生通过名字
	public Student findStuForName(String stuName){
		
		StudentDao dao = new StudentDao();
		Student s = dao.findForName(stuName);
		return s;
	}
	
	
	//处理查找一名学生通过学号
	public Student findStuForNum(String stuNum){
		StudentDao dao = new StudentDao();
		Student s = dao.findForNum(stuNum);
		return s;
		
	}
	
	
	//通过姓氏进行模糊查找
	public List<Student> findForFirstName(String firstName){
		
		StudentDao dao = new StudentDao();
		List<Student> list = dao.findForFirstName(firstName);
		Collections.sort(list, new Comparator<Student>(){
			public int compare(Student s1,Student s2){
				if(Integer.parseInt(s1.getNum())>Integer.parseInt(s2.getNum())){
					return 1;
				}
				if(Integer.parseInt(s1.getNum())==Integer.parseInt(s2.getNum())){
					return 0;
				}
				return -1;
			}
			
			
		});
		return list;
	}

	
	
	//处理删除一个学生
	public void DropStudet(String stuName){
		StudentDao dao = new StudentDao();
		dao.delete(stuName);
	}

	//通过用户传过来的页码，给用户带回一个list集合，这个集合装载了用户想看页码的数据
	public Page findStuForPage(String pageNum){
		
		StudentDao dao = new StudentDao();
		if(pageNum==null){
			Page page = new Page(dao.getTotleRecord(),1);
			List<Student> list = dao.getPageData(page.getStartindex(), page.getPAGESIZE());
			page.setList(list);
			return page;
		}
		
		Page page = new Page(dao.getTotleRecord(),Integer.parseInt(pageNum));
		List<Student> list = dao.getPageData(page.getStartindex(), page.getPAGESIZE());
		page.setList(list);
		return page;
	}
	
	
}
