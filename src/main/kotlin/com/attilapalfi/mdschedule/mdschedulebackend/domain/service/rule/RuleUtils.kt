package com.attilapalfi.mdschedule.mdschedulebackend.domain.service.rule

import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.ClinicShift
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff.Doctor
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff.DoctorLevel.SPECIALIST
import com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff.StaffMember

object RuleUtils {
    fun areAllSpecialistDoctors(clinicShift: ClinicShift): Boolean =
        clinicShift.staff.all { it is Doctor && it.doctorLevel == SPECIALIST }

    fun getNonSpecialists(clinicShift: ClinicShift): List<StaffMember> =
        clinicShift.staff.filter { it !is Doctor || (it.doctorLevel != SPECIALIST) }

    fun List<StaffMember>.toNameList(): String {
        return joinToString(", ") { it.name }
    }
}