package com.example.SpringBootBlog.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // the names must be same in register.html
    private  Long id;
    private String password;
    private  String email;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "account") // each user has own set on blog post
    private List<Post> posts; // i have to add model packages classes private before list
}
