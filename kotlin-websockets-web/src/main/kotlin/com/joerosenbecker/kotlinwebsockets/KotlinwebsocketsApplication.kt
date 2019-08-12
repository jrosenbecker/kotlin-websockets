package com.joerosenbecker.kotlinwebsockets

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan("com.joerosenbecker.kotlinwebsockets")
@SpringBootApplication
class KotlinwebsocketsApplication {

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<KotlinwebsocketsApplication>(*args)
		}
	}

}



