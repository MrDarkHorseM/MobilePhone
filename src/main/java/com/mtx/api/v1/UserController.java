package com.mtx.api.v1;


import com.mtx.domain.User;
import com.mtx.repository.UserRepository;
import com.mtx.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
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

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUserList() {
        logger.debug("list users");
        //TODO find users from repository
        return new ArrayList<>();
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public User findById(@PathVariable("Id") Long id){
        logger.debug("this users id is:"+id);
//        User optional = userService.findById(id);
        return userService.findById(id);
//        if(optional.isPresent()){
//            return optional.get();
//        }else{
//            return null;
//        }

    }

    @RequestMapping(method=RequestMethod.POST)
    public User generaterUser(@RequestBody User user) {
        return userService.save(user);
    }


    @RequestMapping(method=RequestMethod.GET,params = {"lastName"})
    public List<User> getUserByLastName(@RequestParam(value = "lastName") String lastName){
        logger.debug("parameter name is " + lastName);
        List<User> user = userService.findByLastname(lastName);
        return user;
//        return userService.findBy(new User(userId)).get();
    }

}
