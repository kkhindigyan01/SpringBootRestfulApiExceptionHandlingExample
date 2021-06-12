package com.kkhindigyan.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkhindigyan.app.dao.UserRepository;
import com.kkhindigyan.app.entities.User;

@Service
 public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void deleteUserById(int userId) {
		
		System.out.println("Deleting User whose Id ="+userId);
		userRepository.deleteById(userId);
	}

	public void updateUserAgeById(int userId,int newAge) {

		System.out.println("Finding Enitity by Id = "+userId);
		Optional<User> findById = userRepository.findById(userId);
		User user = findById.get();
		user.setAge(newAge);
		
		userRepository.save(user);
	}

	public Iterable<User> findAllUsers() {
	 return	userRepository.findAll();
	}

	public Optional<User> findUserById(Integer userId)  {
		return userRepository.findById(userId);
		
	}

	public void createUsers(Iterable<User> userList) {
		Iterable<User> dbSavedUsers = userRepository.saveAll(userList);
		System.out.println("Following users info saved in database:");
		dbSavedUsers.forEach(System.out::println);
	}

	public User createUser(User user) {
		User dbUser = userRepository.save(user);
		return dbUser;
	}
}
