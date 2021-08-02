package com.example.resttest.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.resttest.models.ApiResponseModel;

@Repository
public interface ApiResponseRepository extends CrudRepository<ApiResponseModel, Long> {
	
}
