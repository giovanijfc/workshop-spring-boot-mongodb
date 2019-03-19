package com.giovanijfc.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giovanijfc.workshopmongo.domain.Post;
import com.giovanijfc.workshopmongo.resources.util.URL;
import com.giovanijfc.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService postServi;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findAll(@PathVariable String id){
		return ResponseEntity.ok().body(postServi.findById(id));
	}
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue="") String text){
		text = URL.decodeParam(text);
		return ResponseEntity.ok().body(postServi.findByTitle(text));
	}
}
