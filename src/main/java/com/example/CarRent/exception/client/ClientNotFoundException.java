package com.example.CarRent.exception.client;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(Long id) {
        super("Could not find client: "+id);
    }
}
