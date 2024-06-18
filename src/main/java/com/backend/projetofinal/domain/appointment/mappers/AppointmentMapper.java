package com.backend.projetofinal.domain.appointment.mappers;

import com.backend.projetofinal.domain.appointment.Appointment;
import com.backend.projetofinal.domain.appointment.dto.AppointmentDTO;
import com.backend.projetofinal.domain.partner.mappers.PartnerMapper;
import com.backend.projetofinal.domain.patient.Patient;
import com.backend.projetofinal.domain.partner.Partner;
import com.backend.projetofinal.domain.patient.mappers.PatientMapper;
import com.backend.projetofinal.services.PatientService;
import com.backend.projetofinal.services.PartnerService;

public class AppointmentMapper {


    PatientService patientService = new PatientService();
    PartnerService partnerService = new PartnerService();

    PartnerMapper partnerMapper = new PartnerMapper();
    PatientMapper patientMapper = new PatientMapper();

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
        Partner doctor = partnerMapper.toEntity(partnerService.findById(appointmentDTO.doctorId()));
        Partner attendant = partnerMapper.toEntity(partnerService.findById(appointmentDTO.attendantId()));
        Patient patient = patientMapper.toEntity(patientService.findById(appointmentDTO.patientId()));
        return new Appointment(
                appointmentDTO.description(),
                appointmentDTO.appointmentDate(),
                patient,
                doctor,
                attendant
        );
    }
}
