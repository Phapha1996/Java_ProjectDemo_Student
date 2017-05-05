package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class JdbcUtils {

	private static String username = null;
	private static String password = null;
	private static String url = null;
	private static String driver = null;
	
	static{
		try{
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties pro = new Properties();
		pro.load(in);
		username = pro.getProperty("username");
		password = pro.getProperty("password");
		url = pro.getProperty("url");
		driver = pro.getProperty("driver");
		Class.forName(driver);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	public static void release(Connection con,Statement st,ResultSet rs){

		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				st = null;
			}
		}
		
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				con = null;
			}
		}
	}
	
}
