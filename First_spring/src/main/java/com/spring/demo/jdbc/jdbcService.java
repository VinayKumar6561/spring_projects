package com.spring.demo.jdbc;

import java.security.spec.NamedParameterSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class jdbcService {
 @Autowired
 JdbcTemplate jdbct;
 
@Autowired
NamedParameterJdbcTemplate njdbc;

	public int  meth1(Jdbc_class obj)
	{
		return jdbct.update("insert into TEMP values (?,?)",obj.getId(),obj.getName());
		
	}

	
}
