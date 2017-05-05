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

	
	//增加一个学生
	public void add(Student s){
		try {		
			String sql = "insert into student(id,num,name,gender,birthday,college,major,grade) values(?,?,?,?,?,?,?,?)";
			Object param[] = {s.getId(),s.getNum(),s.getName(),s.getGender(),s.getBirthday(),s.getCollege(),s.getMajor(),s.getGrade()};
			JdbcUtils_DBCP.update(sql, param);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	//通过名字删除
	public void delete(String name){

		try {
			String sql = "DELETE FROM student WHERE name=?";
			Object param[] = {name};
			JdbcUtils_DBCP.update(sql, param);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
		
	}
	
	//通过学号查找
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
	
	
	//方法重构第一个方法
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
	
	
	//提供分页查找功能做铺垫
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
	
	
	//得到数据库中的总记录数
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
