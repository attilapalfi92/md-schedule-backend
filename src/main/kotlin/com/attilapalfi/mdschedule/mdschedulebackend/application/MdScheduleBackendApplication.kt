package com.attilapalfi.mdschedule.mdschedulebackend.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MdScheduleBackendApplication

fun main(args: Array<String>) {
	runApplication<MdScheduleBackendApplication>(*args)
}
