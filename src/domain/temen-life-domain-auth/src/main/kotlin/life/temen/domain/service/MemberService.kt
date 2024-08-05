package life.temen.domain.service

import life.temen.domain.dto.Member
import java.time.LocalDateTime

interface MemberService {
    fun getMemberByEmail(email: String): Member?

    fun registerOrUpdateMember(
        provider: String,
        email: String,
        fullName: String?,
        profileImageUrl: String?,
        accessToken: String,
        refreshToken: String,
        tokenExpiry: LocalDateTime,
    ): Member
}
