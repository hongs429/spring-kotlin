package project.spring.kotlincrud.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UuidGenerator
import java.util.UUID


@Entity
@Table(name = "crud")
class CRUDJpaEntity(
    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val content: String,

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(columnDefinition = "BINARY(16)", nullable = false, updatable = false)
    val crudId: UUID? = null,


)