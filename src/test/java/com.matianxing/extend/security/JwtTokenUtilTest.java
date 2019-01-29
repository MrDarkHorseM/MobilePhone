package com.matianxing.extend.security;


import com.mtx.config.AppConfig;
import com.mtx.extend.security.JwtTokenUtil;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@ContextConfiguration(classes = {AppConfig.class})
public class JwtTokenUtilTest {
    @Autowired
    public JwtTokenUtil jwtTokenUtil;











}
