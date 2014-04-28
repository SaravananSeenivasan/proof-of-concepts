package com.sivalabs.discuzz.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.discuzz.core.entities.User;
import com.sivalabs.discuzz.core.repositories.RoleRepository;
import com.sivalabs.discuzz.core.repositories.UserRepository;

/**
 * @author Siva
 * 
 */
@Service
@Transactional
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public void createUser(User user)
	{
		if(checkEmailExists(user.getEmail())){
			throw new RuntimeException("Email ["+user.getEmail()+"] already exist");
		}
		userRepository.save(user);
	}
	
	public void updateUser(User user)
	{
		userRepository.save(user);
	}
	
	public void deleteUser(Integer userId)
	{
		userRepository.delete(userId);
	}

	public User findUserById(Integer userId)
	{
		return userRepository.findOne(userId);
	}

	public List<User> findAllUsers()
	{
		return userRepository.findAll();
	}

	public boolean checkEmailExists(String email)
	{
		return userRepository.findByEmail(email) != null;
	}

	public User login(String email, String password)
	{
		return userRepository.login(email, password);
	}

}
