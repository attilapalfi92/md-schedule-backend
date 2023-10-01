package com.attilapalfi.mdschedule.mdschedulebackend.domain.service.rule.checker

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.ClinicShift
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.Rule

interface RuleChecker {

    fun supportedRule(): Rule

    fun checkRule(clinicShift: ClinicShift): Result<String>
}