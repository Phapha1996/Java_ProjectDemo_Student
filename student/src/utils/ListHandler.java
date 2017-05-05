package utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.ResultSetMetaData;


public class ListHandler implements ResultSetHandler {

	Class clazz;

	public ListHandler(Class clazz) {
		this.clazz = clazz;
	}

	public Object handler(ResultSet rs) {
		try {
			ResultSetMetaData metadata = (ResultSetMetaData) rs.getMetaData(); // �õ�rsԪ����
			int columnCount = metadata.getColumnCount(); // �õ��ж�����

			List list = new LinkedList();
			while (rs.next()) { // ֻҪ��������������ݣ��ͼ���������

				Object bean = clazz.newInstance();

				for (int i = 0; i < columnCount; i++) {
					String columnName = metadata.getColumnName(i + 1); // �õ���i+1�е�������
					Object columnValue = rs.getObject(columnName); // ͨ��������ֵõ�ֵ

					Field f = clazz.getDeclaredField(columnName); // ���������
					f.setAccessible(true);
					f.set(bean, columnValue);
				}
				list.add(bean);
			}

			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
