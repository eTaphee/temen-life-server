package life.temen.app.externalapi.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val oAuth2AuthorizedClientService: OAuth2AuthorizedClientService,
) {
    @GetMapping("/user")
    fun getOAuth2User(request: HttpServletRequest): OAuth2AuthenticationToken? {
        println(request.session.id)

        SecurityContextHolder.getContext().authentication

        return null
    }
}
