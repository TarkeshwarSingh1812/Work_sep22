package com.acc.training.customerapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.acc.training.customerapi.api.CustomerApi;
import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.service.CustomerService;

@RestController
public class CustomerController implements CustomerApi {

    @Autowired
    private CustomerService service;

    private static final Integer MIN_ID = 10000; // minLength for customerID is 5 digits
    private static final Integer MAX_ID = 9999999; // maxLength for customerID is 8 digits

    @Override
    public ResponseEntity<Customer> createCustomer(@Valid Customer body) {
        // TODO: Check that the name isn't null

        if (body.getCustomerName() == null || body.getCustomerName().equals("")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // TODO: Check that the id length is valid

        if (Integer.valueOf(body.getCustomerID()) < MIN_ID || Integer.valueOf(body.getCustomerID()) > MAX_ID) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Customer response = service.createCustomer(body);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<Customer> getCustomer(String id) {
        // TODO: Check that the id length is valid

        if (Integer.valueOf(id) < MIN_ID || Integer.valueOf(id) > MAX_ID) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Customer response = service.getCustomer(id);

        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
}
