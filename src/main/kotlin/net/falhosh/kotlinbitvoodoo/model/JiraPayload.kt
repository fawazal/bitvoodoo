package net.falhosh.kotlinbitvoodoo.model


data class JiraPayload (
    var fields: Fields

)

data class Fields(
    var summary: String,
    var project: Project,
    var description: String = "",
    var issuetype: IssueType
)

data class IssueType (
    var id:String
)

data class Project (
    var key : String
)


