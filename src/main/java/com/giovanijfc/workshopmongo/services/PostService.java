package com.giovanijfc.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovanijfc.workshopmongo.domain.Post;
import com.giovanijfc.workshopmongo.repository.PostRepository;
import com.giovanijfc.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepo;
	
	public Post findById(String id) {
		Post post = postRepo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
		return post;
	}
	
}
	