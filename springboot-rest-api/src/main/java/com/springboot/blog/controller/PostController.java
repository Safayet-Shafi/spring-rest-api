package com.springboot.blog.controller;

import com.springboot.blog.paykoads.PostDto;
import com.springboot.blog.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    //create blog post
    @PostMapping
    public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto){
        try{
            return  new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
       return  new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
    // get all posts rest api
    @GetMapping()
    public List<PostDto> getAllPosts(){
        return  postService.getAllPosts();
    }
    // get post by id rest api
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id")long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }
    //update post by id rest api
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable(name = "id")long id){
         PostDto postResponse = postService.updatePost(postDto,id);
         return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }
    // delete Post rest api
    @DeleteMapping("/{id}")
     public ResponseEntity<String>deletepost(@PathVariable(name="id") long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully",HttpStatus.OK);
    }


}
