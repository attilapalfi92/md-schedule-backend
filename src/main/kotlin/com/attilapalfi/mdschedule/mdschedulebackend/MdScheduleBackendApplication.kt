package com.attilapalfi.mdschedule.mdschedulebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MdScheduleBackendApplication

fun main(args: Array<String>) {
	runApplication<MdScheduleBackendApplication>(*args)
}
