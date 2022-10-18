package net.falhosh.kotlinbitvoodoo.service

import com.fasterxml.jackson.databind.ObjectMapper
import net.falhosh.kotlinbitvoodoo.model.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class JiraService () {
    @Value("\${jira.user-name}")
    private var username: String = ""

    @Value("\${jira.secret}")
    private  var secret: String = ""

    @Value("\${jira.base-url}")
    private  var baseUrl: String = "https://kotlinbitvoodoo.atlassian.net"

    @Value("\${jira.ticket-url}")
    private  var ticketCreationUrl: String = "/rest/api/2/issue"

    @Value("\${jira.project-key}")
    private  var projectKey: String = "BT"

    private val authString = "$username:$secret"
   // private val base64AuthString = Base64.getEncoder().encodeToString(authString.toByteArray())

    private val headers  = HttpHeaders()




    fun createJiraTicket(summary:String) : String {
        val jiraPayload = JiraPayload(Fields(summary = summary, project =  Project(projectKey!!), description = "",
            IssueType("10001")
        ))

        headers.setBasicAuth(username,secret)
        headers.contentType = MediaType.APPLICATION_JSON

        val objectMapper = ObjectMapper()

        val request = HttpEntity(objectMapper.writeValueAsString(jiraPayload),headers)
        val res = RestTemplate().postForEntity(baseUrl+ticketCreationUrl,request,ResponseObject::class.java).body

        //val responseObject = objectMapper.readValue<ResponseObject>(res)

        //val x = 1
        return baseUrl+"/browse/"+ res!!.key
    }



}
