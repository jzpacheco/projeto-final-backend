package com.backend.projetofinal.domain.appointment;

import java.util.Date;
import java.util.UUID;

public record AppointmentDTO(

         UUID id,
         String description,
         Date appointmentDate,
         UUID patientId,
         UUID doctorId,
         UUID attendantId) {

}
