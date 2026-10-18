package com.service.data.maestria_integrador.application.controller;

import com.service.data.maestria_integrador.application.model.DataResponseDto;
import com.service.data.maestria_integrador.application.service.ExternalDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/integrador")
public class IntegradorController {

    private final ExternalDataService externalDataService;

    public IntegradorController(ExternalDataService externalDataService) {
        this.externalDataService = externalDataService;
    }

    @GetMapping("/external-data")
    public ResponseEntity<DataResponseDto> getExternalData() {
        DataResponseDto data = externalDataService.fetchDataFromExternalApi();
        return ResponseEntity.ok(data);
    }
}
