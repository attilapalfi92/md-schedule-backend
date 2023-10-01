package com.attilapalfi.mdschedule.mdschedulebackend.domain.service

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.ClinicsOfMonth
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.schedule.MonthSchedule
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff.StaffOfMonth
import org.springframework.data.mongodb.core.aggregation.DateOperators.DayOfMonth
import org.springframework.stereotype.Service
import java.time.YearMonth

@Service
class ScheduleCreator {

    fun newSchedule(
        yearMonth: YearMonth,
        weekendsAndHolidays: List<DayOfMonth>,
        staffOfMonth: StaffOfMonth,
        clinicsOfMonth: ClinicsOfMonth
    ): MonthSchedule {
        TODO()
    }
}