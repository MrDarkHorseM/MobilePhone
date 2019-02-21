package com.mtx.extend.security;


import com.mtx.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDevice;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@ContextConfiguration(classes = {AppConfig.class})
public class JwtTokenUtilTest {
    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    private static final String TEST_USERNAME = "testUser";

    @Mock
    private Clock clockMock;

    @Test
    @Transactional
    public void generateTokenTest(){
        



    }

    @Test
    @Transactional
    public void testGenerateAudienceInDifferentDevice(){

        Device computer = new LiteDevice();

        final String web = jwtTokenUtil.generateAudience(computer);

        Device mobilePhone = new LiteDevice();

        final String phone = jwtTokenUtil.generateAudience(mobilePhone);

        assertEquals(web, phone);

    }

    @Test
    public void getClaimsFromToken(){







    }

//    @Test
//    public void getCreatedDateFromTokenTest(){
//        final Date now = DateUtil.now();
//        when(clockMock.now()).thenReturn(now);
//        final String token = jwtTokenUtil.generateToken();
//
//        final Date expirationDateFromToken = jwtTokenUtil.getExpirationDateFromToken(token);
//        assertThat(DateUtil.timeDifference(expirationDateFromToken, now)).isCloseTo(3600000L, within(1000L));
//
//    }


    public void validateTokenTest(){





    }

}
