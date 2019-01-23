package com.mtx.api.v1;


import com.mtx.domain.User;
import com.mtx.extend.RestAuthenticationEntryPoint;
import com.mtx.extend.security.JwtTokenUtil;
import com.mtx.repository.UserRepository;
import com.mtx.service.UserService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping(value = {"/api/users","/api/user"})
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUserList() {
        logger.debug("list users");
        //TODO find users from repository
        return new ArrayList<>();
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public User findById(@PathVariable("Id") Long id) {
        logger.debug("this users id is:" + id);
//        User optional = userService.findById(id);
        return userService.findById(id);
//        if(optional.isPresent()){
//            return optional.get();
//        }else{
//            return null;
//        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User generaterUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"lastName"})
    public List<User> getUserByLastName(@RequestParam(value = "lastName") String lastName) {
        logger.debug("parameter name is " + lastName);
        List<User> user = userService.findByLastname(lastName);
        return user;
//        return userService.findBy(new User(userId)).get();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, params = {"username", "password"})
    public String login(@RequestParam(value = "username") String userName, @RequestParam(value = "password") String password, Device device) {
        logger.debug("username is" + userName);
        logger.debug("password is" + password);
//        final Authentication authentication = authenticationManager.authenticate(notFullyAuthenticated);
        try {
            Authentication notFullyAuthenticated = new UsernamePasswordAuthenticationToken(userName, password);
            final Authentication authentication = authenticationManager.authenticate(notFullyAuthenticated);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            try {
                final UserDetails userDetails = userService.findByEmailOrUsername(userName);
                final String token = jwtTokenUtil.generateToken(userDetails, device);
                return token;
            } catch (NotFoundException e) {
//                logger.error("",e);
//                return ResponseEntity.notFound().build();
            }
        } catch (AuthenticationException ex) {
                logger.debug("dfasdfadsf");
        }
            return null;
        }

    }
