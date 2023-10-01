package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.clinics.Clinic
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.schedule.ScheduleDay
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff.StaffMember
import java.util.SortedSet

data class ClinicShift(
    val clinic: Clinic,
    val scheduleDay: ScheduleDay,
    // ordered by priority for the type of clinic
    val staff: SortedSet<StaffMember>
)