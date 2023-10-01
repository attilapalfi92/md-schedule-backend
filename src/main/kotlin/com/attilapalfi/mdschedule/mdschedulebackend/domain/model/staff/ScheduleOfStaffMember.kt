package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.ClinicShift
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.schedule.Day
import java.time.LocalDate
import java.time.YearMonth

data class ScheduleOfStaffMember(
    val staffMember: StaffMember,
    val yearMonth: YearMonth,
    val schedule: List<ClinicShift>,
    val daysOff: Set<LocalDate>
)
