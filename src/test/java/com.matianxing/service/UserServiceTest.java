package com.matianxing.service;

import com.mtx.config.AppConfig;
import com.mtx.domain.User;

import com.mtx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@ContextConfiguration(classes = {AppConfig.class})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void findByIdTest() {
        User k = new User();
        k.setUsername("yeezy");
        k.setFirstname("mafia");
        k.setEmail("mtx1234@gmail.com");
        k.setPassword("123456");
        userService.save(k);
        User testUser = userService.findById(k.getId());
        assertNotNull(testUser);
        assertEquals(k.getId(),testUser.getId());
    }
}
