package utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;

import com.mysql.jdbc.ResultSetMetaData;

public class BeanHandler implements ResultSetHandler {

	private Class clazz;
	
	
	public BeanHandler(Class clazz){
		this.clazz = clazz;
	}
	
	
	//ģ�����ģʽ
	public Object handler(ResultSet rs) {
		
		try{
			if(!rs.next()){
				return null;
			}
			Object bean = clazz.newInstance();
			
			ResultSetMetaData metadata = (ResultSetMetaData) rs.getMetaData();			//�õ�Ԫ����
			int columnCount = metadata.getColumnCount();		//�õ���������ж���������
			for(int i=0;i<columnCount;i++){
				String columnName = metadata.getColumnName(i+1);			//�õ�ÿ�е�����
				Object columnData = rs.getObject(i+1);					//�õ�ÿһ�е�����
				
				Field f = clazz.getDeclaredField(columnName);					//ͨ��������������������
				f.setAccessible(true);								//ǿ�д�Ȩ�޿���
				f.set(bean, columnData);						//��ֵ��װ��������Ե���
			}
			
			return bean;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

}
