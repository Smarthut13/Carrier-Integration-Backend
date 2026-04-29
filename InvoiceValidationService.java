package com.logistics.carrierintegration.service;

import com.logistics.carrierintegration.dto.InvoiceValidationRequest;
import com.logistics.carrierintegration.exception.ResourceNotFoundException;
import com.logistics.carrierintegration.model.Invoice;
import com.logistics.carrierintegration.model.Shipment;
import com.logistics.carrierintegration.repository.InvoiceRepository;
import com.logistics.carrierintegration.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InvoiceValidationService {

    private final ShipmentRepository shipmentRepository;
    private final InvoiceRepository invoiceRepository;

    public InvoiceValidationService(ShipmentRepository shipmentRepository, InvoiceRepository invoiceRepository) {
        this.shipmentRepository = shipmentRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice validateInvoice(InvoiceValidationRequest request) {
        Shipment shipment = shipmentRepository.findById(request.getShipmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + request.getShipmentId()));

        if (shipment.getExpectedCost() == null) {
            throw new IllegalStateException("Expected shipment cost unavailable. Select carrier before invoice validation.");
        }

        BigDecimal expectedAmount = shipment.getExpectedCost();
        BigDecimal chargedAmount = request.getCarrierChargedAmount();

        boolean matched = expectedAmount.compareTo(chargedAmount) == 0;

        Invoice invoice = new Invoice();
        invoice.setShipment(shipment);
        invoice.setInvoiceNumber(request.getInvoiceNumber());
        invoice.setExpectedAmount(expectedAmount);
        invoice.setCarrierChargedAmount(chargedAmount);
        invoice.setMatched(matched);
        invoice.setValidationMessage(matched
                ? "Invoice matched expected shipment cost"
                : "Invoice mismatch detected. Expected " + expectedAmount + " but carrier charged " + chargedAmount);

        return invoiceRepository.save(invoice);
    }
}
