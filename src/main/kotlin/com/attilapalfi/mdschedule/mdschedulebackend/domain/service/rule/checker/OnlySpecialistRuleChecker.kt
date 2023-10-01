package com.attilapalfi.mdschedule.mdschedulebackend.domain.service.rule.checker

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.error.Error
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.error.ErrorCode
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.ClinicShift
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.OnlySpecialistRule
import com.attilapalfi.mdschedule.mdschedulebackend.domain.service.rule.RuleUtils.areAllSpecialistDoctors
import com.attilapalfi.mdschedule.mdschedulebackend.domain.service.rule.RuleUtils.getNonSpecialists
import com.attilapalfi.mdschedule.mdschedulebackend.domain.service.rule.RuleUtils.toNameList

class OnlySpecialistRuleChecker : AbstractRuleChecker() {
    override fun supportedRule() = OnlySpecialistRule

    override fun verifyRule(clinicShift: ClinicShift, errors: ArrayList<Error>): Boolean {
        return if (!areAllSpecialistDoctors(clinicShift)) {
            errors.add(
                Error(
                    ErrorCode.NOT_SPECIALIST,
                    "The following staff: " + getNonSpecialists(clinicShift).toNameList()
                )
            )
            false
        } else {
            true
        }
    }
}
