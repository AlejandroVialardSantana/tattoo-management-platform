package com.tattoo.management.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tattoo.management.dto.InventoryItemRequestDTO;
import com.tattoo.management.dto.InventoryItemResponseDTO;
import com.tattoo.management.mapper.InventoryMapper;
import com.tattoo.management.repository.InventoryItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryItemRepository repository;
    private final InventoryMapper mapper;

    public List<InventoryItemResponseDTO> getAllItems() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<InventoryItemResponseDTO> getLowStockItems() {
        return repository.findByCurrentStockLessThanEqual(5).stream()
                .map(mapper::toDto)
                .toList();
    }

    public InventoryItemResponseDTO createItem(InventoryItemRequestDTO request) {
        var entity = mapper.toEntity(request);
        var savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }
}