package com.logistics.carrierintegration.repository;

import com.logistics.carrierintegration.model.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarrierRepository extends JpaRepository<Carrier, Long> {
    List<Carrier> findByActiveTrue();
}
