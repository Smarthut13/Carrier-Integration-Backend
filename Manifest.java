package com.logistics.carrierintegration.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "manifests")
public class Manifest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manifestNumber;
    private LocalDate manifestDate;
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private Carrier carrier;

    @ManyToMany
    @JoinTable(
        name = "manifest_shipments",
        joinColumns = @JoinColumn(name = "manifest_id"),
        inverseJoinColumns = @JoinColumn(name = "shipment_id")
    )
    private List<Shipment> shipments = new ArrayList<>();

    public Manifest() {}

    public Long getId() { return id; }
    public String getManifestNumber() { return manifestNumber; }
    public LocalDate getManifestDate() { return manifestDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Carrier getCarrier() { return carrier; }
    public List<Shipment> getShipments() { return shipments; }

    public void setId(Long id) { this.id = id; }
    public void setManifestNumber(String manifestNumber) { this.manifestNumber = manifestNumber; }
    public void setManifestDate(LocalDate manifestDate) { this.manifestDate = manifestDate; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setCarrier(Carrier carrier) { this.carrier = carrier; }
    public void setShipments(List<Shipment> shipments) { this.shipments = shipments; }
}
