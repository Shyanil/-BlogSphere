package com.example.SpringBootBlog.controller;

import com.example.SpringBootBlog.models.Post;
import com.example.SpringBootBlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private PostService postService;
    @GetMapping("/")
    public String home(Model model){
        List<Post> posts=postService.getAll(); // get all the post data from databse or Post.java
        model.addAttribute("posts",posts); // here posts becuase its come from seed data
        return  "home";
    }
}
