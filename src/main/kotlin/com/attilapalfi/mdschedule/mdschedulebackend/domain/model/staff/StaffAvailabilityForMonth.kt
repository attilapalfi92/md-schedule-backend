package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff

import java.time.LocalDate

data class StaffAvailabilityForMonth(
    val staffMember: StaffMember,
    val vacation: List<LocalDate>,
    val dayShiftExceptions: List<LocalDate>,
    val nightShiftExceptions: List<LocalDate>
)