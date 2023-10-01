package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.clinics

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.OnlyOneDoctorRule

class DayShift : Clinic(
    workingHours = 12,
    rules = setOf(OnlyOneDoctorRule)
) {
}