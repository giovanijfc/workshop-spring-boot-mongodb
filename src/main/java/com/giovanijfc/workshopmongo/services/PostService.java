package com.giovanijfc.workshopmongo.services;

import java.util.Date;
import java.util.List;

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
	
	public List<Post> findByTitle(String text) {
		return postRepo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepo.fullSearch(text, minDate, maxDate);
	}
}
	