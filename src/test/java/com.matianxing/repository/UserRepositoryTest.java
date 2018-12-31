package com.matianxing.repository;


import com.mtx.config.AppConfig;
import com.mtx.domain.User;
import com.mtx.repository.UserRepository;
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
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void findByIdTest() {
        User k = new User();
        k.setUsername("yeezy");
        k.setFirstname("mafia");
        User save = userRepository.save(k);
        Optional<User> testShoe = userRepository.findById(k.getId());
        assertNotNull(testShoe);
        assertEquals(k.getId(),testShoe.get().getId());
    }


   // findByEmailOrUsernamelikeTest
}
