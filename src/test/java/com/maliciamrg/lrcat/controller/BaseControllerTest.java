package com.maliciamrg.lrcat.controller;

import com.maliciamrg.lrcat.controller.config.DomainConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BaseController.class)
@Import(DomainConfiguration.class)
class BaseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void greeting() throws Exception {

        ResultActions resultActions = mockMvc.perform(
                get("/"));

        resultActions
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string("Greetings from Spring Boot!"))
                .andReturn()
        ;
    }


}