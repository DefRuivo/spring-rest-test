package com.example.resttest.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.resttest.models.ApiResponseModel;

@Repository
public interface ApiResponseRepository extends CrudRepository<ApiResponseModel, Long> {
	
}
