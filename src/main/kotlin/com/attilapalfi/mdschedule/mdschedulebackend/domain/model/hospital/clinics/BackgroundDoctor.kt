package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.clinics

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.AlsoOnWardRule
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.OnlyOneDoctorRule
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.OnlySpecialistRule

class BackgroundDoctor : Clinic(
    workingHours = 8,
    setOf(AlsoOnWardRule, OnlySpecialistRule, OnlyOneDoctorRule)
) {
}