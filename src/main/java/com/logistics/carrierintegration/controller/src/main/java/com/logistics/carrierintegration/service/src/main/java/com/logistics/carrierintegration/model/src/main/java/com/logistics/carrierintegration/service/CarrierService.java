package com.logistics.carrierintegration.service;

import org.springframework.stereotype.Service;

@Service
public class CarrierService {

    public String selectCarrier(double weight) {
        if (weight <= 2.0) {
            return "India Post";
        } else if (weight <= 5.0) {
            return "Delhivery";
        } else if (weight <= 15.0) {
            return "BlueDart";
        } else {
            return "Amazon Shipping Heavy Cargo";
        }
    }
}
