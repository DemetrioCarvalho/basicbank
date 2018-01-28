package com.livingit.basicbank.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.livingit.basicbank.model.User;
import com.livingit.basicbank.service.UserService;

/**
 * 
 * @author BytesTree
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

	final static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> addEmployee(@RequestBody User user) {
		userService.save(user);

		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@RequestBody User user) {
		User existingEmp = userService.getById(user.getIduser());
		if (existingEmp == null) {
			logger.debug("User with id " + user.getIduser() + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.save(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		User user = userService.getById(id);
		if (user == null) {
			logger.debug("Employee with id " + id + " does not exists");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Employee:: " + user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllEmployees() {
		List<User> users = userService.getAll();
		if (users.isEmpty()) {
			logger.debug("Employees does not exists");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + users.size() + " Employees");
		logger.debug(Arrays.toString(users.toArray()));
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
		User user = userService.getById(id);
		if (user == null) {
			logger.debug("Employee with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.delete(id);
			logger.debug("Employee with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
