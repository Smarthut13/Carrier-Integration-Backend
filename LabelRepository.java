package com.logistics.carrierintegration.repository;

import com.logistics.carrierintegration.model.ShippingLabel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<ShippingLabel, Long> {}
