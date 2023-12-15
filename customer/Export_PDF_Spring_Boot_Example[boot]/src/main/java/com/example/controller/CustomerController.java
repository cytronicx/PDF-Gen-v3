package com.example.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Customer; // Updated import
import com.example.service.CustomerService; // Updated import
import com.example.util.PdfGenerator;

@RestController
public class CustomerController {
    
    @Autowired
    private CustomerService customerService; // Updated service

    @Autowired
    private PdfGenerator pdfGenerator;

    @GetMapping("/export-to-pdf")
    public void generatePdfFile(@RequestParam("customerId") int customerId, HttpServletResponse response) throws IOException 
    {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) 
        {
            pdfGenerator.generate(customer);
            return; // PDF generated, exit the method
        }

        // Handle the case when the customer is not found or other issues
        response.getWriter().println("Unable to generate PDF. Invalid user input or customer not found.");
    }
}
