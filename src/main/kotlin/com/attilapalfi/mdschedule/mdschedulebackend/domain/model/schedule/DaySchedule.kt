package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.schedule

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.ClinicShift

data class DaySchedule(
    val scheduleDay: Day,
    val clinicShifts: List<ClinicShift>
)
