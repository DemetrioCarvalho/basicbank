package com.livingit.basicbank.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livingit.basicbank.model.User;
import com.livingit.basicbank.repository.UserRepository;

/**
 * 
 * @author BytesTree
 *
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public User getById(Serializable id) {
		return userRepository.findOne((Long) id);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(Serializable id) {
		userRepository.delete((Long) id);

	}

}
