package ru.netology.nmedia.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.service.PostService

@RestController
@RequestMapping("/api/posts", "/api/slow/posts")
class PostController(private val service: PostService) {
    @GetMapping
    // TODO: uncomment for 500 status code generation
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = service.getById(id)

    @PostMapping
    fun save(@RequestBody dto: Post) = service.save(dto)

    @DeleteMapping("/{id}")
    fun removeById(@PathVariable id: Long) = service.removeById(id)

    @PostMapping("/{id}/likes")
    fun likeById(@PathVariable id: Long) = service.likeById(id)

    @DeleteMapping("/{id}/likes")
    fun unlikeById(@PathVariable id: Long) = service.unlikeById(id)

    @PostMapping("/{id}/shares")
    fun repostById(@PathVariable id: Long) = service.repostById(id)
}