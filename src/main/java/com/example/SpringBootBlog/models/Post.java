package com.example.SpringBootBlog.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
    private LocalDateTime createdAt;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "account_id" , referencedColumnName = "id", nullable = false) // its basically join Acounnt java to posts java using id
    private Account account;
}
