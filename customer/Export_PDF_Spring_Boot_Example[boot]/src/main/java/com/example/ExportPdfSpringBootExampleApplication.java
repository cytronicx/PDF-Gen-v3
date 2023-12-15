package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.entity.Customer;
import com.example.service.CustomerService;

@SpringBootApplication
public class ExportPdfSpringBootExampleApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(ExportPdfSpringBootExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack"};
        String[] emails = {"alice@example.com", "bob@example.com", "charlie@example.com", "david@example.com",
                            "emma@example.com", "frank@example.com", "grace@example.com", "henry@example.com",
                            "ivy@example.com", "jack@example.com"};
        String[] phoneNumbers = {"1111111111", "2222222222", "3333333333", "4444444444", "5555555555", 
                                "6666666666", "7777777777", "8888888888", "9999999999", "1234567890"};
        String[] addresses1 = {"Address1_A", "Address1_B", "Address1_C", "Address1_D", "Address1_E",
                                "Address1_F", "Address1_G", "Address1_H", "Address1_I", "Address1_J"};
        String[] addresses2 = {"Address2_A", "Address2_B", "Address2_C", "Address2_D", "Address2_E",
                                "Address2_F", "Address2_G", "Address2_H", "Address2_I", "Address2_J"};
        String[] policyNumbers = {"Policy1", "Policy2", "Policy3", "Policy4", "Policy5", 
                                "Policy6", "Policy7", "Policy8", "Policy9", "Policy10"};
        String[] policyRenewalDates = {"2023-12-01", "2023-12-05", "2023-12-10", "2023-12-15", "2023-12-20",
                                        "2023-12-25", "2023-12-30", "2023-12-31", "2024-01-01", "2024-01-05"};
        String[] policyPeriods = {"1 year", "6 months", "2 years", "1 year", "3 years", 
                                    "1 year", "2 years", "1 year", "1 year", "6 months"};
        String[] policyTypes = {"Type1", "Type2", "Type3", "Type4", "Type5", 
                                "Type6", "Type7", "Type8", "Type9", "Type10"};
        double[] premiums = {1000.0, 1500.0, 2000.0, 1200.0, 2500.0, 
                                1800.0, 3000.0, 1400.0, 1600.0, 2200.0};

        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setCustomerName(names[i]);
            customer.setEmail(emails[i]);
            customer.setMobileNo(phoneNumbers[i]);
            customer.setAddress1(addresses1[i]);
            customer.setAddress2(addresses2[i]);
            customer.setPolicyNumber(policyNumbers[i]);
            customer.setPolicyRenewalDate(policyRenewalDates[i]);
            customer.setPolicyPeriod(policyPeriods[i]);
            customer.setPolicyType(policyTypes[i]);
            customer.setPremium(premiums[i]);
            customerService.addCustomer(customer);
        }
    }
}
