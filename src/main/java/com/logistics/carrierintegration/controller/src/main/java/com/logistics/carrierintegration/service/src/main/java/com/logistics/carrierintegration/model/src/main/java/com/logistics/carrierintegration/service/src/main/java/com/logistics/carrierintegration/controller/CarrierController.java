package com.logistics.carrierintegration.controller;

import com.logistics.carrierintegration.service.CarrierService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carriers")
public class CarrierController {

    private final CarrierService carrierService;

    public CarrierController(CarrierService carrierService) {
        this.carrierService = carrierService;
    }

    @GetMapping("/select")
    public String selectCarrier(@RequestParam double weight) {
        return carrierService.selectCarrier(weight);
    }
}
