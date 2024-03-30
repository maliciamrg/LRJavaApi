package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.impl.AgLibraryFolderLabelControllerImpl;
import com.maliciamrg.lrjavaapi.controller.impl.CustomUtils;
import com.maliciamrg.lrjavaapi.dto.AgLibraryFolderLabelDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryFolderLabelMapper;
import com.maliciamrg.lrjavaapi.mapper.ReferenceMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryFolderLabel;
import com.maliciamrg.lrjavaapi.service.AgLibraryFolderLabelService;
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
public class AgLibraryFolderLabelControllerImplTest {
    //TODO: create the data Test generator class AgLibraryFolderLabelBuilder
    private static final String ENDPOINT_URL = "/ag-library-folder-label";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AgLibraryFolderLabelControllerImpl aglibraryfolderlabelController;
    @MockBean
    private AgLibraryFolderLabelService aglibraryfolderlabelService;
    @MockBean
    private AgLibraryFolderLabelMapper aglibraryfolderlabelMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AgLibraryFolderLabelControllerImpl(aglibraryfolderlabelService,aglibraryfolderlabelMapper)).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(aglibraryfolderlabelMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AgLibraryFolderLabelBuilder.getListDTO());

        Mockito.when(aglibraryfolderlabelService.findAll()).thenReturn(AgLibraryFolderLabelBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(aglibraryfolderlabelMapper.asDTO(ArgumentMatchers.any())).thenReturn(AgLibraryFolderLabelBuilder.getDTO());

        Mockito.when(aglibraryfolderlabelService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(AgLibraryFolderLabelBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idLocal", Is.is(1)));
        Mockito.verify(aglibraryfolderlabelService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(aglibraryfolderlabelService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(aglibraryfolderlabelMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgLibraryFolderLabelBuilder.getEntity());
        Mockito.when(aglibraryfolderlabelService.save(ArgumentMatchers.any(AgLibraryFolderLabel.class))).thenReturn(AgLibraryFolderLabelBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgLibraryFolderLabelBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(aglibraryfolderlabelService, Mockito.times(1)).save(ArgumentMatchers.any(AgLibraryFolderLabel.class));
        Mockito.verifyNoMoreInteractions(aglibraryfolderlabelService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(aglibraryfolderlabelMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgLibraryFolderLabelBuilder.getEntity());
        Mockito.when(aglibraryfolderlabelService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(AgLibraryFolderLabelBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgLibraryFolderLabelBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aglibraryfolderlabelService, Mockito.times(1)).update(ArgumentMatchers.any(AgLibraryFolderLabel.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(aglibraryfolderlabelService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(aglibraryfolderlabelService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aglibraryfolderlabelService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(aglibraryfolderlabelService);
    }
}