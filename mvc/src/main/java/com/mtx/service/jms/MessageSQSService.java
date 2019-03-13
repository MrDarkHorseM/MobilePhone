package com.mtx.service.jms;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class MessageSQSService {

    private AmazonSQS sqs;

    private String queueName;

    public MessageSQSService(AmazonSQS SQS,String queueName) {
        this.sqs = SQS;
        this.queueName =queueName;
    }

    public void sendSQSMessage(String messageBody) {
       sendSQSMessage(messageBody,this.queueName);
    }

    public void sendSQSMessage(String messageBody, String queueName) {
        SendMessageRequest sendMsgRequest = new SendMessageRequest()
                .withQueueUrl(getQueueUrl(queueName))
                .withMessageBody(messageBody)
                .withDelaySeconds(5);
        sqs.sendMessage(sendMsgRequest);
    }

    public String getQueueUrl(String queueName){
        String queueUrl = sqs.getQueueUrl(queueName).getQueueUrl();
        return queueUrl;
    }

}
