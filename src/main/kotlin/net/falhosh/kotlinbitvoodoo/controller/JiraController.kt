package net.falhosh.kotlinbitvoodoo.controller

import net.falhosh.kotlinbitvoodoo.service.JiraService
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.view.RedirectView

@RestController
class JiraController(private val jiraService: JiraService) {

    @PostMapping("/tickets")
    fun createJiraTicket( @RequestParam summary: String):String {
        //RedirectView(jiraService.createJiraTicket(summary))
        return jiraService.createJiraTicket(summary)
    }
}

