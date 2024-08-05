package life.temen.domain.dto

import java.time.LocalDateTime

data class Member(
    val email: String,
    var fullName: String? = null,
    var profileImageUrl: String? = null,
    var accessToken: String,
    var refreshToken: String,
    var tokenExpiry: LocalDateTime,
) {
    companion object {
        internal fun from(member: life.temen.domain.entity.Member) =
            with(member) {
                Member(
                    email = email,
                    fullName = fullName,
                    profileImageUrl = profileImageUrl,
                    accessToken = accessToken,
                    refreshToken = refreshToken,
                    tokenExpiry = tokenExpiry,
                )
            }
    }
}
