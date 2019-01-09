package com.mtx.service;

import com.mtx.domain.User;
import com.mtx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
//        List<User> users = Lists.newArrayList(userRepository.findAll());
        return userRepository.findAll();
    }

    public User findById(Long Id){
        return userRepository.findById(Id).get();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> findByLastname(String lastname){
        return userRepository.findByLastname(lastname);
    }

    public List<User>findByFirstname(String firstname){
        return userRepository.findByFirstname(firstname);
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

//    public Optional<User> findById(Long id){
//        return userRepository.findById(id);
//    }

}
