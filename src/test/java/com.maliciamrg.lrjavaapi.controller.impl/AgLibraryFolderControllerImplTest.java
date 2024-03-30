package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.impl.AgLibraryFolderControllerImpl;
import com.maliciamrg.lrjavaapi.controller.impl.CustomUtils;
import com.maliciamrg.lrjavaapi.dto.AgLibraryFolderDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryFolderMapper;
import com.maliciamrg.lrjavaapi.mapper.ReferenceMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryFolder;
import com.maliciamrg.lrjavaapi.service.AgLibraryFolderService;
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
public class AgLibraryFolderControllerImplTest {
    //TODO: create the data Test generator class AgLibraryFolderBuilder
    private static final String ENDPOINT_URL = "/ag-library-folder";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AgLibraryFolderControllerImpl aglibraryfolderController;
    @MockBean
    private AgLibraryFolderService aglibraryfolderService;
    @MockBean
    private AgLibraryFolderMapper aglibraryfolderMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AgLibraryFolderControllerImpl(aglibraryfolderService,aglibraryfolderMapper)).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(aglibraryfolderMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AgLibraryFolderBuilder.getListDTO());

        Mockito.when(aglibraryfolderService.findAll()).thenReturn(AgLibraryFolderBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(aglibraryfolderMapper.asDTO(ArgumentMatchers.any())).thenReturn(AgLibraryFolderBuilder.getDTO());

        Mockito.when(aglibraryfolderService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(AgLibraryFolderBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idLocal", Is.is(1)));
        Mockito.verify(aglibraryfolderService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(aglibraryfolderService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(aglibraryfolderMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgLibraryFolderBuilder.getEntity());
        Mockito.when(aglibraryfolderService.save(ArgumentMatchers.any(AgLibraryFolder.class))).thenReturn(AgLibraryFolderBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgLibraryFolderBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(aglibraryfolderService, Mockito.times(1)).save(ArgumentMatchers.any(AgLibraryFolder.class));
        Mockito.verifyNoMoreInteractions(aglibraryfolderService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(aglibraryfolderMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgLibraryFolderBuilder.getEntity());
        Mockito.when(aglibraryfolderService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(AgLibraryFolderBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgLibraryFolderBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aglibraryfolderService, Mockito.times(1)).update(ArgumentMatchers.any(AgLibraryFolder.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(aglibraryfolderService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(aglibraryfolderService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aglibraryfolderService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(aglibraryfolderService);
    }
}