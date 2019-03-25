package pt.isel.leic.daw.li61d.g07.project.project

import com.fasterxml.jackson.annotation.JsonCreator
import pt.isel.leic.daw.li61d.g07.project.HalObject
import pt.isel.leic.daw.li61d.g07.project.Link

data class ProjectResult @JsonCreator constructor(val name: String,
                                                  val description: String) : HalObject(
        mapOf(
                "self" to Link(PROJECT_BASE_URL, "Reload"),
                "http://docs.projects.api/rels/projects/issues" to Link(ISSUE_BASE_URL, "Project issues")
        )
)


data class ProjectCreator @JsonCreator constructor(val name: String,
                                                   val description: String,
                                                   val labels: Array<Label>,
                                                   val states: Array<State>,
                                                   val statesTransistions: Array<StateTransition>
)

data class StateTransition @JsonCreator constructor(val curr: State, val next: State)

data class Label @JsonCreator constructor(val value: String)

data class State @JsonCreator constructor(val value: String)