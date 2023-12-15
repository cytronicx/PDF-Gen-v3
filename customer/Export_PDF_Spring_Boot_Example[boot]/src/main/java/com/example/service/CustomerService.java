package com.example.service;

import java.util.List;

import com.example.entity.Customer;

public interface CustomerService {

    void addCustomer(Customer customer);

    List<Customer> getCustomerList();

    Customer getCustomerById(int customerId);

    
    void updatePolicyRenewalDate(int customerId, String renewalDate);

    void updatePolicyPeriod(int customerId, String policyPeriod);

    void updatePolicyType(int customerId, String policyType);

    void updatePremium(int customerId, double premium);
    
}
