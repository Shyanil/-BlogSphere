package com.example.SpringBootBlog.reposetories;

import com.example.SpringBootBlog.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountReposetory extends JpaRepository<Account , Long> {

    Optional<Account> findOneByEmail(String email);

    @Override
    List<Account> findAll();
}
