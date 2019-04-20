package com.feloro.controller;

import com.feloro.service.UserService;
import com.feloro.database.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/user/my")
    public User getCurrentUsr() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.findUserByName(username);
    }

    @PostMapping("/user")
    public User createUser(String username, String password, Integer role) {
        return userService.createUser(username, role, password);
    }

    @GetMapping("/user/{id}")
    public User getInfo(@PathVariable(name="id") UUID uuid) {
        return userService.getUser(uuid);
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();
        session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        for (Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }

        return "logout";
    }
}
