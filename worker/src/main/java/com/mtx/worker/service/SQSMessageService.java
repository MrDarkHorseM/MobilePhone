package com.mtx.worker.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SQSMessageService {

    private AmazonSQS sqs;

    public SQSMessageService(){
        sqs = AmazonSQSClientBuilder.standard().withRegion("us-east-2").build();
    }

    private String queueName="kevin_dev";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void receiveMessage(){

        logger.info("Trying to receive message from Amazon: " + queueName);

        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(getQueueUrl(queueName));

        receiveMessageRequest.setMaxNumberOfMessages(1);

        List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();

        for (Message message : messages){

            System.out.println(queueName);

            System.out.println("Got messages");

            System.out.println("Message Id" + message.getMessageId());

            System.out.println("Message Body" + message.getBody());

            System.out.println("Message Attributes" + message.getAttributes());

        }
    }

    public String getQueueUrl(String queueName){
        String queueUrl = sqs.getQueueUrl(queueName).getQueueUrl();
        return queueUrl;
    }


}
