package com.logistics.carrierintegration.controller;

import com.logistics.carrierintegration.dto.CreateShipmentRequest;
import com.logistics.carrierintegration.model.Shipment;
import com.logistics.carrierintegration.model.ShipmentStatus;
import com.logistics.carrierintegration.service.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public Shipment createShipment(@Valid @RequestBody CreateShipmentRequest request) {
        return shipmentService.createShipment(request);
    }

    @GetMapping("/{id}")
    public Shipment getShipment(@PathVariable Long id) {
        return shipmentService.getShipment(id);
    }

    @GetMapping
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @PutMapping("/{id}/status")
    public Shipment updateStatus(@PathVariable Long id, @RequestParam ShipmentStatus status) {
        return shipmentService.updateStatus(id, status);
    }
}
