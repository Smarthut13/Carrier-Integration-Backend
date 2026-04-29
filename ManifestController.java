package com.logistics.carrierintegration.controller;

import com.logistics.carrierintegration.dto.ManifestRequest;
import com.logistics.carrierintegration.model.Manifest;
import com.logistics.carrierintegration.service.ManifestService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manifests")
public class ManifestController {

    private final ManifestService manifestService;

    public ManifestController(ManifestService manifestService) {
        this.manifestService = manifestService;
    }

    @PostMapping("/create")
    public Manifest createManifest(@Valid @RequestBody ManifestRequest request) {
        return manifestService.createManifest(request);
    }
}
