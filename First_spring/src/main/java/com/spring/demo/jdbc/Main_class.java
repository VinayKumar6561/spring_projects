package com.spring.demo.jdbc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main_class {

	@Autowired
	jdbcService jdbs;
	
	@PostMapping("/inserting")
	public Map postMethodName(@RequestBody Jdbc_class obj) {
		//TODO: process POST request
		
		int res=jdbs.meth1(obj);
		HashMap<Integer,String> mp = new HashMap<>();
		if(res>0)
		{
			mp.put(1,"Data Inserted");
		}
		else
		{
			mp.put(2,"Data Not Inserted");
		}
	
		return mp;
	}
	
}
