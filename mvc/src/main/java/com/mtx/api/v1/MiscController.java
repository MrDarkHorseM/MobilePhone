package com.mtx.api.v1;

import com.amazonaws.services.s3.model.S3KeyFilter;
import com.mtx.service.StorageService;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value = {"/api/images","/api/image"})
public class MiscController {

    @Autowired
    private StorageService storageService;

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, URL> uploadPicture(@RequestParam(value = "pic") MultipartFile files) {

        Map<String, URL> result = new HashMap<>(1);
        String homeDir = System.getProperty("catalina.base") !=null ? System.getProperty("catalina.base") : "/tmp"; //if else short hand
        String s3key = files.getOriginalFilename();
        File localFile = new File(homeDir + s3key);
//        result.put("s3.url", "s3.url");
        try{
            files.transferTo(localFile);
        }catch(IOException e){
            logger.error("error on saving record",e);
        }

        storageService.putObject(s3key, localFile);
        URL s3Url = storageService.getURL(s3key);
        result.put("s3Url", s3Url);

        return result;
    }
}
