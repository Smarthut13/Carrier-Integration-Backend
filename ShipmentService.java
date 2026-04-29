package com.logistics.carrierintegration.service;

import com.logistics.carrierintegration.dto.CreateShipmentRequest;
import com.logistics.carrierintegration.exception.ResourceNotFoundException;
import com.logistics.carrierintegration.model.Shipment;
import com.logistics.carrierintegration.model.ShipmentStatus;
import com.logistics.carrierintegration.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment createShipment(CreateShipmentRequest request) {
        Shipment shipment = new Shipment();
        shipment.setCustomerName(request.getCustomerName());
        shipment.setOriginCity(request.getOriginCity());
        shipment.setDestinationCity(request.getDestinationCity());
        shipment.setPackageWeight(request.getPackageWeight());
        shipment.setShipmentType(request.getShipmentType());
        shipment.setDeliverySpeed(request.getDeliverySpeed());
        shipment.setStatus(ShipmentStatus.CREATED);
        return shipmentRepository.save(shipment);
    }

    public Shipment getShipment(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + id));
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Shipment updateStatus(Long id, ShipmentStatus status) {
        Shipment shipment = getShipment(id);
        shipment.setStatus(status);
        return shipmentRepository.save(shipment);
    }
}
