package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import utils.BeanHandler;
import utils.JdbcUtils_DBCP;
import utils.ListHandler;
import bean.Student;

public class StudentDao {

	
	//����һ��ѧ��
	public void add(Student s){
		try {		
			String sql = "insert into student(id,num,name,gender,birthday,college,major,grade) values(?,?,?,?,?,?,?,?)";
			Object param[] = {s.getId(),s.getNum(),s.getName(),s.getGender(),s.getBirthday(),s.getCollege(),s.getMajor(),s.getGrade()};
			JdbcUtils_DBCP.update(sql, param);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	//ͨ������ɾ��
	public void delete(String name){

		try {
			String sql = "DELETE FROM student WHERE name=?";
			Object param[] = {name};
			JdbcUtils_DBCP.update(sql, param);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
		
	}
	
	//ͨ��ѧ�Ų���
	public Student findForNum(String num){
		
		try {		
			String sql = "select * from student where num=?";
			Object param[] = {num};
			Student s = (Student) JdbcUtils_DBCP.query(sql, param, new BeanHandler(Student.class));
			return s;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	//�����ع���һ������
	public Student findForName(String name){
		try{
			String sql = "select * from student where name=?";
			Object param[] = {name};
			Student s = (Student) JdbcUtils_DBCP.query(sql, param, new BeanHandler(Student.class));
			return s;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	//�ṩ��ҳ���ҹ������̵�
	public List<Student> getPageData(int start,int size){
		try{
			String sql = "select * from student where 1=1 order by num*1 limit ?,?";
			Object param[] = {start,size};
			List list = (List) JdbcUtils_DBCP.query(sql, param, new ListHandler(Student.class));
			
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	//�õ����ݿ��е��ܼ�¼��
		public int getTotleRecord(){
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			try{
				con = JdbcUtils_DBCP.getConnection();
				String sql = "select count(*) from student";
				st = con.prepareStatement(sql);
				rs = st.executeQuery();
				int index = 0;
				while(rs.next()){
					index = rs.getInt(1);
				}
				return index;
			}catch(SQLException e){

				e.printStackTrace();
				throw new RuntimeException();
			}finally{
				JdbcUtils_DBCP.release(con, st, rs);
			}
			
		}
	
	
	public Student change(){
		return null;
	}
	
	
	public List<Student> findForFirstName(String firstname){
		try{
		String sql = "select * from student where name like ?";
		Object param[] = {firstname+"%"};
		List list = (List) JdbcUtils_DBCP.query(sql, param, new ListHandler(Student.class));
		
		return list;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	
	
}
