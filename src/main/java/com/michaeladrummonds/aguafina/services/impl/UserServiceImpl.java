package com.michaeladrummonds.aguafina.services.impl;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.michaeladrummonds.aguafina.models.User;
import com.michaeladrummonds.aguafina.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(email);
        if (null == user) {
            throw new UsernameNotFoundException("Cannot find user with email: " + email);
        }
        return user;
    }

    public void createNewUser(User user) {
        userRepository.save(user);
    }

}
