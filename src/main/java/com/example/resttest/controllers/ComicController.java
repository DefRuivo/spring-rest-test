package com.example.resttest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.resttest.feign.ComicClient;
import com.example.resttest.models.ApiResponseModel;
import com.example.resttest.respository.ApiResponseRepository;


@RestController
public class ComicController {
	
	@Value("${env.privateKey}")
	String privateKey;
	@Value("${env.hash}")
	String hash;
	
	@Autowired
	private ComicClient comicClient;
	@Autowired
	private ApiResponseRepository response;

	
	@GetMapping(path="/comics")
	public Iterable<ApiResponseModel> fetchAllComics() {
		return response.findAll();
	}
	
	@PostMapping(path="/comics")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ApiResponseModel addNewComic(@RequestBody Integer id) {
		ApiResponseModel apiResponse = comicClient.fetchApi(id, privateKey, hash);
        return response.save(apiResponse);
	}

	public ApiResponseModel fetchApi(Integer comicId, String privateKey, String hash) {
		return null;
	}
}
