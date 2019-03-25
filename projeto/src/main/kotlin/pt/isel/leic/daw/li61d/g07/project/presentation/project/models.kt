package pt.isel.leic.daw.li61d.g07.project.presentation.project

import com.fasterxml.jackson.annotation.JsonCreator
import pt.isel.leic.daw.li61d.g07.project.presentation.hateoas.HalObject
import pt.isel.leic.daw.li61d.g07.project.presentation.hateoas.Link
import pt.isel.leic.daw.li61d.g07.project.presentation.issue.ISSUE_BASE_URL
import java.text.MessageFormat

data class ProjectResult @JsonCreator constructor(val name: String,
                                                  val description: String) : HalObject(
        mapOf(
                "self" to Link(MessageFormat.format(PROJECT_URL, name), "Reload"),
                "http://docs.projects.api/rels/projects/issues" to Link(MessageFormat.format(ISSUE_BASE_URL, name), "Project issues")
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