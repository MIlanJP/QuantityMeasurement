package com.quantityymeasurement.demo.controller;

import com.google.gson.Gson;
import com.quantityymeasurement.demo.QuantityMeasurementApplication;
import com.quantityymeasurement.demo.enumeration.Units;
import com.quantityymeasurement.demo.exception.QuantityMeasurementResponseException;
import com.quantityymeasurement.demo.exception.UnitLengthException;
import com.quantityymeasurement.demo.model.Unit;
import com.quantityymeasurement.demo.service.QuantityMeasurementService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = {QuantityMeasurementApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class QuantityMeasurementControllerTest {

    @MockBean
    QuantityMeasurementService quantityMeasurementService;

    @InjectMocks
    QuantityMeasurementController quantityMeasurementController;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    Logger logger= LoggerFactory.getLogger(QuantityMeasurementControllerTest.class);

    @Before
    public void setUp() throws Exception{
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenUnits_whenSumRequested_shouldReturnHttpStatusAsOk() throws Exception {
        String[] listOfUnits={"inch:12","foot:13"};
        String value="YARD 2.0";
        Unit unit=new Unit(value,listOfUnits);
        Gson gson=new Gson();
        String json=gson.toJson(unit);
        System.out.println(json+"Printing json");
        when(quantityMeasurementService.add(anyList(), any())).
                thenReturn(new QuantityMeasurementService(Units.YARD,2.0));
        MvcResult result=this.mockMvc.perform(MockMvcRequestBuilders.get("/quantitymeasurement/sum/inch:12,foot:13/unit/yard")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String content=result.getResponse().getContentAsString();
        Assert.assertEquals(json,content);
        logger.info(content);
    }




    @Test
    public void givenUnits_whenthrownUnitLengthException_shouldReturnHttpStatusAsBadRequest() throws Exception {
        when(quantityMeasurementService.add(anyList(), any())).thenThrow(UnitLengthException.class);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/quantitymeasurement/sum/inch:12,foot:13/unit/inch")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void givenUnits_whenthrownIllegalArgumentException_shouldReturnHttpStatusAsBadRequest() throws Exception {
        when(quantityMeasurementService.add(anyList(), any())).thenThrow(QuantityMeasurementResponseException.class);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/quantitymeasurement/sum/inch:12,foot:13/unit/inch")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
