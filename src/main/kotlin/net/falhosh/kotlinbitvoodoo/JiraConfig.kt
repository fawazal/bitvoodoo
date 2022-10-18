package net.falhosh.kotlinbitvoodoo

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "jira")
data class JiraConfig (
                var jiraSecret: String = "",
                var userName: String = "",
                var baseUrl: String = "",
                var ticketUrl: String = "",
                var projectKey: String = ""
)
