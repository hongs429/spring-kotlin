package project.spring.kotlincrud.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import project.spring.kotlincrud.dto.CRUDCreateRequest
import project.spring.kotlincrud.dto.CRUDResponse
import project.spring.kotlincrud.service.CRUDService
import java.util.UUID


@RestController
@RequestMapping("/api/v1/cruds")
class CRUDController(
    private val crudService: CRUDService
) {

    @PostMapping("/test")
    fun test() {
        println("test")
    }

    @PostMapping
    fun create(@RequestBody requestDTO: CRUDCreateRequest): ResponseEntity<CRUDResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(crudService.create(requestDTO))
    }

    @GetMapping("/{crudId}")
    fun get(@PathVariable("crudId") crudId: UUID): ResponseEntity<CRUDResponse> {
        return ResponseEntity.ok(crudService.get(crudId))
    }

    @GetMapping
    fun getList(): ResponseEntity<List<CRUDResponse>> {
        return ResponseEntity.ok(crudService.getList())

    }
}