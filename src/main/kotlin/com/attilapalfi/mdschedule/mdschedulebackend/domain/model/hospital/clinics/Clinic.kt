package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.clinics

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.rule.Rule

/**
 * Clinic is a definition for a type of appointment.
 * Like for example in hungarian the following things are clinics in this software:
 * - osztály (ward)
 * - háttérember (background person)
 * - szakrendelő (specialist clinic)
 * - etc.
 */
abstract class Clinic(
    val workingHours: Int,
    val rules: Set<Rule>
)