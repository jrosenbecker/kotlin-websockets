package com.joerosenbecker.kotlinwebsockets

import org.springframework.boot.SpringApplication
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@ComponentScan("com.joerosenbecker.kotlinwebsockets")
@SpringBootApplication
class KotlinwebsocketsApplication {

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {
			val app = SpringApplication(KotlinwebsocketsApplication::class.java)
			app.webApplicationType = WebApplicationType.REACTIVE
			app.run(*args)
		}
	}

}



