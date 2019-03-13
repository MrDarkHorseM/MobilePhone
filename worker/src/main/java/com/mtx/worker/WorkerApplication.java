package com.mtx.worker;

import com.mtx.worker.service.AsynchronizeService;
import com.mtx.worker.service.SQSMessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WorkerApplication {

//    public static void main(String[] args) {
//        ApplicationContext app = SpringApplication.run(WorkerApplication.class, args);
//        SQSMessageService messageService = app.getBean(SQSMessageService.class);
//        messageService.receiveMessage();
//    }

    public static void  main(String[] args) {
        ApplicationContext app = SpringApplication.run(WorkerApplication.class, args);
        AsynchronizeService asynchronizeService = app.getBean(AsynchronizeService.class);
        asynchronizeService.receiveMessage();

    }

}
