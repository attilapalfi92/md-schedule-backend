package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.hospital.clinics

class Ward : Clinic(
    workingHours = 8,
    rules = HashSet()
) {
}