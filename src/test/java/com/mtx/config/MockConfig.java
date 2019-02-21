package com.mtx.config;

import com.amazonaws.services.s3.AmazonS3;
import com.mtx.service.StorageService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MockConfig {


    @Bean
    public AmazonS3 amazonS3(){
        AmazonS3 client = Mockito.mock(AmazonS3.class);
        return client;
    }

    @Bean
//    @Primary
    @Profile("unit")
    public StorageService getStorageService(@Autowired AmazonS3 client){
//        AmazonS3 client = Mockito.mock(AmazonS3.class);
        StorageService storageService = new StorageService(client);
        storageService.setBucket("shoetrade");
        return storageService;
    }

}
