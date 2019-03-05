package com.mtx.config;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.mtx.service.StorageService;
import com.mtx.service.jms.MessageSQSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "com.mtx",
    excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX,pattern="com.mtx.api.*"))
public class AppConfig {
    @Autowired
    private Environment environment;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean(name = "applicationProperties")
    public PropertiesFactoryBean getDbProperties() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        String profile = environment.getActiveProfiles()[0];
        logger.debug("applicationProperties is "+profile);
        bean.setLocation(new ClassPathResource("META-INF/env/application-"+profile+".properties"));
        return bean;
    }

    @Bean(name = "shareProperties")
    public PropertiesFactoryBean getSecretProperties() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("META-INF/file.properties"));
        return bean;
    }

    @Bean
    @Profile({"dev","test"})
    public StorageService getStorageService() {
        AmazonS3 S3 = AmazonS3ClientBuilder.defaultClient();
        StorageService storageService = new StorageService(S3);
        storageService.setBucket("shoeselling");
        return storageService;
    }

    @Bean
    @Profile({"dev"})
    public MessageSQSService getMessageSQSService(){
        AmazonSQS SQS = AmazonSQSClientBuilder.defaultClient();
        MessageSQSService messageSQSService = new MessageSQSService(SQS);
//        messageSQSService.SQS("url","t");
        return messageSQSService;
    }

}
