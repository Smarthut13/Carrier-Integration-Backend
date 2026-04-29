package com.logistics.carrierintegration.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipping_labels")
public class ShippingLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackingNumber;
    private String labelContent;
    private LocalDateTime generatedAt = LocalDateTime.now();

    @OneToOne
    private Shipment shipment;

    public ShippingLabel() {}

    public Long getId() { return id; }
    public String getTrackingNumber() { return trackingNumber; }
    public String getLabelContent() { return labelContent; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public Shipment getShipment() { return shipment; }

    public void setId(Long id) { this.id = id; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }
    public void setLabelContent(String labelContent) { this.labelContent = labelContent; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
    public void setShipment(Shipment shipment) { this.shipment = shipment; }
}
