package com.rest.rest.api;


import com.calculator.calculator.model.Result;
import com.rest.rest.service.CalculatorService;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class OperationController {


    private CalculatorService calculatorService;

    public OperationController(CalculatorService calculatorService) {
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
