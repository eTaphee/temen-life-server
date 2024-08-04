package life.temen.app.externalapi.config

import life.temen.app.externalapi.oauth2.TeslaOAuth2SuccessHandler
import life.temen.app.externalapi.repository.MemberRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy.STATELESS
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
internal class SecurityConfig(
    private val oAuth2AuthorizedClientService: OAuth2AuthorizedClientService,
    private val memberRepository: MemberRepository,
) {
    @Bean
    fun defaultFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests {
                it.requestMatchers("/oauth2/authorization/**").permitAll()
                it.requestMatchers("/error").permitAll()
                it.anyRequest().permitAll()
            }

        http.formLogin { it.disable() }
        http.httpBasic { it.disable() }

        http.csrf { it.disable() }
        http.sessionManagement { it.sessionCreationPolicy(STATELESS) }

        http.oauth2Login {
            it.successHandler(TeslaOAuth2SuccessHandler(oAuth2AuthorizedClientService, memberRepository))
        }
        http.oauth2Client { }

        return http.orBuild
    }
}
