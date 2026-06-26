package com.tattoo.management.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.tattoo.management.dto.InventoryItemRequestDTO;
import com.tattoo.management.dto.InventoryItemResponseDTO;
import com.tattoo.management.service.InventoryService;

@RestController
@RequestMapping("/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @GetMapping
    public List<InventoryItemResponseDTO> getAll() {
        return service.getAllItems();
    }

    @GetMapping("/alerts")
    public List<InventoryItemResponseDTO> getLowStockAlerts() {
        return service.getLowStockItems();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryItemResponseDTO create(@Valid @RequestBody InventoryItemRequestDTO request) {
        return service.createItem(request);
    }
}