package com.fifth.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fifth.spring.model.UserModel;

@Service
public class UserService {
	
	@Autowired
	JdbcTemplate jTemp;
	
	public String fun1()
	{
		return "This is first function";
	}
	
	public String addUser(UserModel uModel)
	{
		String sql="insert into USER (username,password) values (?,?)";
		int result=jTemp.update(sql,uModel.getUsername(),uModel.getPassword());
		
		return result > 0 ? "User Inserted Successfully": "User Insertion Failed";
		
	}
	
	public List<UserModel> displayUser()
	{
		String sql="select * from USER";
		
		return jTemp.query(sql, (rs,rowNum) ->
		{
		    return new UserModel(
		    		rs.getInt("user_id"),
		    		rs.getString("username"),
		    		rs.getString("password")
		    		);
		
		});
	}
	
	public String loginUser(UserModel uModel) {
        String sql = "SELECT * FROM USER WHERE username=? AND password=?";

        List<UserModel> users = jTemp.query(sql,
            (rs, rowNum) -> new UserModel(
                rs.getInt("user_id"),
                rs.getString("username"),
                rs.getString("password")
            ),
            uModel.getUsername(), uModel.getPassword()
        );

        return users.isEmpty() ? "Invalid credentials" : "User logged in";
       
    }
}
