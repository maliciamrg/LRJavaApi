package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.impl.AgLibraryKeywordControllerImpl;
import com.maliciamrg.lrjavaapi.controller.impl.CustomUtils;
import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryKeywordMapper;
import com.maliciamrg.lrjavaapi.mapper.ReferenceMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryKeyword;
import com.maliciamrg.lrjavaapi.service.AgLibraryKeywordService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AgLibraryKeywordControllerImplTest {
    //TODO: create the data Test generator class AgLibraryKeywordBuilder
    private static final String ENDPOINT_URL = "/ag-library-keyword";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AgLibraryKeywordControllerImpl aglibrarykeywordController;
    @MockBean
    private AgLibraryKeywordService aglibrarykeywordService;
    @MockBean
    private AgLibraryKeywordMapper aglibrarykeywordMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AgLibraryKeywordControllerImpl(aglibrarykeywordService,aglibrarykeywordMapper)).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(aglibrarykeywordMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AgLibraryKeywordBuilder.getListDTO());

        Mockito.when(aglibrarykeywordService.findAll()).thenReturn(AgLibraryKeywordBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(aglibrarykeywordMapper.asDTO(ArgumentMatchers.any())).thenReturn(AgLibraryKeywordBuilder.getDTO());

        Mockito.when(aglibrarykeywordService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(AgLibraryKeywordBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idLocal", Is.is(1)));
        Mockito.verify(aglibrarykeywordService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(aglibrarykeywordService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(aglibrarykeywordMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgLibraryKeywordBuilder.getEntity());
        Mockito.when(aglibrarykeywordService.save(ArgumentMatchers.any(AgLibraryKeyword.class))).thenReturn(AgLibraryKeywordBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgLibraryKeywordBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(aglibrarykeywordService, Mockito.times(1)).save(ArgumentMatchers.any(AgLibraryKeyword.class));
        Mockito.verifyNoMoreInteractions(aglibrarykeywordService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(aglibrarykeywordMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgLibraryKeywordBuilder.getEntity());
        Mockito.when(aglibrarykeywordService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(AgLibraryKeywordBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgLibraryKeywordBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aglibrarykeywordService, Mockito.times(1)).update(ArgumentMatchers.any(AgLibraryKeyword.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(aglibrarykeywordService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(aglibrarykeywordService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aglibrarykeywordService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(aglibrarykeywordService);
    }
}