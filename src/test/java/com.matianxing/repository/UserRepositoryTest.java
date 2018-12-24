package com.matianxing.repository;


import com.mtx.domain.User;
import com.mtx.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration


public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void findByIdTest() {
        User c = new User();
        c.setUsername("toyota");
        c.setFirstname("xle");
        userRepository.save(c);
        Optional<User> testCar = userRepository.findById(c.getId());
        assertNotNull(testCar);
        assertEquals(c.getId(),testCar.get().getId());
    }
}
