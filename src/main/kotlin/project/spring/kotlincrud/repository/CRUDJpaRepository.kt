package project.spring.kotlincrud.repository

import org.springframework.data.jpa.repository.JpaRepository
import project.spring.kotlincrud.entity.CRUDJpaEntity
import java.util.UUID

interface CRUDJpaRepository : JpaRepository<CRUDJpaEntity, UUID> {
}