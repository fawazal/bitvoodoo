package net.falhosh.kotlinbitvoodoo.controller

import net.falhosh.kotlinbitvoodoo.model.ServiceResponseObject
import net.falhosh.kotlinbitvoodoo.service.JiraService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class JiraController(private val jiraService: JiraService) {

    @PostMapping("/tickets")
    fun createJiraTicket( @RequestParam summary: String): ServiceResponseObject {
        return jiraService.createJiraTicket(summary)
    }
}

