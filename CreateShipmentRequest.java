package com.logistics.carrierintegration.dto;

import com.logistics.carrierintegration.model.DeliverySpeed;
import com.logistics.carrierintegration.model.ShipmentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateShipmentRequest {

    @NotBlank
    private String customerName;

    @NotBlank
    private String originCity;

    @NotBlank
    private String destinationCity;

    @NotNull
    @Positive
    private Double packageWeight;

    @NotNull
    private ShipmentType shipmentType;

    @NotNull
    private DeliverySpeed deliverySpeed;

    public String getCustomerName() { return customerName; }
    public String getOriginCity() { return originCity; }
    public String getDestinationCity() { return destinationCity; }
    public Double getPackageWeight() { return packageWeight; }
    public ShipmentType getShipmentType() { return shipmentType; }
    public DeliverySpeed getDeliverySpeed() { return deliverySpeed; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setOriginCity(String originCity) { this.originCity = originCity; }
    public void setDestinationCity(String destinationCity) { this.destinationCity = destinationCity; }
    public void setPackageWeight(Double packageWeight) { this.packageWeight = packageWeight; }
    public void setShipmentType(ShipmentType shipmentType) { this.shipmentType = shipmentType; }
    public void setDeliverySpeed(DeliverySpeed deliverySpeed) { this.deliverySpeed = deliverySpeed; }
}
