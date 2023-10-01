package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.schedule

import java.time.DayOfWeek
import java.time.MonthDay

data class Day(
    val dayName: DayOfWeek,
    val monthDay: MonthDay
)
