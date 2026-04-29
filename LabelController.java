package com.logistics.carrierintegration.controller;

import com.logistics.carrierintegration.model.ShippingLabel;
import com.logistics.carrierintegration.service.LabelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/labels")
public class LabelController {

    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @PostMapping("/generate/{shipmentId}")
    public ShippingLabel generateLabel(@PathVariable Long shipmentId) {
        return labelService.generateLabel(shipmentId);
    }
}
