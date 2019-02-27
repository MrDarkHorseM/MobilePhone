package com.mtx.service;

import com.amazonaws.services.directory.model.ServiceException;
import com.amazonaws.services.rekognition.model.S3Object;
import com.mtx.domain.Image;
import com.mtx.repository.ImageRepository;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    public ImageRepository imageRepository;

    @Autowired
    public StorageService storageService;


    private final Logger logger = LoggerFactory.getLogger(getClass());



//    @Transactional
//    public Image saveFakeImage(MultipartFile multipartFile, boolean isPublic) throws ServiceException {
//        if (multipartFile == null || multipartFile.isEmpty()) throw new ServiceException("File must not be null!");
//        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
//        String homeDir = System.getProperty("catalina.base") !=null ? System.getProperty("catalina.base") : "/tmp/";
//        Image image = new Image();
//        String s3Key = FilenameUtils.getBaseName(multipartFile.getOriginalFilename()) + "_"+image.getUuid()+"."+extension;
//        File localFile = new File(homeDir + s3Key);
//        try {
//            multipartFile.transferTo(localFile);
//            storageService.putObject(s3Key,localFile);
//            S3Object s3Object = storageService.getObject(s3Key);
//            image.setUrl(storageService.getObjectUrl(s3Object.getKey()));
////            image.setExtension(extension);
//            return image;
//        } catch (IOException e) {
//            logger.warn("can't find image file");
//        }
//        return null;
//    }






}
