package com.logistics.carrierintegration.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "carriers")
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String serviceLevel;
    private BigDecimal baseCost;
    private BigDecimal costPerKg;
    private Integer estimatedDeliveryDays;
    private Boolean active = true;

    public Carrier() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getServiceLevel() { return serviceLevel; }
    public BigDecimal getBaseCost() { return baseCost; }
    public BigDecimal getCostPerKg() { return costPerKg; }
    public Integer getEstimatedDeliveryDays() { return estimatedDeliveryDays; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setServiceLevel(String serviceLevel) { this.serviceLevel = serviceLevel; }
    public void setBaseCost(BigDecimal baseCost) { this.baseCost = baseCost; }
    public void setCostPerKg(BigDecimal costPerKg) { this.costPerKg = costPerKg; }
    public void setEstimatedDeliveryDays(Integer estimatedDeliveryDays) { this.estimatedDeliveryDays = estimatedDeliveryDays; }
    public void setActive(Boolean active) { this.active = active; }
}
