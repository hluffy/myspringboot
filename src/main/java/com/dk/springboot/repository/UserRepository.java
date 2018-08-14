package com.dk.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.springboot.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	/**
	 * 添加用户
	 */
	User save(User user);
	
	/**
	 * 查询所有用户
	 */
	List<User> findAll();
	
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	List<User> findByUserName(String userName);

}
