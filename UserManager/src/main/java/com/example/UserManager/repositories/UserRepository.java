package com.example.UserManager.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.UserManager.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
//	public List<User> findById(int id){
//		return jdbcTemplate.queryForObject("Select * from user where id = ?",
//				new BeanPropertyRowMapper<User>(User.class));
//	}
    public User findByName(String name);
    
    //public User findByID(int id);
}