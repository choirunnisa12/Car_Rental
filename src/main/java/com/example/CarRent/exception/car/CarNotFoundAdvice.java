package com.example.CarRent.exception.car;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class CarNotFoundAdvice {

    @ResponseBody
   @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String carNotFoundHandler(CarNotFoundException ex) {
        return ex.getMessage();
    }

}
