package life.temen.repository

import life.temen.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
internal interface MemberRepository : JpaRepository<Member, UUID> {
    fun findOneByEmail(email: String): Member?
}
