package com.tattoo.management.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tattoo.management.model.InventoryItem;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, UUID> {
    List<InventoryItem> findByCurrentStockLessThanEqual(Integer threshold);
}