package life.temen.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class TimeAuditingEntity(
    createdAt: LocalDateTime? = null,
    updatedAt: LocalDateTime? = null,
) {
    @[Column(updatable = false) CreatedDate]
    var createdAt = createdAt
        protected set

    @[Column(insertable = false) LastModifiedDate]
    var updatedAt = updatedAt
        protected set
}
