package project.spring.kotlincrud.dto

import java.util.UUID

data class CRUDResponse(
    val id: UUID,
    val title: String,
    val content: String,
)