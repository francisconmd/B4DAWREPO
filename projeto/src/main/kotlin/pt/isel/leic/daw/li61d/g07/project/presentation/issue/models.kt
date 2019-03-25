package pt.isel.leic.daw.li61d.g07.project.presentation.issue

import java.util.Date

data class Issue constructor(val id: Int,
                             val name: String,
                             val shortDescription: String,
                             val creationDate: Date,
                             val closeDate: Date?,
                             val labels: Array<String>,
                             val state: String)