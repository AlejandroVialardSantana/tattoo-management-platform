package com.tattoo.management.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tattoo.management.dto.AppointmentRequestDTO;
import com.tattoo.management.dto.AppointmentResponseDTO;
import com.tattoo.management.mapper.AppointmentMapper;
import com.tattoo.management.model.Appointment;
import com.tattoo.management.model.User;
import com.tattoo.management.repository.AppointmentRepository;
import com.tattoo.management.repository.UserRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final AppointmentMapper mapper;

    public AppointmentService(AppointmentRepository appointmentRepository, 
                              UserRepository userRepository, 
                              AppointmentMapper mapper) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Transactional
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO request) {
        
        User client = userRepository.findById(request.clientId())
            .orElseThrow(() -> new RuntimeException("Error: Cliente no encontrado en el sistema"));

        User artist = userRepository.findById(request.artistId())
            .orElseThrow(() -> new RuntimeException("Error: Artista no encontrado en el sistema"));

        Appointment appointment = mapper.toEntity(request);
        
        appointment.setClient(client);
        appointment.setArtist(artist);
        
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return mapper.toDto(savedAppointment);
    }
}