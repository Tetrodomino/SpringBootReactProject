package com.example.reactProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.reactProject.entity.User;

@Mapper
public interface UserDao {
	
	@Select("select * from users where uid=#{uid}") // #{uid} 자리에 매개변수 uid가 들어감
	User getUser(String uid);
	
	@Select("select * from users where isDeleted=0"
			+ " order by regDate desc"
			+ " limit #{count} offset #{offset}")
	List<User> getUserList(int count, int offset);
	
	@Insert("insert into users values (#{uid}, #{pwd}, #{uname}"
			+ ", #{email}, default, default, #{profile}, #{github}, #{insta}, #{location})")
	void insertUser(User user);
	
	@Update("update users set pwd=#{pwd}, uname=#{uname}, email=#{email}"
			+ ", profile=#{profile}, github=#{github}, insta=#{insta}, location=#{location}"
			+ " where uid=#{uid}")
	void updateUser(User user);
	
	@Update("update users set isDeleted=1 where uid=#{uid}")
	void deleteUser(String uid);
	
	@Select("Select count(uid) from users where isDeleted=0")
	int getUserCount();
}
