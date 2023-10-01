package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.schedule.ScheduleDay
import java.time.LocalDate
import java.time.Month
import java.time.Year
import java.time.YearMonth

data class ScheduleOfStaffMember(
    val staffMember: StaffMember,
    val yearMonth: YearMonth,
    val schedule: List<ScheduleDay>,
    val daysOff: Set<LocalDate>
)
