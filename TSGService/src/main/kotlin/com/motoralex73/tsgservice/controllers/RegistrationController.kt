package com.motoralex73.tsgservice.controllers;

import com.motoralex73.tsgservice.models.Role
import com.motoralex73.tsgservice.models.User
import com.motoralex73.tsgservice.repos.UserRepo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
class RegistrationController {
    @Autowired
    private val userRepo: UserRepo? = null

    @GetMapping("/registration")
    fun registration(): String {
        return "registration"
    }

    @PostMapping("/registration")
    fun addUser(user: User, model: Map<String, Object>) : String {
        val userFromDb: User? = userRepo?.findByUsername(user.getUsername())
        println("REGISTARATION")
        if (userFromDb != null) {
            model.put("person", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}