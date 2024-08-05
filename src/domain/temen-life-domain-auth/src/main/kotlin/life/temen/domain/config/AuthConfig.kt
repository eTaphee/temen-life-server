package life.temen.domain.config

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@AutoConfiguration
@ComponentScan(basePackages = ["life.temen.domain"])
@EntityScan(basePackages = ["life.temen.domain"])
@EnableJpaRepositories(basePackages = ["life.temen.domain"])
class AuthConfig
