package com.tattoo.management.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record AppointmentResponseDTO(
    UUID id,
    UUID clientId,
    String clientEmail,
    UUID artistId,
    OffsetDateTime appointmentDate,
    String status,
    BigDecimal depositAmount,
    Boolean depositPaid
) {}