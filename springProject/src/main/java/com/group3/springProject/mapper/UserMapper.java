package com.group3.springProject.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.group3.springProject.dto.User;
//com.group3.springProject.mapper.UserMapper
@Mapper
public interface UserMapper {
	public User selectUserId(String user_id);
	public User selectUserEmail(String user_email);
	public User selectUserPhone(String user_phone);
	public int userSignup(User user);
	
	User selectOne(String user_id);
	public int updateOne(User user);
<<<<<<< HEAD
}
=======
	
	User selectPwOne(String user_id, String user_pw);
}
>>>>>>> 622b62f97a5300333d0d1db9ad415eccda9e0066
