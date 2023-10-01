package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.staff

class Doctor(name: String, shortName: String, val doctorLevel: DoctorLevel) : StaffMember(name, shortName) {
}

enum class DoctorLevel {
    RESIDENT, GENARAL_DOCTOR, SPECIALIST_CANDIDATE, SPECIALIST
}