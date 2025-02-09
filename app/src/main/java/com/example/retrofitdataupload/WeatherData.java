package com.example.retrofitdataupload;

import java.util.List;
import java.util.Map;

public class WeatherData {
   private int queryCost;
   private double latitude;
   private double longitude;
   private String resolvedAddress;
   private String address;
   private String timezone;
   private int tzoffset;
   private List<DayWeather> days;
   private Map<String, Station> stations;

   // Getters and setters

   public int getQueryCost() {
      return queryCost;
   }

   public void setQueryCost(int queryCost) {
      this.queryCost = queryCost;
   }

   public double getLatitude() {
      return latitude;
   }

   public void setLatitude(double latitude) {
      this.latitude = latitude;
   }

   public double getLongitude() {
      return longitude;
   }

   public void setLongitude(double longitude) {
      this.longitude = longitude;
   }

   public String getResolvedAddress() {
      return resolvedAddress;
   }

   public void setResolvedAddress(String resolvedAddress) {
      this.resolvedAddress = resolvedAddress;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getTimezone() {
      return timezone;
   }

   public void setTimezone(String timezone) {
      this.timezone = timezone;
   }

   public int getTzoffset() {
      return tzoffset;
   }

   public void setTzoffset(int tzoffset) {
      this.tzoffset = tzoffset;
   }

   public List<DayWeather> getDays() {
      return days;
   }

   public void setDays(List<DayWeather> days) {
      this.days = days;
   }

   public Map<String, Station> getStations() {
      return stations;
   }

   public void setStations(Map<String, Station> stations) {
      this.stations = stations;
   }
}

