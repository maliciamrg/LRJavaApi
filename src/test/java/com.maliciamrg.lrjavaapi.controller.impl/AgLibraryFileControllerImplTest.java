package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.impl.AgLibraryFileControllerImpl;
import com.maliciamrg.lrjavaapi.controller.impl.CustomUtils;
import com.maliciamrg.lrjavaapi.dto.AgLibraryFileDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryFileMapper;
import com.maliciamrg.lrjavaapi.mapper.ReferenceMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryFile;
import com.maliciamrg.lrjavaapi.service.AgLibraryFileService;
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
public class AgLibraryFileControllerImplTest {
    //TODO: create the data Test generator class AgLibraryFileBuilder
    private static final String ENDPOINT_URL = "/ag-library-file";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AgLibraryFileControllerImpl aglibraryfileController;
    @MockBean
    private AgLibraryFileService aglibraryfileService;
    @MockBean
    private AgLibraryFileMapper aglibraryfileMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AgLibraryFileControllerImpl(aglibraryfileService,aglibraryfileMapper)).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(aglibraryfileMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AgLibraryFileBuilder.getListDTO());

        Mockito.when(aglibraryfileService.findAll()).thenReturn(AgLibraryFileBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(aglibraryfileMapper.asDTO(ArgumentMatchers.any())).thenReturn(AgLibraryFileBuilder.getDTO());

        Mockito.when(aglibraryfileService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(AgLibraryFileBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idLocal", Is.is(1)));
        Mockito.verify(aglibraryfileService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(aglibraryfileService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(aglibraryfileMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgLibraryFileBuilder.getEntity());
        Mockito.when(aglibraryfileService.save(ArgumentMatchers.any(AgLibraryFile.class))).thenReturn(AgLibraryFileBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgLibraryFileBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(aglibraryfileService, Mockito.times(1)).save(ArgumentMatchers.any(AgLibraryFile.class));
        Mockito.verifyNoMoreInteractions(aglibraryfileService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(aglibraryfileMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgLibraryFileBuilder.getEntity());
        Mockito.when(aglibraryfileService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(AgLibraryFileBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgLibraryFileBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aglibraryfileService, Mockito.times(1)).update(ArgumentMatchers.any(AgLibraryFile.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(aglibraryfileService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(aglibraryfileService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aglibraryfileService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(aglibraryfileService);
    }
}