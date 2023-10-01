package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.clinics

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.OnlyOneDoctorRule
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.OnlySpecialistRule

class SpecialistClinic : Clinic(
    workingHours = 8,
    rules = setOf(OnlySpecialistRule, OnlyOneDoctorRule)
) {
}