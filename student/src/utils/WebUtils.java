package utils;

import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class WebUtils {

	public static <T> T requestToBean(HttpServletRequest request,Class<T> beanClass){
		try {
			T bean = beanClass.newInstance();
			
			ConvertUtils.register(new DateLocaleConverter(), Date.class);  	//ע������ת����
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
				
			}
			
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	public static String makeID(){
		return UUID.randomUUID().toString();					//����һ��������Ψһ��ID
	}
	
	
}
