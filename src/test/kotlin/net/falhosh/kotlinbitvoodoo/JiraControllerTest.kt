package net.falhosh.kotlinbitvoodoo

import net.falhosh.kotlinbitvoodoo.model.ServiceResponseObject
import net.falhosh.kotlinbitvoodoo.service.JiraService
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class JiraControllerTest() {

    @Autowired
    lateinit var mockMvc:MockMvc

    @MockBean
    private lateinit var jiraService:JiraService

    @Test
    fun createJiraTicketTest()  {
            val testResponseObject = ServiceResponseObject("https://kotlinbitvoodoo.atlassian.net/browse/BT-31")
            given(jiraService.createJiraTicket("test")).willReturn(testResponseObject)

            mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/tickets").param("summary","test")
            ).andExpect(status().isOk).andExpect(jsonPath("$").isNotEmpty).andExpect(jsonPath("$.url").value("https://kotlinbitvoodoo.atlassian.net/browse/BT-31"))
    }

}
