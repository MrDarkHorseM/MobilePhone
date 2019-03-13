package com.mtx.api.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtx.service.jms.MessageSQSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value = {"/api/message","/api/messages"})
public class MessageSQSController {

    @Autowired
    private MessageSQSService messageSQSService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value="/{id}",method = RequestMethod.POST)
    public Boolean sendSQSMessage(@PathVariable("id") Long messageId, @RequestParam("messageInfo") String messageInfo){

        logger.info("send fake message to Amazon sqs");

        String jsonString;

        String queueName = "kevin_dev";

        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> map = new HashMap<>();
        map.put("messageId", messageId.toString());
        map.put("messageInfo", messageInfo);

        try{
            jsonString = mapper.writeValueAsString(map);

            messageSQSService.sendSQSMessage(jsonString, queueName);


        } catch(JsonProcessingException e){

            logger.error("error message",e);

        }

     return null;
    }


}
