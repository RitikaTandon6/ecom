package com.ecom.ecom.application.Exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String mss)
    {
        super(mss);
    }
}
