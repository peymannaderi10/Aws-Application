package com.peymanapp.springbootawssqsexe;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class})
@RestController
public class SpringbootAwsSqsExeApplication {
    Logger logger = LoggerFactory.getLogger(SpringbootAwsSqsExeApplication.class);

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    @GetMapping
    public void sendMessageToQueue() throws JsonProcessingException {

        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        String json = new ObjectMapper().writeValueAsString(map);
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(json).build());
    }
    @SqsListener("peyman-queue") //ENTER QUEUE NAME HERE
    public void loadMessageFromSQS(String message){
        logger.info("message from SQS Queue {}",message);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsSqsExeApplication.class, args);
    }

}
