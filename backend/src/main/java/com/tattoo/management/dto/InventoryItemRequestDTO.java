package com.tattoo.management.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InventoryItemRequestDTO(
    @NotBlank(message = "El nombre es obligatorio")
    String name,
    
    @NotBlank(message = "La categoría es obligatoria")
    String category,
    
    @NotNull(message = "El stock inicial es obligatorio")
    @Min(0)
    Integer currentStock,
    
    @NotNull
    @Min(1)
    Integer minimumThreshold
) {}