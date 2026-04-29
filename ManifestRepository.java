package com.logistics.carrierintegration.repository;

import com.logistics.carrierintegration.model.Manifest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManifestRepository extends JpaRepository<Manifest, Long> {}
