package com.backend.projetofinal.domain.appointment.dto;

import com.backend.projetofinal.domain.appointment.Appointment;
import com.backend.projetofinal.domain.appointment.AppointmentDTO;
import com.backend.projetofinal.domain.pacient.Patient;
import com.backend.projetofinal.domain.partner.Partner;
import com.backend.projetofinal.services.PacientService;
import com.backend.projetofinal.services.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentMapper {


    PacientService pacientService = new PacientService();
    PartnerService partnerService = new PartnerService();

    public AppointmentDTO toDto(Appointment appointment) {
         return new AppointmentDTO(
                appointment.getId(),
                appointment.getDescription(),
                appointment.getAppointmentDate(),
                appointment.getPatient().getId(),
                appointment.getDoctor().getId(),
                appointment.getAttendant().getId());

    }

    public Appointment toEntity(AppointmentDTO appointmentDTO) {
        Partner doctor = partnerService.findById(appointmentDTO.doctorId());
        Partner attendant = partnerService.findById(appointmentDTO.attendantId());
        Patient patient = pacientService.findById(appointmentDTO.patientId());
        return new Appointment(
                appointmentDTO.description(),
                appointmentDTO.appointmentDate(),
                patient,
                doctor,
                attendant
        );
    }
}
