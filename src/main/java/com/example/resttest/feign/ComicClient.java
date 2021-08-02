package com.example.resttest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.resttest.models.ApiResponseModel;

// https://gateway.marvel.com/v1/public/comics/2?ts=1&apikey=63789d0844b4bd7cba31827f59efebe4&hash=c0198a8e92a8fb0c6580619909cfcf2e


@FeignClient(name="comicRequest", 
url="https://gateway.marvel.com/v1/public/comics/")
public interface ComicClient {
	
	@GetMapping("{comicId}?ts=1&apikey={privateKey}&hash={hash}")
	public ApiResponseModel fetchApi(@PathVariable("comicId") Integer comicId, 
			@PathVariable("privateKey") String privateKey, 
			@PathVariable("hash") String hash);
}
