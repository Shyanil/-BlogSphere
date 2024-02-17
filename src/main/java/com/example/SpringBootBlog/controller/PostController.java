package com.example.SpringBootBlog.controller;

import com.example.SpringBootBlog.models.Account;
import com.example.SpringBootBlog.models.Post;
import com.example.SpringBootBlog.service.AccountService;
import com.example.SpringBootBlog.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private AccountService accountService;
    @GetMapping("/posts/{id}") // i have write posts in getmapping becuse in Seeddata i created the the naame  object name
    // posts if i write anything  @GetMapping("/postsssss/{id}") then is i write in web like this with id 1 or 2 then its  print but after touch anything home page its show weball page errr err
    private String getPost(@PathVariable Long id ,Model model){
        // find the post by id
        Optional<Post> optionalPost=postService.getById(id);
        // if post exists then i have show this into model
        if (optionalPost.isPresent()){
            Post post=optionalPost.get();
            model.addAttribute("post",post); // here post becuse post is here object name
            return  "post";
        } else {
            return  "404";
        }
    }
    // here user can add their post after register
    @GetMapping("/posts/new")
    private String newPost(Model model, HttpSession session){ // if dont use t HttpSession then in seed data user@gmail.com alll time logged in
        // if new register login or register they able create a post but then not see their name Written by....
        Account loggedInUser = (Account) session.getAttribute("loggedInUser"); //getAttribute saved data new login user
        if (loggedInUser == null) {
            return "redirect:/registration_error"; // its come from first LoginController then hym page
        }
        else {
            Post post = new Post();
            post.setAccount(loggedInUser); // account set to new user
            model.addAttribute("post", post);
            return "Pots_new";
        }
    }

    @PostMapping("/posts/new")
    private String saveNewPost(@ModelAttribute Post post){
        postService.save(post);
        return  "redirect:/posts/" +  post.getId();
    }
}




