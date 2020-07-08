package com.quantityymeasurement.demo.controller;

import com.google.gson.Gson;
import com.quantityymeasurement.demo.QuantityMeasurementApplication;
import com.quantityymeasurement.demo.enumeration.Units;
import com.quantityymeasurement.demo.exception.QuantityMeasurementResponseException;
import com.quantityymeasurement.demo.exception.UnitLengthException;
import com.quantityymeasurement.demo.model.Unit;
import com.quantityymeasurement.demo.response.UnitDto;
import com.quantityymeasurement.demo.service.QuantityMeasurementService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
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
    public void givenGetMethodandUnits_whenSumRequested_shouldReturnHttpStatusAsOk() throws Exception {
        String[] listOfUnits={"inch:12","foot:13"};
        String value="YARD 2.0";
        Unit unit=new Unit(value,listOfUnits);
        UnitDto unitDto=new UnitDto("Operation Sucessful","2.0",200);
        Gson gson=new Gson();
        String json=gson.toJson(unit);
        String resultContent=gson.toJson(unitDto);
        System.out.println(json+"Printing json");
        when(quantityMeasurementService.add(anyList(), any())).
                thenReturn(new QuantityMeasurementService(Units.YARD,2.0/(Double)Units.YARD.getValue()[1]));
        MvcResult result=this.mockMvc.perform(MockMvcRequestBuilders.get("/api/quantitymeasurement/sum/inch:12,foot:13/unit/yard")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String content=result.getResponse().getContentAsString();
        Assert.assertEquals(resultContent,content);
        logger.info(content);
    }


    @Test
    public void givenGetMethodUnits_whenSumRequested_shouldReturnHttpStatusAsOkNegativeTesting() throws Exception {
        String[] listOfUnits={"inch:12","foot:15"};
        String value="YARD 3.0";
        Unit unit=new Unit(value,listOfUnits);
        Gson gson=new Gson();
        String json=gson.toJson(unit);
        System.out.println(json+"Printing json");
        when(quantityMeasurementService.add(anyList(), any())).
                thenReturn(new QuantityMeasurementService(Units.YARD,2.0));
        MvcResult result=this.mockMvc.perform(MockMvcRequestBuilders.get("/quantitymeasurement/sum/inch:12,foot:13/unit/yard")
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        String content=result.getResponse().getContentAsString();
        Assert.assertNotEquals(400,result.getResponse().getStatus());
        Assert.assertNotEquals(json,content);
        logger.info(content);
    }

    @Test
    public void givenPostMethodAndUnits_whenSumRequested_shouldReturnHttpStatusAsOk() throws Exception {
        String[] listOfUnits={"inch:12","foot:15"};
        String value="FOOT";
        String resultvalue="FOOT 3.0";
        Unit unit=new Unit(value,listOfUnits);
        UnitDto unitDto=new UnitDto("Operation Sucessfull","3.0",200);
        Gson gson=new Gson();
        String parsejson=gson.toJson(unit);
        String comparejson=gson.toJson(unitDto);
        System.out.println(parsejson+"Printing json");
        when(quantityMeasurementService.add(anyList(), any())).
                thenReturn(new QuantityMeasurementService(Units.FOOT,3.0/(Double)Units.FOOT.getValue()[1]));
        when(quantityMeasurementService.getQuantity()).
                thenReturn(3.0);
        MvcResult result=this.mockMvc.perform(MockMvcRequestBuilders.post("/api/quantitymeasurement/sum")
                .contentType(MediaType.APPLICATION_JSON).content(parsejson)).andReturn();
        String content=result.getResponse().getContentAsString();
        Assert.assertEquals(200,result.getResponse().getStatus());
        Assert.assertEquals(comparejson,content);
        logger.info(content);
    }

    @Test
    public void givenPostMethodAndUnits_whenSumRequested_shouldReturnHttpStatusAsOkNegativeTesting() throws Exception {
        String[] listOfUnits={"inch:12","foot:15"};
        String value="YARD 2.0";
        Unit unit=new Unit(value,listOfUnits);
        Gson gson=new Gson();
        String json=gson.toJson(unit);
        when(quantityMeasurementService.add(anyList(), any())).
                thenReturn(new QuantityMeasurementService(Units.YARD,2.0));
        MvcResult result=this.mockMvc.perform(MockMvcRequestBuilders.post("/api/quantitymeasurement/sum")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andReturn();
        String content=result.getResponse().getContentAsString();
        Assert.assertNotEquals(415,result.getResponse().getStatus());
        Assert.assertNotEquals(json,content);
        logger.info(content);
    }

    @Test
    public void givenUnits_whenthrownUnitLengthException_shouldReturnHttpStatusAsBadRequest() throws Exception {
        when(quantityMeasurementService.add(anyList(), any())).thenThrow(UnitLengthException.class);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/quantitymeasurement/sum/inch:12,foot:13/unit/inch")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void givenUnits_whenthrownIllegalArgumentException_shouldReturnHttpStatusAsBadRequest() throws Exception {
        when(quantityMeasurementService.add(anyList(), any())).thenThrow(QuantityMeasurementResponseException.class);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/quantitymeasurement/sum/inch:12,foot:13/unit/inch")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void givenGetMethodAndUnits_whenConverted_ShouldReturnConvertedValue() throws Exception {
        when(quantityMeasurementService.convert(any(),any(),any())).thenReturn(2.0);
        MvcResult result=this.mockMvc.perform(MockMvcRequestBuilders.get("/api/quantitymeasurement/convert/FOOT/" +
                "12/INCH"))
                .andReturn();
        String output=result.getResponse().getContentAsString();
        Assert.assertEquals("2.0",output);
    }

    @Test
    public void givenGetMethodAndUnits_whenConverted_ShouldReturnConvertedValueNegativeTesting() throws Exception {
        when(quantityMeasurementService.convert(any(),any(),any())).thenReturn(2.0);
        MvcResult result=this.mockMvc.perform(MockMvcRequestBuilders.get("/api/quantitymeasurement/convert/foot" +
                ":12/to/inch")).andReturn();
        String output=result.getResponse().getContentAsString();
        Assert.assertNotEquals("3.0",output);
    }

    @Test
    public void set() {
        List<Units> listOfUnits=new ArrayList<Units>(EnumSet.allOf(Units.class));
        System.out.println(listOfUnits);
    }
}
