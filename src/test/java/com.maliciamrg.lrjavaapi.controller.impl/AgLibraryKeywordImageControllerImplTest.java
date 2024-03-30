package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.impl.AgLibraryKeywordImageControllerImpl;
import com.maliciamrg.lrjavaapi.controller.impl.CustomUtils;
import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordImageDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryKeywordImageMapper;
import com.maliciamrg.lrjavaapi.mapper.ReferenceMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryKeywordImage;
import com.maliciamrg.lrjavaapi.service.AgLibraryKeywordImageService;
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
public class AgLibraryKeywordImageControllerImplTest {
    //TODO: create the data Test generator class AgLibraryKeywordImageBuilder
    private static final String ENDPOINT_URL = "/ag-library-keyword-image";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AgLibraryKeywordImageControllerImpl aglibrarykeywordimageController;
    @MockBean
    private AgLibraryKeywordImageService aglibrarykeywordimageService;
    @MockBean
    private AgLibraryKeywordImageMapper aglibrarykeywordimageMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AgLibraryKeywordImageControllerImpl(aglibrarykeywordimageService,aglibrarykeywordimageMapper)).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(aglibrarykeywordimageMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AgLibraryKeywordImageBuilder.getListDTO());

        Mockito.when(aglibrarykeywordimageService.findAll()).thenReturn(AgLibraryKeywordImageBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(aglibrarykeywordimageMapper.asDTO(ArgumentMatchers.any())).thenReturn(AgLibraryKeywordImageBuilder.getDTO());

        Mockito.when(aglibrarykeywordimageService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(AgLibraryKeywordImageBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idLocal", Is.is(1)));
        Mockito.verify(aglibrarykeywordimageService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(aglibrarykeywordimageService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(aglibrarykeywordimageMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgLibraryKeywordImageBuilder.getEntity());
        Mockito.when(aglibrarykeywordimageService.save(ArgumentMatchers.any(AgLibraryKeywordImage.class))).thenReturn(AgLibraryKeywordImageBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgLibraryKeywordImageBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(aglibrarykeywordimageService, Mockito.times(1)).save(ArgumentMatchers.any(AgLibraryKeywordImage.class));
        Mockito.verifyNoMoreInteractions(aglibrarykeywordimageService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(aglibrarykeywordimageMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgLibraryKeywordImageBuilder.getEntity());
        Mockito.when(aglibrarykeywordimageService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(AgLibraryKeywordImageBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgLibraryKeywordImageBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aglibrarykeywordimageService, Mockito.times(1)).update(ArgumentMatchers.any(AgLibraryKeywordImage.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(aglibrarykeywordimageService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(aglibrarykeywordimageService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aglibrarykeywordimageService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(aglibrarykeywordimageService);
    }
}