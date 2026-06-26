package com.tattoo.management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.tattoo.management.dto.InventoryItemRequestDTO;
import com.tattoo.management.dto.InventoryItemResponseDTO;
import com.tattoo.management.model.InventoryItem;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryMapper {
    
    InventoryItemResponseDTO toDto(InventoryItem entity);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lastRestockedAt", ignore = true)
    InventoryItem toEntity(InventoryItemRequestDTO dto);
}