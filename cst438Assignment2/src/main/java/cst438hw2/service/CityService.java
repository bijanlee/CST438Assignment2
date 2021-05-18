package cst438hw2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cst438hw2.domain.*;

@Service
public class CityService
{
   @Autowired
   private CityRepository cityRepository;
   
   @Autowired
   private CountryRepository countryRepository;
   
   @Autowired
   private WeatherService weatherService;
   
   
   public CityInfo getCityInfo(String cityName) {
     List<City> cities = cityRepository.findByName(cityName);
     
     if(cities.size() == 0) {
        return null;
     }
     
     City city = cities.get(0);
     Country country = city.getCountry();
   //Country country = countryRepository.findByCode(city.getCountry())
     //Do we even need countryRepository???
     
     TimeAndTemp timeAndTemp = weatherService.getTimeAndTemp(cityName);
     double tempF = Math.round((timeAndTemp.temp - 273.15) * 9.0/5.0 + 32.0);
     
     CityInfo cityInfo = new CityInfo(city.getID(), city.getName(), country.getCode(),
           country.getName(), city.getDistrict(), city.getPopulation(), tempF,
           timeAndTemp.time, timeAndTemp.timezone);
     
     return cityInfo;
   }
    
}
