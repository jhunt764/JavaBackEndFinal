package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.models.Post;
import com.example.demo.models.PostRepository;


@RestController
@RequestMapping("/post")
public class PostController {
	
	
	@Autowired
	PostRepository postRepository;

	@GetMapping()
	public List<Post> getPost() {
		return postRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable int id) {
		Post foundPost = postRepository.findById(id).orElse(null);
		if (foundPost == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(foundPost);
	}

	@PostMapping()
	public Post addPost(@RequestBody Post post) {
		postRepository.save(post);
		return post;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Post> removePost(@PathVariable int id) {
		Post foundPost = postRepository.findById(id).orElse(null);
		if (foundPost == null) {
			return ResponseEntity.notFound().build();
		}
		postRepository.delete(foundPost);
		return ResponseEntity.ok(foundPost);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post){
		Post foundPost = postRepository.findById(id).orElse(null);
		if(foundPost == null) {
			return ResponseEntity.notFound().build();
	}
		if(post.getMessage() !=null) {
			foundPost.setMessage(post.getMessage());
		}
		postRepository.save(foundPost);
		return ResponseEntity.ok(foundPost);
	}
}
