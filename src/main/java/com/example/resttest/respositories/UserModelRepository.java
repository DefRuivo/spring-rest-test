package com.example.resttest.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.resttest.models.UserModel;

@Repository
public interface UserModelRepository extends CrudRepository<UserModel, Long> {
	
}
