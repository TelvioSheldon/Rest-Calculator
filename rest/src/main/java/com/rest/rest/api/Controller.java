package com.rest.rest.api;


import com.consumer.consumer.model.Result;
import com.producer.producer.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@Controller
@RequestMapping("/")
public class Controller {


    private CalculatorService calculatorService;

    public ResultProducer(CalculatorService calculatorService) {
        this.calculatorService=calculatorService;

    }

    public String index(){

        return "index";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("{operationType}")
    public Result calculate(
            HttpServletResponse response,
            @PathVariable("operationType") String operationType,
            @RequestParam(required = true) float a,
            @RequestParam(required = true) float b)
    {

        return calculatorService.calculate(response, operationType, a, b);
    }



}
