package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.UserVo;

@CrossOrigin(origins="*",maxAge=3600)
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserMapper userMapper;
	@GetMapping
	public List<UserVo> userList(){
		System.out.println(userMapper.userList());
		System.out.println("유저리스트 출력 성공");
		return userMapper.userList();
	}
	@PostMapping
	void insertUser(@RequestBody UserVo user) {
		userMapper.insertUser(user);
		System.out.println("유저 DB저장 성공");
	}
	@GetMapping("/{id}")
	public UserVo fetchUserByID(@PathVariable int id) {
		System.out.println(userMapper.fetchUserByID(id));
		UserVo fetchUser=userMapper.fetchUserByID(id);
		return fetchUser;
	}
	@PutMapping("/{id}")
	public void updateUser(@PathVariable int id, @RequestBody UserVo user) {
		
		UserVo updateUser = user;
		System.out.println("업데이트유저 => " + updateUser);
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setAge(user.getAge());
		updateUser.setSalary(user.getSalary());
		userMapper.updateUser(updateUser);

	}
	@DeleteMapping("/{id}")
	public void  deleteUser(@PathVariable int id) { 
		System.out.println("딜리트유저 => " + id);
		userMapper.deleteUser(id);
		System.out.println("유저 삭제 성공");
	}

}
