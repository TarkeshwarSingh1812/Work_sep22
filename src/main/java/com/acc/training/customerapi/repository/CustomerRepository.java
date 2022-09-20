package com.acc.training.customerapi.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.acc.training.customerapi.model.Customer;

@Repository
public class CustomerRepository {
    
    private static final Map<String, Customer> customerDB = new HashMap<>();

    static {
        initCustomerDB(); // create one customer upon application start
    }

    private static void initCustomerDB() {
        Customer cust = new Customer();
        cust.setCustomerID("12345");
        cust.setCustomerName("John Doe");
        cust.setCustomerAddress("New York, NY");
        cust.setOfficeCode(BigDecimal.valueOf(45));

        customerDB.put(cust.getCustomerID(), cust);
    }

    public Customer fetchCustomer(String id) {
        return customerDB.get(id);
    }

    public Customer saveCustomer(Customer cust) {
        customerDB.put(cust.getCustomerID(), cust);

        return customerDB.get(cust.getCustomerID());
    }
}
