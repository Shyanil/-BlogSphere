package com.example.SpringBootBlog.controller;

import com.example.SpringBootBlog.models.Account;
import com.example.SpringBootBlog.reposetories.AccountReposetory;
import com.example.SpringBootBlog.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountReposetory accountReposetory;
//   Note ("/....") IN ONE PAGE I CAN USE ONE TIME @GetMapping  or @PostMapping
    @GetMapping("/login")
    public String getLogin(Model model) {

        model.addAttribute("account", new Account());
        return "login";
    }



    @PostMapping("/login")
    public String RedirectFromLogin(@ModelAttribute("blogapp") Account account, Model model, HttpSession session) {
        Optional<Account> optionalAccount = accountService.findByEmail(account.getEmail());
        if (optionalAccount.isPresent() && optionalAccount.get().getPassword().equals(account.getPassword())) {
            session.setAttribute("loggedInUser", optionalAccount.get());
            accountReposetory.save(account);
            model.addAttribute("message", "Hi " + optionalAccount.get().getFirstname() + ". Now click the Ready to Tour button. We are waiting for your new post.");
            return "login"; // Redirect to the home page
        }
         else {
            return "redirect:/login-error";
        }
    }


    // i have to do this i  want to redirect user this html page
    @GetMapping("/login-error")
    public String loginError() {
        return "/login-error";
    }
    // i have to do this i  want to redirect user this html page
    @GetMapping("/registration_error")
    public String registrationError() {
        return "/registration_error";
    }
}