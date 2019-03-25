package pt.isel.leic.daw.li61d.g07.project.presentation.hateoas

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import pt.isel.leic.daw.li61d.g07.project.dto.Issue
import java.text.MessageFormat

/**
 * Class whose instances represent links, as described in <a href="https://tools.ietf.org/html/draft-kelly-json-hal-08">
 * JSON Hypertext Application Language</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Link @JsonCreator constructor(
        val href: String,
        val title: String? = null,
        val templated: Boolean? = null
)

/**
 * Abstract class to be used as a base class for HAL representations.
 */
abstract class HalObject(val _links: Map<String, Link>)

/**
 * Class used for error models, based on the <a href="https://tools.ietf.org/html/rfc7807">Problem Json spec</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ProblemJson(
        val type: String,
        val title: String,
        val detail: String,
        val status: Int
)

abstract class CollectionJson @JsonCreator constructor(
        val collection: CollectionJsonObject
)

data class CollectionJsonObject @JsonCreator constructor(
        val version: String = "1.0",
        val href: String,
        val links: Array<CollectionJsonLink>? = null,
        val items: Array<CollectionJsonItem>
)

data class CollectionJsonItem @JsonCreator constructor(
        val href: String,
        val data: Array<CollectionJsonItemProperty>,
        val links: Array<CollectionJsonLink>
)

data class CollectionJsonItemProperty @JsonCreator constructor(
        val name: String,
        val value: Any,
        val prompt: String
)

data class CollectionJsonLink @JsonCreator constructor(
        val rel: String,
        val href: String,
        val prompt: String? = null
)

class Issues constructor(
        issues: Array<Issue>
) : CollectionJson(
        CollectionJsonObject(
                href = MessageFormat.format("", id),
                items = issues.map {
                    CollectionJsonItem(
                            "",
                            arrayOf(
                                    CollectionJsonItemProperty("issueId", it.id, "Identifier"),
                                    CollectionJsonItemProperty("issueName", it.name, "Issue Name"),
                                    CollectionJsonItemProperty("issueDescription", it.description, "Issue Description"),
                                    CollectionJsonItemProperty("creationDate", it.creationDate, "Issue Creation Date"),
                                    CollectionJsonItemProperty("closedDate", it.closedDate, "Issue Closed Date")
                            ),
                            arrayOf(
                                    CollectionJsonLink("comments", "", "Issue Comments")
                            )
                    )
                }.toTypedArray()
        )
)