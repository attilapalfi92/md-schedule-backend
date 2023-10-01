package com.attilapalfi.mdschedule.mdschedulebackend.domain.service.rule.checker

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.error.Error
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.Rule

class RuleViolationException(val rule: Rule, val errors: List<Error>) : Exception() {
}