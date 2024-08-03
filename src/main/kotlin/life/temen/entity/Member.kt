package life.temen.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.UUID

@Entity
internal class Member(
    val provider: String,
    val email: String,
    var fullName: String? = null,
    var profileImageUrl: String? = null,
    var accessToken: String,
    var refreshToken: String,
    var tokenExpiry: LocalDateTime,
) : TimeAuditingEntity() {
    @Id
    @Column(columnDefinition = "char(36)")
    val id: UUID = UUID.randomUUID()
}
