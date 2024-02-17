package com.example.SpringBootBlog.Config;

import com.example.SpringBootBlog.models.Account;
import com.example.SpringBootBlog.models.Post;
import com.example.SpringBootBlog.service.AccountService;
import com.example.SpringBootBlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner { // important
    @Autowired
    private PostService postService;
    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts=postService.getAll(); // grab all the data from database or or Post.java
        if(posts.size()==0){ // there is 0 post basically   or total.size id 0
            // this data store in my database if no post created
            Account account1=new Account();
            account1.setFirstname("Default user.");
            account1.setLastname("user");
            account1.setEmail("user@gmail.com");
            account1.setPassword("user1");

            Account account2=new Account();
            account2.setFirstname("Admin");
            account2.setLastname("admin");
            account2.setEmail("admin@gmail.com");
            account2.setPassword("admin1");

            accountService.save(account1);
            accountService.save(account2);

            Post post1=new Post();
            post1.setTitle("This Is a Default Post .");
            post1.setBody("Here this is post body whatever you want write");
            post1.setAccount(account1);
            Post post2=new Post();
            post2.setTitle("This Post Created by The Admin");
            post2.setBody("Hi my name is Shyanil Mishra. Thanks for coming to BlogSphere. I hope you enjoy it here. I created this project using Java, HTML, and CSS. You must be a registered user for your new post.... Thank You");
            post2.setAccount(account2);
            postService.save(post1);
            postService.save(post2);
        }

    }
}
