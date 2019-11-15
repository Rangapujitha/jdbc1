package com.sha.jdbcex1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sha.jdbcex1.configuration.SpringJDBCConfiguration;
import com.sha.jdbcex1.dao.EmployeeDAO;
 
public class Test {

	public static void main(String[] args) {
		        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
		                SpringJDBCConfiguration.class);
		 
		        EmployeeDAO empDAO = applicationContext.getBean(EmployeeDAO.class);
		 
		        String empName = empDAO.getEmployeeName(101);
		 
		        System.out.println("Employee name is " + empName);
		 
		        applicationContext.close();
		    }
		}
