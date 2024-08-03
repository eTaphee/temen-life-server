package life.temen.oauth2

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
internal class TeslaOAuth2Service : DefaultOAuth2UserService() {
    @Transactional
    override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User {
        @Suppress("UNCHECKED_CAST")
        return super.loadUser(userRequest).let {
            DefaultOAuth2User(
                it.authorities,
                it.attributes["response"] as MutableMap<String, Any>?,
                "email",
            )
        }
    }
}
