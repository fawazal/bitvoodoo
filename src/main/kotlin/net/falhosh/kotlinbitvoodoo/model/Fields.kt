package net.falhosh.kotlinbitvoodoo.model

import com.google.gson.annotations.SerializedName

data class Fields(
    @SerializedName("summary")
    var summary: String,
    @SerializedName("project")
    var project: Project,
    @SerializedName("description")
    var description: String = "",
    @SerializedName("issuetype")
    var issuetype: IssueType
)