package net.falhosh.kotlinbitvoodoo.service

import com.fasterxml.jackson.databind.ObjectMapper
import net.falhosh.kotlinbitvoodoo.JiraConfig
import net.falhosh.kotlinbitvoodoo.model.*
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
@EnableConfigurationProperties
class JiraService (private val jiraConfig: JiraConfig) {

    fun createJiraTicket(summary:String) : ResponseObject {
        val jiraPayload = JiraPayload(Fields(summary = summary, project =  Project(jiraConfig.projectKey), description = "",
            IssueType("10001")
        ))

        val headers  = HttpHeaders()
        headers.setBasicAuth(jiraConfig.userName,jiraConfig.jiraSecret)
        headers.contentType = MediaType.APPLICATION_JSON

        val objectMapper = ObjectMapper()

        val request = HttpEntity(objectMapper.writeValueAsString(jiraPayload),headers)
        val res = RestTemplate().postForObject(jiraConfig.baseUrl+jiraConfig.ticketUrl,request,ResponseObject::class.java)

        return ResponseObject(url = jiraConfig.baseUrl+"/browse/"+ res!!.key)
    }



}
