package com.group3.springProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.group3.springProject.dto.OrderSheet;

//com.group3.springProject.mapper.OrderMapper
@Mapper
public interface OrderMapper {
	OrderSheet selectByUserId(String userId);
<<<<<<< HEAD
}
=======
}
>>>>>>> 622b62f97a5300333d0d1db9ad415eccda9e0066
