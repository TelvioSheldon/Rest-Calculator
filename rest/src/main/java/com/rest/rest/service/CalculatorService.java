package com.rest.rest.service;


import com.calculator.calculator.model.ExpectedResult;
import com.calculator.calculator.model.Operation;
import com.calculator.calculator.model.Result;
import com.calculator.calculator.model.UnexpectedResult;
import com.rest.rest.rabbitConfiguration.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@Service
public class CalculatorService {

    private final RabbitTemplate rabbitTemplate;

    private static final Logger log = LoggerFactory.getLogger(Operation.class);


    @Autowired
    public CalculatorService(final RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }



    public Result calculate(HttpServletResponse response, String operationType, float firstValue, float secondValue){

        Result result;

        if( operationType.equalsIgnoreCase("div") && secondValue==0){
            result =  new UnexpectedResult("Nao e' possivel efectuar uma divisao por zero(0) em R");
        }


        else{
            Operation operation = new Operation(operationType, firstValue, secondValue);

            result = new ExpectedResult(operation.getResult());
        }

        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY, new Operation(operationType,firstValue,secondValue));
        response.setHeader("Identificador unico", new UUID(System.currentTimeMillis(), System.currentTimeMillis()).toString());
        return result;


    }

}
