package com.tracy.ssm.handler;

import com.tracy.ssm.exception.AgeException;
import com.tracy.ssm.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHanlder {

    @ExceptionHandler(NameException.class)
    public ModelAndView nameException(Exception ex) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", ex.getMessage());
        modelAndView.setViewName("exceptionMsg");
        return modelAndView;
    }

    @ExceptionHandler(AgeException.class)
    public ModelAndView ageException(Exception ex) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", ex.getMessage());
        modelAndView.setViewName("exceptionMsg");
        return modelAndView;
    }

    @ExceptionHandler
    public ModelAndView otherException(Exception ex) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", ex.getMessage());
        modelAndView.setViewName("exceptionMsg");
        return modelAndView;
    }
}
