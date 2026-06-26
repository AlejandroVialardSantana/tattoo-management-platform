package com.tattoo.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;

@Entity
@Table(name = "inventory_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(name = "current_stock", nullable = false)
    private Integer currentStock;

    @Column(name = "minimum_threshold", nullable = false)
    private Integer minimumThreshold;

    @Column(name = "last_restocked_at")
    private OffsetDateTime lastRestockedAt;
}