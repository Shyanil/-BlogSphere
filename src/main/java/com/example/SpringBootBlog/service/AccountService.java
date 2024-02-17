package com.example.SpringBootBlog.service;

import com.example.SpringBootBlog.models.Account;
import com.example.SpringBootBlog.reposetories.AccountReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountReposetory accountReposetory;
    public Account save(Account account){
       return accountReposetory.save(account);
    }


    public Optional<Account> findByEmail(String email) {
        return accountReposetory.findOneByEmail(email);
    }
    public List<Account> findAllAccounts() {
        return accountReposetory.findAll();
    }
}

