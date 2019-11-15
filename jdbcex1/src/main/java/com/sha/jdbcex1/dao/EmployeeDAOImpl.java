package com.sha.jdbcex1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
	JdbcTemplate jdbcTemplate;
    //in replace of autowired to inject jdbctemplate object
    /*public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }*/   
	public String getEmployeeName(int id) {
		String sql = "select name from employee where id = ?";
        String name = jdbcTemplate.queryForObject(sql,new Object[]{id},String.class);
        return name;
	}

}
