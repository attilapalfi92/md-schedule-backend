package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff

import java.time.YearMonth

data class StaffOfMonth(
    val staffOfDays: List<StaffOfDay>,
    val staffWithAvailability: List<StaffAvailabilityForMonth>,
    val yearMonth: YearMonth
)
