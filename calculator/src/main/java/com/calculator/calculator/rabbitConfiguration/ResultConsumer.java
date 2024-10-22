package com.calculator.calculator.rabbitConfiguration;

import com.calculator.calculator.model.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ResultConsumer {

    private static final Logger log = LoggerFactory.getLogger(ResultConsumer.class);

    @RabbitListener(queues = RabbitConfig.DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage(final Operation operation) {
        log.info("Received operation is: {}", operation.toString());
    }
}
