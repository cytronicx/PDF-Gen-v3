package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Customer;
import com.example.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepo;

    @Override
    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public List<Customer> getCustomerList() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Optional<Customer> customerOptional = customerRepo.findById((long) customerId);
        return customerOptional.orElse(null);
    }

   
    @Override
    public void updatePolicyRenewalDate(int customerId, String renewalDate) {
        Optional<Customer> customerOptional = customerRepo.findById((long) customerId);
        customerOptional.ifPresent(customer -> {
            customer.setPolicyRenewalDate(renewalDate);
            customerRepo.save(customer);
        });
    }

    @Override
    public void updatePolicyPeriod(int customerId, String policyPeriod) {
        Optional<Customer> customerOptional = customerRepo.findById((long) customerId);
        customerOptional.ifPresent(customer -> {
            customer.setPolicyPeriod(policyPeriod);
            customerRepo.save(customer);
        });
    }

    @Override
    public void updatePolicyType(int customerId, String policyType) {
        Optional<Customer> customerOptional = customerRepo.findById((long) customerId);
        customerOptional.ifPresent(customer -> {
            customer.setPolicyType(policyType);
            customerRepo.save(customer);
        });
    }

    @Override
    public void updatePremium(int customerId, double premium) {
        Optional<Customer> customerOptional = customerRepo.findById((long) customerId);
        customerOptional.ifPresent(customer -> {
            customer.setPremium(premium);
            customerRepo.save(customer);
        });
    }
}
