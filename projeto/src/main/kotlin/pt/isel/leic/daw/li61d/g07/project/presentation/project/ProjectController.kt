package pt.isel.leic.daw.li61d.g07.project.project

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value= [PROJECT_BASE_URL], produces = ["application/hal+json", "application/json"])
class ProjectController(private val service: ProjectService) {

    @GetMapping
    fun getAllProjects() {
        service.getAllProjects()
    }

    @GetMapping(value=["/{projectName}"])
    fun getProject(@PathVariable projectName : String) : ProjectResult {
        return ProjectResult(projectName,"teste1")
    }

    @PutMapping
    fun createProject(@RequestBody project: ProjectCreator) {

    }

}