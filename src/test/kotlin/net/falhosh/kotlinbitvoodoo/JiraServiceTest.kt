/*
package net.falhosh.kotlinbitvoodoo

import com.fasterxml.jackson.databind.ObjectMapper
import net.falhosh.kotlinbitvoodoo.model.ResponseObject
import net.falhosh.kotlinbitvoodoo.service.JiraService
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class JiraServiceTest() {

    @Autowired
    lateinit var mockMvc:MockMvc

    @MockBean
    private lateinit var jiraService:JiraService

    @Test
    fun createJiraTicketTest()  {
            val testResponseObject = ResponseObject("https://kotlinbitvoodoo.atlassian.net/browse/BT-31")
            given(jiraService.createJiraTicket("test")).willReturn(testResponseObject)

            val headers  = HttpHeaders()
            headers.setBasicAuth("testUser","testSecret")
            headers.contentType = MediaType.APPLICATION_JSON

            mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/rest/api/2/issue/").contentType(
                MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(ObjectMapper().writeValueAsString(testResponseObject)).headers(headers)
            ).andExpect(status().isOk).andExpect(jsonPath("$").isNotEmpty).andExpect(jsonPath("$.url").value("https://kotlinbitvoodoo.atlassian.net/browse/BT-31"))
    }

}*/
