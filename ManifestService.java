package com.logistics.carrierintegration.service;

import com.logistics.carrierintegration.dto.ManifestRequest;
import com.logistics.carrierintegration.exception.ResourceNotFoundException;
import com.logistics.carrierintegration.model.Carrier;
import com.logistics.carrierintegration.model.Manifest;
import com.logistics.carrierintegration.model.Shipment;
import com.logistics.carrierintegration.model.ShipmentStatus;
import com.logistics.carrierintegration.repository.CarrierRepository;
import com.logistics.carrierintegration.repository.ManifestRepository;
import com.logistics.carrierintegration.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ManifestService {

    private final CarrierRepository carrierRepository;
    private final ShipmentRepository shipmentRepository;
    private final ManifestRepository manifestRepository;

    public ManifestService(CarrierRepository carrierRepository,
                           ShipmentRepository shipmentRepository,
                           ManifestRepository manifestRepository) {
        this.carrierRepository = carrierRepository;
        this.shipmentRepository = shipmentRepository;
        this.manifestRepository = manifestRepository;
    }

    public Manifest createManifest(ManifestRequest request) {
        Carrier carrier = carrierRepository.findById(request.getCarrierId())
                .orElseThrow(() -> new ResourceNotFoundException("Carrier not found with id: " + request.getCarrierId()));

        List<Shipment> shipments = shipmentRepository.findAllById(request.getShipmentIds());
        if (shipments.size() != request.getShipmentIds().size()) {
            throw new ResourceNotFoundException("One or more shipments were not found");
        }

        Manifest manifest = new Manifest();
        manifest.setCarrier(carrier);
        manifest.setShipments(shipments);
        manifest.setManifestDate(LocalDate.now());
        manifest.setManifestNumber("MNF-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());

        shipments.forEach(shipment -> shipment.setStatus(ShipmentStatus.MANIFESTED));
        shipmentRepository.saveAll(shipments);

        return manifestRepository.save(manifest);
    }
}
