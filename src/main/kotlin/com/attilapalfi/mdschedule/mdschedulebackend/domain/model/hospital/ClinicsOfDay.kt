package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.clinics.Clinic
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.schedule.Day

data class ClinicsOfDay(
    val day: Day,
    val clinics: List<Clinic>
)
