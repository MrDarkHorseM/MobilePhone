package com.mtx.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.xspec.NULL;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;


public class StorageService {

    private AmazonS3 s3;

    private String bucket;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public StorageService(AmazonS3 s3) {
        this.s3 = s3;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public void uploadObject(String filePath, String bucketName, String fileObjKeyName) {
        System.out.format("Uploading %s to S3 bucket %s...\n", filePath, bucketName);
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        try {
            s3.putObject(bucketName, fileObjKeyName, new File(filePath));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            logger.error("error");
//            System.exit(1);
        }
    }

//    public static void main(String[] args){
//
//        StorageService s = new StorageService();
//
//        s.uploadObject("/Users/matianxing/Documents/consulting/statconsultinghws2018Fall.pdf", "shoetrade", "myconsultingbucket/statconsultinghws2018Fall.pdf");
//
//    }

    public void putObject(String S3key, File file) {
        s3.putObject(bucket, S3key, file);
    }

    public void putObejct(String bucket, String S3key, File file){
        s3.putObject(bucket, S3key, file);
    }

    public S3Object getObject(String S3key){
        if(S3key == null){
            return null;
        }else{
            return s3.getObject(bucket, S3key);
        }
    }

    public S3Object getObject(String bucket, String S3key){
        return s3.getObject(bucket, S3key);
    }




}
