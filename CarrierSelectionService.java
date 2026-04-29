package com.logistics.carrierintegration.service;

import com.logistics.carrierintegration.exception.CarrierNotAvailableException;
import com.logistics.carrierintegration.exception.ResourceNotFoundException;
import com.logistics.carrierintegration.model.Carrier;
import com.logistics.carrierintegration.model.DeliverySpeed;
import com.logistics.carrierintegration.model.Shipment;
import com.logistics.carrierintegration.model.ShipmentStatus;
import com.logistics.carrierintegration.repository.CarrierRepository;
import com.logistics.carrierintegration.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Service
public class CarrierSelectionService {

    private final CarrierRepository carrierRepository;
    private final ShipmentRepository shipmentRepository;

    public CarrierSelectionService(CarrierRepository carrierRepository, ShipmentRepository shipmentRepository) {
        this.carrierRepository = carrierRepository;
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment selectBestCarrier(Long shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

        List<Carrier> activeCarriers = carrierRepository.findByActiveTrue();
        if (activeCarriers.isEmpty()) {
            throw new CarrierNotAvailableException("No active carrier available");
        }

        Carrier bestCarrier = activeCarriers.stream()
                .filter(carrier -> supportsSpeed(carrier, shipment.getDeliverySpeed()))
                .min(Comparator
                        .comparing((Carrier carrier) -> calculateCost(carrier, shipment))
                        .thenComparing(Carrier::getEstimatedDeliveryDays))
                .orElseThrow(() -> new CarrierNotAvailableException("No carrier supports the requested delivery speed"));

        shipment.setSelectedCarrier(bestCarrier);
        shipment.setExpectedCost(calculateCost(bestCarrier, shipment));
        shipment.setStatus(ShipmentStatus.CARRIER_SELECTED);

        return shipmentRepository.save(shipment);
    }

    private boolean supportsSpeed(Carrier carrier, DeliverySpeed speed) {
        String serviceLevel = carrier.getServiceLevel();
        if (speed == DeliverySpeed.SAME_DAY || speed == DeliverySpeed.ONE_DAY) {
            return "EXPRESS".equalsIgnoreCase(serviceLevel);
        }
        if (speed == DeliverySpeed.TWO_DAY) {
            return "TWO_DAY".equalsIgnoreCase(serviceLevel) || "EXPRESS".equalsIgnoreCase(serviceLevel);
        }
        return true;
    }

    private BigDecimal calculateCost(Carrier carrier, Shipment shipment) {
        BigDecimal weight = BigDecimal.valueOf(shipment.getPackageWeight());
        return carrier.getBaseCost().add(carrier.getCostPerKg().multiply(weight));
    }
}
