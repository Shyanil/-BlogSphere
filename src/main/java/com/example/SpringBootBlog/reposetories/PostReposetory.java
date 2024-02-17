package com.example.SpringBootBlog.reposetories;

import com.example.SpringBootBlog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReposetory extends JpaRepository<Post,Long> {
}
