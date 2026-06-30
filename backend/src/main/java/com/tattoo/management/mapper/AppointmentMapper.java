package com.tattoo.management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.tattoo.management.dto.AppointmentRequestDTO;
import com.tattoo.management.dto.AppointmentResponseDTO;
import com.tattoo.management.model.Appointment;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppointmentMapper {
    
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "client.email", target = "clientEmail")
    @Mapping(source = "artist.id", target = "artistId")
    AppointmentResponseDTO toDto(Appointment entity);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "artist", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "depositAmount", ignore = true)
    @Mapping(target = "depositPaid", constant = "false")
    @Mapping(target = "createdAt", ignore = true)
    Appointment toEntity(AppointmentRequestDTO dto);
}