package com.lcwr.user.service.exceptions;


import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResourceNotFoundException extends  RuntimeException{


    public  ResourceNotFoundException()
    {
        super("resource not found on server");
    }


public  ResourceNotFoundException (String message)
{

    super(message);
}


}
