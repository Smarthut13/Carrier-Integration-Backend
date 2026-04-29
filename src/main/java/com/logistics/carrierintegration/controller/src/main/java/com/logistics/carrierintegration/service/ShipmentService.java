package com.logistics.carrierintegration.service;

import com.logistics.carrierintegration.model.Shipment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipmentService {

    private final List<Shipment> shipments = new ArrayList<>();

    public Shipment createShipment(Shipment shipment) {
        shipments.add(shipment);
        return shipment;
    }

    public List<Shipment> getAllShipments() {
        return shipments;
    }
}
