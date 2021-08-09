package com.example.resttest.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.resttest.models.ApiResponseModel;
import com.example.resttest.models.UserModel;
import com.example.resttest.respositories.ApiResponseRepository;
import com.example.resttest.respositories.UserModelRepository;


@RestController
public class UserController {
	
	@Autowired
	private UserModelRepository userRepository;
	
	@Autowired
	private ApiResponseRepository responseRepository;
	
	@GetMapping("/users")
	public Iterable<UserModel> fetchAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public UserModel addNewUser(@RequestBody UserModel newUser) {
		return userRepository.save(newUser);
	}
	
	@GetMapping("/users/{id}")
	public UserModel fetchUserById(@PathVariable("id") Long id) throws Exception {
	   return userRepository.findById(id).orElseThrow(() -> new Exception("Id do usuario não encontrado"));
	}
	
	@PostMapping("/users/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public UserModel addComicToUser(@PathVariable("id") Long id, @RequestBody Long comicId) throws Exception {
		Optional<ApiResponseModel> api = responseRepository.findById(comicId);
	    return userRepository.findById(id)
	    	      .map(user -> {
	    	        user.setComics(api);
	    	        return userRepository.save(user);
	    	      })
	    	      .orElseThrow(() -> new Exception("Usuario não encontrado"));
	}
}
