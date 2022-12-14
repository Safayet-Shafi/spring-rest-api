package com.springboot.blog.services;

import com.springboot.blog.paykoads.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto>getAllPosts();

    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto,long id);
    void deletePostById (long id);

}
