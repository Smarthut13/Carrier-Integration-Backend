package com.logistics.carrierintegration.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String originCity;
    private String destinationCity;
    private Double packageWeight;

    @Enumerated(EnumType.STRING)
    private ShipmentType shipmentType;

    @Enumerated(EnumType.STRING)
    private DeliverySpeed deliverySpeed;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus status = ShipmentStatus.CREATED;

    @ManyToOne
    private Carrier selectedCarrier;

    private BigDecimal expectedCost;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Shipment() {}

    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getOriginCity() { return originCity; }
    public String getDestinationCity() { return destinationCity; }
    public Double getPackageWeight() { return packageWeight; }
    public ShipmentType getShipmentType() { return shipmentType; }
    public DeliverySpeed getDeliverySpeed() { return deliverySpeed; }
    public ShipmentStatus getStatus() { return status; }
    public Carrier getSelectedCarrier() { return selectedCarrier; }
    public BigDecimal getExpectedCost() { return expectedCost; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setOriginCity(String originCity) { this.originCity = originCity; }
    public void setDestinationCity(String destinationCity) { this.destinationCity = destinationCity; }
    public void setPackageWeight(Double packageWeight) { this.packageWeight = packageWeight; }
    public void setShipmentType(ShipmentType shipmentType) { this.shipmentType = shipmentType; }
    public void setDeliverySpeed(DeliverySpeed deliverySpeed) { this.deliverySpeed = deliverySpeed; }
    public void setStatus(ShipmentStatus status) { this.status = status; }
    public void setSelectedCarrier(Carrier selectedCarrier) { this.selectedCarrier = selectedCarrier; }
    public void setExpectedCost(BigDecimal expectedCost) { this.expectedCost = expectedCost; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
