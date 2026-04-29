package com.logistics.carrierintegration.model;

public class Shipment {

    private Long id;
    private String origin;
    private String destination;
    private double weight;

    public Shipment() {
    }

    public Shipment(Long id, String origin, String destination, double weight) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
