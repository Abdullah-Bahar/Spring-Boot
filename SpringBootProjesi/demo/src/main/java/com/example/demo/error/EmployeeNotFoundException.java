package com.example.demo.error;

import java.io.IOException;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String msgError)
    {
        super(msgError);
    }
}
