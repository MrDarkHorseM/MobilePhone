package com.mtx.service;

import com.amazonaws.services.s3.AmazonS3;
import com.mtx.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@ContextConfiguration(classes = {AppConfig.class})
public class StorageServiceTest {

//    @Autowired
//    public StorageService storageService;

//    @Test
//    @Transactional
//    public void uploadObjectTest() {
//
//       StorageService s = new StorageService();
//
//       s.uploadObject("/Users/matianxing/Documents/consulting/statconsultinghws2018Fall.pdf", "shoetrade", "myconsultingbucket/statconsultinghws2018Fall.pdf");
//
//    }

//    @Mock
//    private AmazonS3 client = Mockito.mock(AmazonS3.class);

    @Autowired
    public AmazonS3 client;

    @Autowired
    public StorageService storageService;

//    public AmazonS3 client = Mockito.mock(AmazonS3.class);

    @Test
    public void putObjectMockTest(){

        String key="testKey";
        File file=new File("/Users/matianxing/Documents/consulting/statconsultinghws2018Fall.pdf");
        String bucket="shoetrade";
        storageService.putObject(key,file);
        verify(client,times(1)).putObject(bucket, key, file);
        String key2 = null;
        storageService.putObject(key2,file);
        verify(client, times(1)).putObject(bucket, key2, file);
    }

}
