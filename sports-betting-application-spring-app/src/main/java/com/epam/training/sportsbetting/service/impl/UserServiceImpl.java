package com.epam.training.sportsbetting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.epam.training.sportsbetting.domain.user.User;
import com.epam.training.sportsbetting.repository.UserRepository;
import com.epam.training.sportsbetting.service.UserService;
import com.google.common.collect.Lists;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }


    @Override
    public void registerUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // user.setRoles(Collections.singleton(Role.getDefaultRoleInstance()));
        userRepository.save(user);
    }


    @Override
    public User obtainCurrentPrincipleUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(userDetails.getUsername());
    }

}


//    public static User getDefaultInspectorInstance() {
////        if (defaultInspectorByRegistrationInstance == null) {
////            synchronized (User.class) {
////                if (defaultInspectorByRegistrationInstance == null) {
////                    defaultInspectorByRegistrationInstance = new User();
////                    defaultInspectorByRegistrationInstance.setId(1L);
////                }
////            }
////        }
////        return defaultInspectorByRegistrationInstance;
////    }
