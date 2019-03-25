package pt.isel.leic.daw.li61d.g07.project.presentation.project

import com.fasterxml.jackson.annotation.JsonCreator
import pt.isel.leic.daw.li61d.g07.project.presentation.hateoas.HalObject
import pt.isel.leic.daw.li61d.g07.project.presentation.hateoas.Link

data class Project @JsonCreator constructor(val name: String, val description: String) : HalObject(
        mapOf(
                "self" to Link(PROJECT_BASE_URL, "Reload")
        )
)