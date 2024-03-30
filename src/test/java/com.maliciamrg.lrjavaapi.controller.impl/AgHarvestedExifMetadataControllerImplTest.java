package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.impl.AgHarvestedExifMetadataControllerImpl;
import com.maliciamrg.lrjavaapi.controller.impl.CustomUtils;
import com.maliciamrg.lrjavaapi.dto.AgHarvestedExifMetadataDTO;
import com.maliciamrg.lrjavaapi.mapper.AgHarvestedExifMetadataMapper;
import com.maliciamrg.lrjavaapi.mapper.ReferenceMapper;
import com.maliciamrg.lrjavaapi.model.AgHarvestedExifMetadata;
import com.maliciamrg.lrjavaapi.service.AgHarvestedExifMetadataService;
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
public class AgHarvestedExifMetadataControllerImplTest {
    //TODO: create the data Test generator class AgHarvestedExifMetadataBuilder
    private static final String ENDPOINT_URL = "/ag-harvested-exif-metadata";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AgHarvestedExifMetadataControllerImpl agharvestedexifmetadataController;
    @MockBean
    private AgHarvestedExifMetadataService agharvestedexifmetadataService;
    @MockBean
    private AgHarvestedExifMetadataMapper agharvestedexifmetadataMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AgHarvestedExifMetadataControllerImpl(agharvestedexifmetadataService,agharvestedexifmetadataMapper)).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(agharvestedexifmetadataMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AgHarvestedExifMetadataBuilder.getListDTO());

        Mockito.when(agharvestedexifmetadataService.findAll()).thenReturn(AgHarvestedExifMetadataBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(agharvestedexifmetadataMapper.asDTO(ArgumentMatchers.any())).thenReturn(AgHarvestedExifMetadataBuilder.getDTO());

        Mockito.when(agharvestedexifmetadataService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(AgHarvestedExifMetadataBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idLocal", Is.is(1)));
        Mockito.verify(agharvestedexifmetadataService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(agharvestedexifmetadataService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(agharvestedexifmetadataMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgHarvestedExifMetadataBuilder.getEntity());
        Mockito.when(agharvestedexifmetadataService.save(ArgumentMatchers.any(AgHarvestedExifMetadata.class))).thenReturn(AgHarvestedExifMetadataBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgHarvestedExifMetadataBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(agharvestedexifmetadataService, Mockito.times(1)).save(ArgumentMatchers.any(AgHarvestedExifMetadata.class));
        Mockito.verifyNoMoreInteractions(agharvestedexifmetadataService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(agharvestedexifmetadataMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgHarvestedExifMetadataBuilder.getEntity());
        Mockito.when(agharvestedexifmetadataService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(AgHarvestedExifMetadataBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(AgHarvestedExifMetadataBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(agharvestedexifmetadataService, Mockito.times(1)).update(ArgumentMatchers.any(AgHarvestedExifMetadata.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(agharvestedexifmetadataService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(agharvestedexifmetadataService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(agharvestedexifmetadataService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(agharvestedexifmetadataService);
    }
}
