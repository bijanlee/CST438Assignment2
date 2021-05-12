package cst438hw2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import cst438hw2.domain.City;
import cst438hw2.domain.CityInfo;
import cst438hw2.domain.CityRepository;
import cst438hw2.domain.Country;
import cst438hw2.domain.TimeAndTemp;

@SpringBootTest
public class CityServiceTest
{
   @MockBean
   private CityRepository cityRepository;
   
   @MockBean
   private WeatherService weatherService;
   
   @Autowired
   private CityService cityService;
   
   @BeforeEach
   public void setUpEach() {
      MockitoAnnotations.initMocks(this);
   }
   
   @Test
   public void test1() {
      Country country = new Country("TST", "Test Country");
      City city = new City(1, "TestCity", "DistrictTest", 100000, country);
      List<City> cities = new ArrayList<City>();
      cities.add(city);
      given(cityRepository.findByName("TestCity")).willReturn(cities);
      
      TimeAndTemp timeAndTemp = new TimeAndTemp(273.15, 100, 100);
      
      given(weatherService.getTimeAndTemp("TestCity")).willReturn(timeAndTemp);
      
      CityInfo cityInfo = cityService.getCityInfo("TestCity");
      
      assertThat(cityInfo.temp).isEqualTo(32.0);
   }
   
   @Test
   public void test2() {
      List<City> cities = new ArrayList<City>();
      given(cityRepository.findByName("TestCity")).willReturn(cities);
      
      CityInfo cityInfo = cityService.getCityInfo("TestCity");
      
      assertThat(cityInfo).isNull();
   }
   
   @Test
   public void test3() {
      Country country = new Country("TST", "Test Country");
      City city = new City(1, "TestCity", "DistrictTest", 100000, country);
      City city2 = new City(1, "TestCity", "DistrictTest", 100000, country);
      City city3 = new City(1, "TestCity", "DistrictTest", 100000, country);
      List<City> cities = new ArrayList<City>();
      cities.add(city);
      cities.add(city2);
      cities.add(city3);
   }
}
