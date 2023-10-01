package com.attilapalfi.mdschedule.mdschedulebackend.domain.service.rule

import com.attilapalfi.mdschedule.mdschedulebackend.domain.service.rule.checker.RuleChecker
import org.springframework.stereotype.Service

@Service
class RuleCheckerService(
    private val ruleCheckers: List<RuleChecker>
) {

}