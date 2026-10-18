package com.service.data.maestria_integrador.application.service;

import com.service.data.maestria_integrador.application.model.DataResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalDataService {
    @Value("${app.external-service.url}")
    private String dataServiceUrl;

    private final RestTemplate restTemplate;

    public ExternalDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DataResponseDto fetchDataFromExternalApi() {
        return restTemplate.getForObject(dataServiceUrl, DataResponseDto.class);
    }
}
