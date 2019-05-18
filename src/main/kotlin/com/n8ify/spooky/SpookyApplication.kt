package com.n8ify.spooky

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpookyApplication

fun main(args: Array<String>) {
	runApplication<SpookyApplication>(*args)
}
