package Junittest;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import bean.Student;
import dao.StudentDao;

public class TestDao {
	
	@Test
	public void testadd(){
		try{
		StudentDao dao = new StudentDao();
		
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("1996-1-17");
		for(int i=0;i<=9;i++){
		Student s = new Student();
		s.setId("uerergry"+i);
		s.setNum("13"+String.valueOf(i));
		s.setName("¬����"+String.valueOf(i));
		s.setGender("Ů");
		s.setBirthday(date);
		s.setCollege("��ľѧԺ");
		s.setMajor("��湤��");
		s.setGrade("���");
		
		dao.add(s);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testfind(){
		try{
		StudentDao dao = new StudentDao();
		Student s = dao.findForNum("3140767110");
		
		s.getName();
		s.getBirthday();
		s.getGender();
		s.getNum();
	//	s.getSchool();
		
		int a = dao.getTotleRecord();
		System.out.print(a);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete(){
		try{
			StudentDao dao = new StudentDao();
			dao.delete("fage");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testFristName(){
		
		StudentDao dao = new StudentDao();
		List<Student> list = dao.findForFirstName("��");
		
		
	}
	
	

}
