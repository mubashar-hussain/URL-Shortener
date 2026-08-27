package com.mubashar.urlshortner.customexception;

import com.mubashar.urlshortner.urlController.UrlController;

public class UrlNotFound extends RuntimeException{
    public UrlNotFound(String errorMessage){
        super(errorMessage);

    }
}
