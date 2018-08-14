package com.dk.springboot.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dk.springboot.entity.User;
import com.dk.springboot.repository.UserRepository;
import com.dk.springboot.result.Result;
import com.dk.springboot.util.Md5Util;

@RestController
public class UserController {
	@Resource
	private UserRepository userRepository;
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="adduser")
	public Result saveUser(User user){
		Result result = new Result();
		if(StringUtils.isEmpty(user.getUserName())
				||StringUtils.isEmpty(user.getPassword())){
			result.setMessage("参数不允许为空");
			return result;
		}
		
		List<User> infos = userRepository.findByUserName(user.getUserName());
		if(infos!=null && infos.size()!=0){
			result.setMessage("该用户名已存在");
			result.setStatus(false);
			result.setData(user);
			return result;
		}
		user.setPassword(Md5Util.md5String(user.getPassword()));
		user = userRepository.save(user);
		result.setStatus(true);
		result.setData(user);
		result.setMessage("添加成功");
		
		return result;
	}
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	@RequestMapping(value="getinfos")
	public Result findAll(){
		Result result = new Result();
		result.setStatus(true);
		List<User> infos = userRepository.findAll();
		result.setData(infos);
		result.setMessage("查询成功");
		return result;
	}

}
