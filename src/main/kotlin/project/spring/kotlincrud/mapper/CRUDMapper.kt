package project.spring.kotlincrud.mapper

import org.springframework.stereotype.Component
import project.spring.kotlincrud.dto.CRUDCreateRequest
import project.spring.kotlincrud.dto.CRUDResponse
import project.spring.kotlincrud.entity.CRUDJpaEntity


@Component
class CRUDMapper {

    fun toEntity(dto: CRUDCreateRequest): CRUDJpaEntity {
        return CRUDJpaEntity(dto.title, dto.content)
//        return CRUDJpaEntity(title = dto.title, content =  dto.content) 와 같은 named parameter 도 가능함.
    }

    fun toResponse(entity: CRUDJpaEntity): CRUDResponse {
        // !! : Non-null assertion operator
        return CRUDResponse(entity.crudId!!, entity.title, entity.content)
    }
}