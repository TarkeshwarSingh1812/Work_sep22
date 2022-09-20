package com.acc.training.customerapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Customer getCustomer(String customerID) {
        return repo.fetchCustomer(customerID);
    }

    public Customer createCustomer(Customer requestBody) {
        return repo.saveCustomer(requestBody);
    }
}
