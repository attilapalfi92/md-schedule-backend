package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.clinics

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.AlsoOnWardRule
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.AtLeastSpecialistCandidateRule

class Consultant : Clinic(
    workingHours = 0,
    rules = setOf(AlsoOnWardRule, AtLeastSpecialistCandidateRule)
) {
}