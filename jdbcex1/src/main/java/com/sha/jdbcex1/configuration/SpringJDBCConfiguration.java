package com.sha.jdbcex1.configuration;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
 
@Configuration
@ComponentScan(basePackages="com.sha.jdbcex1")       //for @repo should use @comp...
public class SpringJDBCConfiguration {
	
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	       
	        dataSource.setDriverClassName("org.h2.Driver");
	        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	        dataSource.setUsername("sa");
	        dataSource.setPassword("");
	        return dataSource;
	    }
	 
	    @Bean      //dao class depends on jdbctemplate object to get db through the datasource
	    public JdbcTemplate jdbcTemplate() {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate();
	        jdbcTemplate.setDataSource(dataSource());
	        return jdbcTemplate;
	    }
	    //in replace of @repository
	  /*  @Bean        //in replace of @repository and to inject jdbctemplate object we use @autowired//
	    public EmployeeDAO employeeDAO(){
	        EmployeeDAOImpl empDao = new EmployeeDAOImpl();
	        empDao.setJdbcTemplate(jdbcTemplate());
	        return empDao;
	    }*/
	 
	  
}
