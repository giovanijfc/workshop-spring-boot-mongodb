package com.giovanijfc.workshopmongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovanijfc.workshopmongo.domain.User;
import com.giovanijfc.workshopmongo.dto.UserDTO;
import com.giovanijfc.workshopmongo.repository.UserRepository;
import com.giovanijfc.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<UserDTO> findAll(){
		List<User> list = userRepo.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return listDto;
	}
	
	public User findById(String id) {
		User user = userRepo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
		return user;
	}
}
