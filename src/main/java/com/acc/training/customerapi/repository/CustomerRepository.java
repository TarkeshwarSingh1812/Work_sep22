package com.acc.training.customerapi.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.acc.training.customerapi.model.Customer;

@Repository
public class CustomerRepository {

    private static final Map<String, Customer> customerDB = new HashMap<>();

    static{
        initCustomerDB();
    }

    private static void initCustomerDB() {
        Customer cust = new Customer();
        cust.setCustomerId("12345");
        cust.setCustomerName("Sandeep Patil");
        cust.setCustomerAddress("Manchester, USA");
        cust.setOfficeCode(BigDecimal.valueOf(045));

        customerDB.put(cust.getCustomerId(), cust);


    }

    public Customer fetchCustomer(String id){
        return customerDB.get(id);
    }

    public Customer saveCustomer(Customer customerObj){
        customerDB.put(customerObj.getCustomerId(), customerObj);
        return customerDB.get(customerObj.getCustomerId());
    }
    
}
