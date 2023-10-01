package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital

import java.time.YearMonth

data class ClinicsOfMonth(
    val yearMonth: YearMonth,
    val clinicsOfDays: List<ClinicsOfDay>
)
