package com.deterior

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.web.config.EnableSpringDataWebSupport

@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
@EnableCaching
@EnableJpaAuditing
@ConfigurationPropertiesScan
@SpringBootApplication
class DeteriorApplication

fun main(args: Array<String>) {
    runApplication<DeteriorApplication>(*args)
}
