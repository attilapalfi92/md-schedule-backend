package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.schedule.ScheduleDay
import java.time.LocalDate
import java.time.Month
import java.time.Year

data class StaffSchedule(
    val staffMember: StaffMember,
    val month: Month,
    val year: Year,
    val schedule: List<ScheduleDay>,
    val daysOff: Set<LocalDate>
)
