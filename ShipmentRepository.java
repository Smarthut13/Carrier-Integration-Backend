package com.logistics.carrierintegration.repository;

import com.logistics.carrierintegration.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {}
