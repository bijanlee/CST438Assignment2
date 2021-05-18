package cst438hw2.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;

import cst438hw2.service.CityService;

import cst438hw2.domain.*;

@WebMvcTest(CityRestController.class)
public class CityRestControllerTest
{
   @MockBean
   private CityService cityService;
   
   @Autowired
   private MockMvc mvc;
   
   private JacksonTester<CityInfo> jsonCityAttempt;
   
   @BeforeEach
   public void setUpEach() {
      MockitoAnnotations.initMocks(this);
      JacksonTester.initFields(this, new ObjectMapper());
   }
   
   @Test
   public void test1() throws Exception {
      /*Country country = new Country("TST", "Test Country");
      City city = new City(1, "TestCity", "DistrictTest", 100000, country);
      List<City> cities = new ArrayList<City>();*/
      
      CityInfo returnValue = new CityInfo(1, "TestCity", "TST", "Test Country", "DistrictTest", 100000, 80.0, 100000, 1000);
      
      given(cityService.getCityInfo("TestCity")).willReturn(returnValue);
      
      MockHttpServletResponse response = mvc.perform(get("/api/cities/TestCity")).andReturn().getResponse();
      
      assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
      
      CityInfo cityInfo = jsonCityAttempt.parseObject(response.getContentAsString());
      
      CityInfo expectedResult = new CityInfo(1, "TestCity", "TST", "Test Country", "DistrictTest", 100000,
            80.0, 100000, 1000);
      
      assertThat(cityInfo.ID).isEqualTo(expectedResult.ID);
      assertThat(cityInfo.name).isEqualTo(expectedResult.name);
      assertThat(cityInfo.countryCode).isEqualTo(expectedResult.countryCode);
   }
   
   @Test
   public void test2() throws Exception {
      //CityInfo returnValue = new CityInfo(1, "TestCity", "TST", "Test Country", "DistrictTest", 100000, 80.0, 100000, 1000);
      CityInfo returnValue = null;
      
      given(cityService.getCityInfo("TestCity")).willReturn(returnValue);
      
      MockHttpServletResponse response = mvc.perform(get("/api/cities/TestCity")).andReturn().getResponse();
      
      assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());;
   }
}
