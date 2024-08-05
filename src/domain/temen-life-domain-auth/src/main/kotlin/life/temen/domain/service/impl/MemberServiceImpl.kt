package life.temen.domain.service.impl

import life.temen.domain.dto.Member
import life.temen.domain.repository.MemberRepository
import life.temen.domain.service.MemberService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import life.temen.domain.entity.Member as MemberEntity

@Service
internal class MemberServiceImpl(
    private val memberRepository: MemberRepository,
) : MemberService {
    @Transactional(readOnly = true)
    override fun getMemberByEmail(email: String): Member? = memberRepository.findOneByEmail(email)?.let(Member::from)

    @Transactional
    override fun registerOrUpdateMember(
        provider: String,
        email: String,
        fullName: String?,
        profileImageUrl: String?,
        accessToken: String,
        refreshToken: String,
        tokenExpiry: LocalDateTime,
    ): Member {
        val member =
            memberRepository.findOneByEmail(email)
                ?: MemberEntity(
                    provider,
                    email,
                    fullName,
                    profileImageUrl,
                    accessToken,
                    refreshToken,
                    tokenExpiry,
                )

        member.also {
            it.fullName = fullName
            it.profileImageUrl = profileImageUrl
            it.accessToken = accessToken
            it.refreshToken = refreshToken
            it.tokenExpiry = tokenExpiry
        }

        return memberRepository.save(member).let(Member::from)
    }
}
