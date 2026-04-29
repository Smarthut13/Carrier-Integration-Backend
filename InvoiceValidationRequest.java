package com.logistics.carrierintegration.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class InvoiceValidationRequest {

    @NotNull
    private Long shipmentId;

    @NotBlank
    private String invoiceNumber;

    @NotNull
    @Positive
    private BigDecimal carrierChargedAmount;

    public Long getShipmentId() { return shipmentId; }
    public String getInvoiceNumber() { return invoiceNumber; }
    public BigDecimal getCarrierChargedAmount() { return carrierChargedAmount; }

    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public void setCarrierChargedAmount(BigDecimal carrierChargedAmount) { this.carrierChargedAmount = carrierChargedAmount; }
}
