package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.clinics.Clinic
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.schedule.ScheduleDay

data class ClinicsOfDay(
    val scheduleDay: ScheduleDay,
    val clinics: List<Clinic>
)
