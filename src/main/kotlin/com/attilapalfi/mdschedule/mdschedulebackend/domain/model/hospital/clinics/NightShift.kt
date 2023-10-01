package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.clinics

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.NoWorkNextDayRule
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.NoWorkThatDayRule
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.OnlyOneDoctorRule

class NightShift : Clinic(
    workingHours = 12,
    rules = setOf(OnlyOneDoctorRule, NoWorkThatDayRule, NoWorkNextDayRule)
) {
}