package pt.isel.leic.daw.li61d.g07.project.project

import org.springframework.stereotype.Service

@Service
class ProjectService(private val projectRepository: ProjectRepository) {

    fun getAllProjects() {
        projectRepository.getAllProjects()
    }

    fun getProject(projectName: String) {
        projectRepository.getProject(projectName)
    }

    fun createProject(project: ProjectCreator) {
        projectRepository.insertProject(project)
    }
}
