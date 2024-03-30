package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.impl.AgInternedExifCameraModelControllerImpl;
import com.maliciamrg.lrjavaapi.controller.impl.CustomUtils;
import com.maliciamrg.lrjavaapi.dto.AgInternedExifCameraModelDTO;
import com.maliciamrg.lrjavaapi.mapper.AgInternedExifCameraModelMapper;
import com.maliciamrg.lrjavaapi.mapper.ReferenceMapper;
import com.maliciamrg.lrjavaapi.model.AgInternedExifCameraModel;
import com.maliciamrg.lrjavaapi.service.AgInternedExifCameraModelService;
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
public class AgInternedExifCameraModelControllerImplTest {
    //TODO: create the data Test generator class AgInternedExifCameraModelBuilder
    private static final String ENDPOINT_URL = "/ag-interned-exif-camera-model";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AgInternedExifCameraModelControllerImpl aginternedexifcameramodelController;
    @MockBean
    private AgInternedExifCameraModelService aginternedexifcameramodelService;
    @MockBean
    private AgInternedExifCameraModelMapper aginternedexifcameramodelMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AgInternedExifCameraModelControllerImpl(aginternedexifcameramodelService,aginternedexifcameramodelMapper)).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(aginternedexifcameramodelMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AgInternedExifCameraModelBuilder.getListDTO());

        Mockito.when(aginternedexifcameramodelService.findAll()).thenReturn(AgInternedExifCameraModelBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(aginternedexifcameramodelMapper.asDTO(ArgumentMatchers.any())).thenReturn(AgInternedExifCameraModelBuilder.getDTO());

        Mockito.when(aginternedexifcameramodelService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(AgInternedExifCameraModelBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idLocal", Is.is(1)));
        Mockito.verify(aginternedexifcameramodelService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(aginternedexifcameramodelService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(aginternedexifcameramodelMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgInternedExifCameraModelBuilder.getEntity());
        Mockito.when(aginternedexifcameramodelService.save(ArgumentMatchers.any(AgInternedExifCameraModel.class))).thenReturn(AgInternedExifCameraModelBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgInternedExifCameraModelBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(aginternedexifcameramodelService, Mockito.times(1)).save(ArgumentMatchers.any(AgInternedExifCameraModel.class));
        Mockito.verifyNoMoreInteractions(aginternedexifcameramodelService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(aginternedexifcameramodelMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgInternedExifCameraModelBuilder.getEntity());
        Mockito.when(aginternedexifcameramodelService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(AgInternedExifCameraModelBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgInternedExifCameraModelBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aginternedexifcameramodelService, Mockito.times(1)).update(ArgumentMatchers.any(AgInternedExifCameraModel.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(aginternedexifcameramodelService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(aginternedexifcameramodelService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(aginternedexifcameramodelService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(aginternedexifcameramodelService);
    }
}