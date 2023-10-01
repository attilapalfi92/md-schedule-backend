package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff

import java.time.YearMonth

data class StaffOfMonth(
    val staffWithAvailability: List<StaffAvailabilityForMonth>,
    val yearMonth: YearMonth
)
