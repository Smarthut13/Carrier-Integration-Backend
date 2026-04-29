package com.logistics.carrierintegration.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNumber;
    private BigDecimal carrierChargedAmount;
    private BigDecimal expectedAmount;
    private Boolean matched;
    private String validationMessage;
    private LocalDateTime validatedAt = LocalDateTime.now();

    @OneToOne
    private Shipment shipment;

    public Invoice() {}

    public Long getId() { return id; }
    public String getInvoiceNumber() { return invoiceNumber; }
    public BigDecimal getCarrierChargedAmount() { return carrierChargedAmount; }
    public BigDecimal getExpectedAmount() { return expectedAmount; }
    public Boolean getMatched() { return matched; }
    public String getValidationMessage() { return validationMessage; }
    public LocalDateTime getValidatedAt() { return validatedAt; }
    public Shipment getShipment() { return shipment; }

    public void setId(Long id) { this.id = id; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public void setCarrierChargedAmount(BigDecimal carrierChargedAmount) { this.carrierChargedAmount = carrierChargedAmount; }
    public void setExpectedAmount(BigDecimal expectedAmount) { this.expectedAmount = expectedAmount; }
    public void setMatched(Boolean matched) { this.matched = matched; }
    public void setValidationMessage(String validationMessage) { this.validationMessage = validationMessage; }
    public void setValidatedAt(LocalDateTime validatedAt) { this.validatedAt = validatedAt; }
    public void setShipment(Shipment shipment) { this.shipment = shipment; }
}
