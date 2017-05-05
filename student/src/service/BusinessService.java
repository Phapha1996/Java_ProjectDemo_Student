package service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dao.StudentDao;
import bean.Page;
import bean.Student;

public class BusinessService {

	//��������һ��ѧ��
	public void addStu(Student s){
		
		StudentDao dao = new StudentDao();
		dao.add(s);
		
	}
	
	
	//�������һ��ѧ��ͨ������
	public Student findStuForName(String stuName){
		
		StudentDao dao = new StudentDao();
		Student s = dao.findForName(stuName);
		return s;
	}
	
	
	//�������һ��ѧ��ͨ��ѧ��
	public Student findStuForNum(String stuNum){
		StudentDao dao = new StudentDao();
		Student s = dao.findForNum(stuNum);
		return s;
		
	}
	
	
	//ͨ�����Ͻ���ģ������
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

	
	
	//����ɾ��һ��ѧ��
	public void DropStudet(String stuName){
		StudentDao dao = new StudentDao();
		dao.delete(stuName);
	}

	//ͨ���û���������ҳ�룬���û�����һ��list���ϣ��������װ�����û��뿴ҳ�������
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
