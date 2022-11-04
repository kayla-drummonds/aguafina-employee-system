package com.michaeladrummonds.aguafina.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.michaeladrummonds.aguafina.models.User;

@Component
public interface UserService extends UserDetailsService {
    User save(User user);
}
