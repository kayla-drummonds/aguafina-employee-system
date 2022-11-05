package com.michaeladrummonds.aguafina.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.michaeladrummonds.aguafina.models.Role;
import com.michaeladrummonds.aguafina.models.User;
import com.michaeladrummonds.aguafina.services.impl.UserServiceImpl;

@Controller
@RequestMapping
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public UserController(UserServiceImpl userService, BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @GetMapping("/registration")
    public String createNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@RequestParam Map<String, String> body) {
        User user = new User();
        Role role = new Role();
        role.setName("USER");
        Collection<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setFirstName(body.get("firstName"));
        user.setLastName(body.get("lastName"));
        user.setEmail(body.get("email"));
        user.setPassword(encoder.encode(body.get("password")));
        user.setRoles(roles);
        userService.createNewUser(user);
        return "redirect:/registration?success";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
        session.setAttribute("SPRING_SECURITY_LAST_EXCEPTION", request);
        return "login";
    }

    @GetMapping("/logout-success")
    public String getLogoutPage(Model model) {
        return "logout";
    }
}
