package com.mtx.service;

import com.mtx.domain.Authority;
import com.mtx.domain.User;
import com.mtx.enumdef.AuthorityRole;
import com.mtx.repository.AuthorityRepository;
import com.mtx.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private AuthorityService authorityService;

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

    public User findByUsername(String username){
        User result = userRepository.findByUsername(username);
        return result;
    }

    public List<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

//    public Optional<User> findById(Long id){
//        return userRepository.findById(id);
//    }

    public User findByEmailOrUsername(String keyword) throws NotFoundException, NullPointerException {
        if (keyword == null || "".equals(keyword.trim())){
            throw new NullPointerException();
        }
        User user = userRepository.findByEmailIgnoreCase(keyword);
        if (user == null){
            user = userRepository.findByUsernameIgnoreCase(keyword);
        }
        if (user == null){
            throw new NotFoundException(keyword);
        }
        return user;
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Transactional
    public User createUser(User newUser) {
        String encodedPass = encoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPass);

        addAuthority(newUser, AuthorityRole.ROLE_REGISTERD_USER);
        User result=userRepository.save(newUser);
        return save(newUser);
    }

    @Transactional
    public Authority addAuthority(User user, String authorityString) {
        Authority userAuthority = new Authority(user, authorityString);
        return authorityRepository.save(userAuthority);
    }

    public List<Authority> findAuthorities(User user){
        return authorityService.findAuthoritiesByUserId(user.getId());
    }

}
