package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.mapper.AdobeImagesMapper;
import com.maliciamrg.lrjavaapi.mapper.ReferenceMapper;
import com.maliciamrg.lrjavaapi.adobeimages.AdobeImages;
import com.maliciamrg.lrjavaapi.service.AdobeImagesService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AdobeImagesControllerImplTest {
    //TODO: create the data Test generator class AdobeImagesBuilder
    private static final String ENDPOINT_URL = "/adobe-images";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AdobeImagesControllerImpl adobeimagesController;
    @MockBean
    private AdobeImagesService adobeimagesService;
    @MockBean
    private AdobeImagesMapper adobeimagesMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AdobeImagesControllerImpl(adobeimagesService,adobeimagesMapper)).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(adobeimagesMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AdobeImagesBuilder.getListDTO());

        Mockito.when(adobeimagesService.findAll()).thenReturn(AdobeImagesBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(adobeimagesMapper.asDTO(ArgumentMatchers.any())).thenReturn(AdobeImagesBuilder.getDTO());

        Mockito.when(adobeimagesService.findById(ArgumentMatchers.anyInt())).thenReturn(java.util.Optional.of(AdobeImagesBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idLocal", Is.is(1)));
        Mockito.verify(adobeimagesService, Mockito.times(1)).findById(1);
        Mockito.verifyNoMoreInteractions(adobeimagesService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(adobeimagesMapper.asEntity(ArgumentMatchers.any())).thenReturn(AdobeImagesBuilder.getEntity());
        Mockito.when(adobeimagesService.save(ArgumentMatchers.any(AdobeImages.class))).thenReturn(AdobeImagesBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AdobeImagesBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(adobeimagesService, Mockito.times(1)).save(ArgumentMatchers.any(AdobeImages.class));
        Mockito.verifyNoMoreInteractions(adobeimagesService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(adobeimagesMapper.asEntity(ArgumentMatchers.any())).thenReturn(AdobeImagesBuilder.getEntity());
        Mockito.when(adobeimagesService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInt())).thenReturn(AdobeImagesBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AdobeImagesBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(adobeimagesService, Mockito.times(1)).update(ArgumentMatchers.any(AdobeImages.class), ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(adobeimagesService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(adobeimagesService).deleteById(ArgumentMatchers.anyInt());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(adobeimagesService, Mockito.times(1)).deleteById(Mockito.anyInt());
        Mockito.verifyNoMoreInteractions(adobeimagesService);
    }
}