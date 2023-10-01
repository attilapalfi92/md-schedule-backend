package com.attilapalfi.mdschedule.mdschedulebackend.domain.service.rule.checker

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.error.Error
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.ClinicShift
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.OnlySpecialistRule

abstract class AbstractRuleChecker : RuleChecker {

    override fun checkRule(clinicShift: ClinicShift): Result<String> {
        val errors = ArrayList<Error>()
        return if (verifyRule(clinicShift, errors)) {
            Result.success("")
        } else {
            Result.failure(RuleViolationException(OnlySpecialistRule, errors))
        }
    }

    protected abstract fun verifyRule(clinicShift: ClinicShift, errors: ArrayList<Error>): Boolean
}