package com.logistics.carrierintegration.controller;

import com.logistics.carrierintegration.dto.InvoiceValidationRequest;
import com.logistics.carrierintegration.model.Invoice;
import com.logistics.carrierintegration.service.InvoiceValidationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceValidationService invoiceValidationService;

    public InvoiceController(InvoiceValidationService invoiceValidationService) {
        this.invoiceValidationService = invoiceValidationService;
    }

    @PostMapping("/validate")
    public Invoice validateInvoice(@Valid @RequestBody InvoiceValidationRequest request) {
        return invoiceValidationService.validateInvoice(request);
    }
}
