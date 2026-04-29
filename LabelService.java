package com.logistics.carrierintegration.service;

import com.logistics.carrierintegration.exception.CarrierNotAvailableException;
import com.logistics.carrierintegration.exception.ResourceNotFoundException;
import com.logistics.carrierintegration.model.Shipment;
import com.logistics.carrierintegration.model.ShipmentStatus;
import com.logistics.carrierintegration.model.ShippingLabel;
import com.logistics.carrierintegration.repository.LabelRepository;
import com.logistics.carrierintegration.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LabelService {

    private final ShipmentRepository shipmentRepository;
    private final LabelRepository labelRepository;

    public LabelService(ShipmentRepository shipmentRepository, LabelRepository labelRepository) {
        this.shipmentRepository = shipmentRepository;
        this.labelRepository = labelRepository;
    }

    public ShippingLabel generateLabel(Long shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

        if (shipment.getSelectedCarrier() == null) {
            throw new CarrierNotAvailableException("Carrier must be selected before label generation");
        }

        ShippingLabel label = new ShippingLabel();
        label.setShipment(shipment);
        label.setTrackingNumber("TRK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        label.setLabelContent(buildLabelContent(shipment, label.getTrackingNumber()));

        shipment.setStatus(ShipmentStatus.LABEL_GENERATED);
        shipmentRepository.save(shipment);

        return labelRepository.save(label);
    }

    private String buildLabelContent(Shipment shipment, String trackingNumber) {
        return "Shipment ID: " + shipment.getId()
                + " | Tracking: " + trackingNumber
                + " | Carrier: " + shipment.getSelectedCarrier().getName()
                + " | From: " + shipment.getOriginCity()
                + " | To: " + shipment.getDestinationCity()
                + " | Service: " + shipment.getSelectedCarrier().getServiceLevel();
    }
}
