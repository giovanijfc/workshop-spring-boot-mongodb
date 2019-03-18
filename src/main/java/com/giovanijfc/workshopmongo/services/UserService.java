package com.giovanijfc.workshopmongo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovanijfc.workshopmongo.domain.User;
import com.giovanijfc.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll(){
		List<User> list = new ArrayList<>();
		list = userRepo.findAll();
		return list;
	}
}
