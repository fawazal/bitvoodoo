package net.falhosh.kotlinbitvoodoo.model

import com.google.gson.annotations.SerializedName


data class JiraPayload (

    @SerializedName("fields")
    var fields: Fields

)

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

data class IssueType (
    @SerializedName("id")
    var id:String
)

data class Project (
    @SerializedName("key")
    var key : String
)


