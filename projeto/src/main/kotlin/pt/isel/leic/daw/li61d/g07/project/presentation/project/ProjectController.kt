package pt.isel.leic.daw.li61d.g07.project.presentation.project

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = [PROJECT_BASE_URL], produces = ["application/hal+json", "application/json"])
class ProjectController(private val service: ProjectService) {
    @GetMapping
    fun getAllProjects() {
        service.getAllProjects()
    }
}

