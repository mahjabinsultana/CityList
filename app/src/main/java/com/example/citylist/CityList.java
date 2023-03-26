package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities(Integer n) { // if n==1 then sort by city else sort by province
        List<City> cityList = cities;

        Comparator<City> compareBycityname = (City o1, City o2) ->
                o1.getCityName().compareTo( o2.getCityName() );

        Comparator<City> compareByprovincename = (City o1, City o2) ->
                o1.getProvinceName().compareTo( o2.getProvinceName() );

        if(n==1)Collections.sort(cityList, compareBycityname);
        else Collections.sort(cityList, compareByprovincename);

        return cityList;
    }


    /**
     * This deletes city from the list if city exists in the list
     * @param city
     *      This is the city to delete
     */
    public void delete(City city) {
        if (!cities.contains(city)) {

            throw new IllegalArgumentException();
        }
        cities.remove(city);


    }

    /**
     * This counts the number of city in the list
     */
    public Integer count() {
            return cities.size();
    }


}
