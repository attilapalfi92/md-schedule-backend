package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.schedule.Day

data class StaffOfDay(
    val day: Day,
    val staff: List<StaffMember>
)
