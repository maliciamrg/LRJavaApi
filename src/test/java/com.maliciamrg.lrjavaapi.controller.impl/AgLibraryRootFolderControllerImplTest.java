package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.impl.AgLibraryRootFolderControllerImpl;
import com.maliciamrg.lrjavaapi.controller.impl.CustomUtils;
import com.maliciamrg.lrjavaapi.dto.AgLibraryRootFolderDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryRootFolderMapper;
import com.maliciamrg.lrjavaapi.mapper.ReferenceMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryRootFolder;
import com.maliciamrg.lrjavaapi.service.AgLibraryRootFolderService;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AgLibraryRootFolderControllerImplTest {
    //TODO: create the data Test generator class AgLibraryRootFolderBuilder
    private static final String ENDPOINT_URL = "/ag-library-root-folder";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AgLibraryRootFolderControllerImpl aglibraryrootfolderController;
    @MockBean
    private AgLibraryRootFolderService aglibraryrootfolderService;
    @MockBean
    private AgLibraryRootFolderMapper aglibraryrootfolderMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AgLibraryRootFolderControllerImpl(aglibraryrootfolderService,aglibraryrootfolderMapper)).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(aglibraryrootfolderMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AgLibraryRootFolderBuilder.getListDTO());

        Mockito.when(aglibraryrootfolderService.findAll()).thenReturn(AgLibraryRootFolderBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(aglibraryrootfolderMapper.asDTO(ArgumentMatchers.any())).thenReturn(AgLibraryRootFolderBuilder.getDTO());

        Mockito.when(aglibraryrootfolderService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(AgLibraryRootFolderBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idLocal", Is.is(1)));
        Mockito.verify(aglibraryrootfolderService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(aglibraryrootfolderService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(aglibraryrootfolderMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgLibraryRootFolderBuilder.getEntity());
        Mockito.when(aglibraryrootfolderService.save(ArgumentMatchers.any(AgLibraryRootFolder.class))).thenReturn(AgLibraryRootFolderBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgLibraryRootFolderBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(aglibraryrootfolderService, Mockito.times(1)).save(ArgumentMatchers.any(AgLibraryRootFolder.class));
        Mockito.verifyNoMoreInteractions(aglibraryrootfolderService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(aglibraryrootfolderMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgLibraryRootFolderBuilder.getEntity());
        Mockito.when(aglibraryrootfolderService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(AgLibraryRootFolderBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgLibraryRootFolderBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aglibraryrootfolderService, Mockito.times(1)).update(ArgumentMatchers.any(AgLibraryRootFolder.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(aglibraryrootfolderService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(aglibraryrootfolderService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aglibraryrootfolderService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(aglibraryrootfolderService);
    }
}