package life.temen.app.externalapi.auth

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import life.temen.domain.service.MemberService
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import java.time.LocalDateTime
import java.time.ZoneId

internal class TeslaOAuth2SuccessHandler(
    private val oAuth2AuthorizedClientService: OAuth2AuthorizedClientService,
    private val memberService: MemberService,
) : SimpleUrlAuthenticationSuccessHandler() {
    companion object {
        private val ZONE_ID = ZoneId.of("Asia/Seoul")
    }

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication,
    ) {
        authentication as OAuth2AuthenticationToken

        val provider = authentication.authorizedClientRegistrationId
        val email = authentication.name

        val authorizedClient =
            oAuth2AuthorizedClientService.loadAuthorizedClient<OAuth2AuthorizedClient>(
                provider,
                email,
            )

        val fullName = authentication.principal.attributes["full_name"] as String?
        val profileImageUrl = authentication.principal.attributes["profile_image_url"] as String?
        val accessToken = authorizedClient.accessToken.tokenValue
        val refreshToken = authorizedClient.refreshToken!!.tokenValue
        val tokenExpiry = LocalDateTime.ofInstant(authorizedClient.accessToken.expiresAt, ZONE_ID)

        memberService?.registerOrUpdateMember(
            provider,
            email,
            fullName,
            profileImageUrl,
            accessToken,
            refreshToken,
            tokenExpiry,
        )

        redirectStrategy.sendRedirect(request, response, "https://naver.com")
    }
}
