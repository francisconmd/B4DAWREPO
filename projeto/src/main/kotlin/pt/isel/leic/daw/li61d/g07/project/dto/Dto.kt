package pt.isel.leic.daw.li61d.g07.project.dto

data class Project(private val name: String, 
                   private val shortDescription: String)

data class Label(private val name: String)

data class State(private val name: String)

data class Comment(private val text: String)

data class Issue(private val id: Int, 
                private val name: String,
                private val shortDescription: String,
                private val creationDate: String,
                private val closeDate: String,
                private val labels: Array<Label>)