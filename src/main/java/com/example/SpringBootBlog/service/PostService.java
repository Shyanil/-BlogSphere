package com.example.SpringBootBlog.service;

import com.example.SpringBootBlog.models.Post;
import com.example.SpringBootBlog.reposetories.PostReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostReposetory postReposetory;
    public Optional<Post> getById(Long id){
        return postReposetory.findById(id);
    } // single blog post with an id click into one single post
    public List<Post> getAll(){
        return postReposetory.findAll();
    } // retrieve all the blog post from data base or or Post.java


    public Post save(Post post){ // this is basic handler for saving the post
        if(post.getId()==null){
            post.setCreatedAt(LocalDateTime.now()); // show when post crated
        }
        return postReposetory.save(post);
    }

}
