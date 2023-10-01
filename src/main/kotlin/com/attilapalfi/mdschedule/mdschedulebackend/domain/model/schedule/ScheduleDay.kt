package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.schedule

import java.time.DayOfWeek
import java.time.Month
import java.time.MonthDay

data class ScheduleDay(
    val dayName: DayOfWeek,
    val monthDay: MonthDay,
    val month: Month
)
