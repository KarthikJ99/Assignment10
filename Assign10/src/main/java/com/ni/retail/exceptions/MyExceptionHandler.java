package com.ni.retail.exceptions;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.validation.*;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String hander(MethodArgumentNotValidException ex, Model model) {
        // model.addAttribute("exceptionMessage", ex.getMessage());
        // return "error.html";

        int i=0;
        List<ObjectError> errorsList = ex.getBindingResult().getAllErrors();
        String[] msgs = new String[errorsList.size()];
        
       for(ObjectError error: errorsList) {
            String errorMessage = error.getDefaultMessage();
            msgs[i]=errorMessage;
            i++;
        };

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach( (error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        


        model.addAttribute("errors", errors);

        model.addAttribute("msgs", msgs);
        model.addAttribute("dummyVar", 100);
        return "error.html";
    }

  

}