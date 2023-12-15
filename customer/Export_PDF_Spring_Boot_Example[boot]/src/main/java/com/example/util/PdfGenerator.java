package com.example.util;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import com.example.entity.Customer; // Changed import
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.FileOutputStream; // Updated import
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class PdfGenerator {

    @Autowired
    private TemplateEngine templateEngine;

    public void generate(Customer customer) throws IOException, DocumentException {
        Context context = new Context();

        context.setVariable("id", customer.getId());
        context.setVariable("name", customer.getCustomerName());
        context.setVariable("address1", customer.getAddress1());
        context.setVariable("address2", customer.getAddress2());
        context.setVariable("policyNumber", customer.getPolicyNumber());
        context.setVariable("renewalDate", customer.getRenewalDate());
        context.setVariable("policyPeriod", customer.getPolicyPeriod());
        context.setVariable("policyType", customer.getPolicyType());
        context.setVariable("premium", customer.getPremium());

        // Add other variables needed for the template


        // Add other variables needed for the template

        String processedHtml = templateEngine.process("temp", context);

        // File path to save the PDF
        String pdfFilePath = "E:\\pdf\\CustomerDetails.pdf";

        // Generate PDF using Flying Saucer
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(processedHtml);
        renderer.layout();

        try (FileOutputStream fos = new FileOutputStream(pdfFilePath)) {
            renderer.createPDF(fos);
        
        }
    }
}
