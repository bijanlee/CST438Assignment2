package cst438hw2.domain;

public class CityInfo
{
   public int ID;
   public String name;
   public String countryCode;
   public String countryName;
   public String district;
   public int population;
   public double temp;
   public long time;
   public int timezone;
   
   public CityInfo() { }
   
   public CityInfo(int iD, String name, String countryCode, String countryName, String district, int population,
         double temp, long time, int timezone)
   {
      ID = iD;
      this.name = name;
      this.countryCode = countryCode;
      this.countryName = countryName;
      this.district = district;
      this.population = population;
      this.temp = temp;
      this.time = time;
      this.timezone = timezone;
   }

   public int getID()
   {
      return ID;
   }

   public void setID(int iD)
   {
      ID = iD;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getCountryCode()
   {
      return countryCode;
   }

   public void setCountryCode(String countryCode)
   {
      this.countryCode = countryCode;
   }

   public String getCountryName()
   {
      return countryName;
   }

   public void setCountryName(String countryName)
   {
      this.countryName = countryName;
   }

   public String getDistrict()
   {
      return district;
   }

   public void setDistrict(String district)
   {
      this.district = district;
   }

   public int getPopulation()
   {
      return population;
   }

   public void setPopulation(int population)
   {
      this.population = population;
   }

   public double getTemp()
   {
      return temp;
   }

   public void setTemp(double temp)
   {
      this.temp = temp;
   }

   public long getTime()
   {
      return time;
   }

   public void setTime(long time)
   {
      this.time = time;
   }

   public int getTimezone()
   {
      return timezone;
   }

   public void setTimezone(int timezone)
   {
      this.timezone = timezone;
   }
   
}
