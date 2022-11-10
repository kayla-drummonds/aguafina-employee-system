package com.michaeladrummonds.aguafina.services.impl;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.michaeladrummonds.aguafina.models.Role;
import com.michaeladrummonds.aguafina.models.User;
import com.michaeladrummonds.aguafina.models.UserRegistrationDto;
import com.michaeladrummonds.aguafina.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

    public User saveUser(UserRegistrationDto registrationDto) {
        User user = new User();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRoles(Arrays.asList(new Role("USER")));
        return userRepository.save(user);
    }

    public User saveAdmin(UserRegistrationDto registrationDto) {
        User user = new User();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRoles(Arrays.asList(new Role("USER"), new Role("ADMIN")));
        return userRepository.save(user);
    }
}
