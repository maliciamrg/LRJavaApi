package com.maliciamrg.lrcat.controller;

import com.maliciamrg.lrcat.controller.config.DomainConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(AgLibraryFileController.class)
@Import(DomainConfiguration.class)
class PocControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getFilesNotLogicOk() throws Exception {

        ResultActions resultActions = mockMvc.perform(
                post("/poc/getFilesNotLogic"));
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{ \"message\" : \"bob\" }"));

        resultActions
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(
                    content().json(
                        (
                            new ArrayList<String>(
                                Arrays.asList(
                                    "afoo01",
                                    "file3"
                                )
                            ).toString()
                        )
                    )
                )
                .andReturn()
        ;
    }

    @Test
    void getAnalyseResultOk() throws Exception {

        ResultActions resultActions = mockMvc.perform(
                post("/poc/getAnalyseResult"));
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{ \"message\" : \"bob\" }"));

        resultActions
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(
                        content().json("{phyKo:2,phyNb:5,logicKo:1,logicNb:4}"
                        )
                )
                .andReturn()
        ;
    }

}
