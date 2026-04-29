package com.logistics.carrierintegration.controller;

import com.logistics.carrierintegration.model.Shipment;
import com.logistics.carrierintegration.service.CarrierSelectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carriers")
public class CarrierController {

    private final CarrierSelectionService carrierSelectionService;

    public CarrierController(CarrierSelectionService carrierSelectionService) {
        this.carrierSelectionService = carrierSelectionService;
    }

    @PostMapping("/select/{shipmentId}")
    public Shipment selectCarrier(@PathVariable Long shipmentId) {
        return carrierSelectionService.selectBestCarrier(shipmentId);
    }
}
