package com.mtx.worker.service;

import com.amazon.sqs.javamessaging.*;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

@Service
public class AsynchronizeService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String region = "us-east-2";

    private String queueName = "kevin_dev";

    // Create the connection.
    private SQSConnection connection;

    private SQSQueueDestination sqsQueueDestination;

    public void receiveMessage(){

        logger.info("Trying to receive message from Amazon: " + queueName);

        // Create a new connection factory with all defaults (credentials and region) set automatically
        SQSConnectionFactory connectionFactory = new SQSConnectionFactory(
                new ProviderConfiguration(),
                AmazonSQSClientBuilder.standard()
                        .withRegion(region)
                        .build()
        );

        try {
            connection = connectionFactory.createConnection();

            // Get the wrapped client
            AmazonSQSMessagingClientWrapper client = connection.getWrappedAmazonSQSClient();

            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

            // Create an SQS queue named MyQueue, if it doesn't already exist
            if (!client.queueExists(queueName)) {
                session.createQueue(queueName);
            }

            // Create a consumer for the 'MyQueue'.
//            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(session.createQueue(queueName));

            // Instantiate and set the message listener for the consumer.
            consumer.setMessageListener(new MyListener());

            // Start receiving incoming messages.
            connection.start();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }


}





