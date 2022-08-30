package com.group3.springProject.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.group3.springProject.dto.User;
//com.group3.springProject.mapper.UserMapper
@Mapper
public interface UserMapper {
	// 회원가입용
	public User selectUserId(String user_id); // id Ajax 중복 검사
	public User selectUserEmail(String user_email); // email Ajax 중복 검사
	public User selectUserPhone(String user_phone); // phone Ajax 중복 검사
	public int userSignup(User user); // 회원가입(유저 등록)
	
	User selectOne(String user_id);
	public int updateOne(User user);
	User selectPwOne(String user_id, String user_pw);
}
