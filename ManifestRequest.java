package com.logistics.carrierintegration.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class ManifestRequest {

    @NotNull
    private Long carrierId;

    @NotEmpty
    private List<Long> shipmentIds;

    public Long getCarrierId() { return carrierId; }
    public List<Long> getShipmentIds() { return shipmentIds; }

    public void setCarrierId(Long carrierId) { this.carrierId = carrierId; }
    public void setShipmentIds(List<Long> shipmentIds) { this.shipmentIds = shipmentIds; }
}
