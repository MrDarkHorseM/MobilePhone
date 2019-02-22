package com.mtx.api.v1;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value = {"/api/images","/api/image"})
public class MiscController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, String> uploadPicture(@RequestParam(value = "pic") MultipartFile pic) {

        Map<String, String> result = new HashMap<>(1);
//        result.put("s3.url", "s3.url");
        try{

        }catch(ServiceException e){

        }
        return result;

    }
}
