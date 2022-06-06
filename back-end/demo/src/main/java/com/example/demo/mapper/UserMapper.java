package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.UserVo;

@Mapper
public interface UserMapper {
	List<UserVo> userList();
	UserVo fetchUserByID(int id);
	void updateUser(UserVo user);
	void insertUser(UserVo user);
	void deleteUser(int id);

}
