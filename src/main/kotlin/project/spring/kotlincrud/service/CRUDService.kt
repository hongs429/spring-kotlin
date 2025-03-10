package project.spring.kotlincrud.service

import org.springframework.stereotype.Service
import project.spring.kotlincrud.dto.CRUDCreateRequest
import project.spring.kotlincrud.dto.CRUDResponse
import project.spring.kotlincrud.entity.CRUDJpaEntity
import project.spring.kotlincrud.mapper.CRUDMapper
import project.spring.kotlincrud.repository.CRUDJpaRepository
import java.util.*


@Service
class CRUDService(
    private val crudJpaRepository: CRUDJpaRepository,
    private val crudMapper: CRUDMapper
) {

    fun create(request: CRUDCreateRequest) : CRUDResponse {
        val save = crudJpaRepository.save(crudMapper.toEntity(request))
        return crudMapper.toResponse(save)
    }

    fun get(crudId: UUID): CRUDResponse {
        val entity = crudJpaRepository.findById(crudId).orElseThrow {
            IllegalStateException("Crud with id $crudId does not exist")
        }

        return crudMapper.toResponse(entity)
    }

    fun getList(): List<CRUDResponse> {
        val dataList: List<CRUDResponse> = crudJpaRepository.findAll()
            .map{ crudJpaEntity ->  crudMapper.toResponse(crudJpaEntity) }
//            .map{ crudMapper.toResponse(it) }  // 아래 전부 다 됨!
//            .map(crudMapper::toResponse)

        return dataList
    }
}