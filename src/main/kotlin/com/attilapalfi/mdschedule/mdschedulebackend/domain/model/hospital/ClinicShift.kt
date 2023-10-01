package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.clinics.Clinic
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff.StaffMember

data class ClinicShift(
    val clinic: Clinic,
    val staff: List<StaffMember>
)