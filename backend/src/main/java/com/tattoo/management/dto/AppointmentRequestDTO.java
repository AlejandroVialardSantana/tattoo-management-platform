package com.tattoo.management.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

public record AppointmentRequestDTO(
    @NotNull(message = "El cliente es obligatorio")
    UUID clientId,
    
    @NotNull(message = "El artista es obligatorio")
    UUID artistId,
    
    @NotNull(message = "La fecha es obligatoria")
    @Future(message = "La fecha de la cita debe ser en el futuro")
    OffsetDateTime appointmentDate
) {}