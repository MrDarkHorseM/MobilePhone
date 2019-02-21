package com.mtx.extend.security;

import com.mtx.domain.Authority;
import com.mtx.domain.User;
import com.mtx.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDetailServicelmpl implements UserDetailsService {

    @Autowired
    private UserService userService;

//    private User user;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailServicelmpl.class);

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username){

        User domainUser = null;
        try{
            domainUser = userService.findByUsername(username);
        }catch (Exception repositoryProblem) {
            logger.debug("catch AuthenticationServiceException from AuthenticationProvider");
        }
        List<Authority> userAuthorities = userService.findAuthorities(domainUser);
        domainUser.setAuthorities(userAuthorities);
        return domainUser;
    }

}
