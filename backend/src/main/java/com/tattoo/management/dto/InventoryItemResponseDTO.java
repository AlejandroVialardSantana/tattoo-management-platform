package com.tattoo.management.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record InventoryItemResponseDTO(
	    UUID id,
	    String name,
	    String category,
	    Integer currentStock,
	    Integer minimumThreshold,
	    OffsetDateTime lastRestockedAt
	) {}
