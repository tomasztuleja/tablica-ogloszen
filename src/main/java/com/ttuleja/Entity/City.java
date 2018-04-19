package com.ttuleja.Entity;

/**
 * Created by Tomal on 2017-06-16.
 */
public class City {

    private int city_id;
    private String city_name;

    /**
     * Konstruktor miasta
     * @param city_id id miasta
     * @param city_name nazwa miasta
     */
    public City(int city_id, String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }

    public City() {
    }

    /**
     * Metoda pobiera id miasta
     * @return id miasta
     */
    public int getCity_id() {
        return city_id;
    }

    /**
     * Metoda ustawia id miasta
     * @param city_id id miasta
     */
    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    /**
     * Metoda pobiera nazwę miasta
     * @return nazwa miasta
     */
    public String getCity_name() {
        return city_name;
    }

    /**
     * Metoda ustawia nazwę miasta
     * @param city_name nazwa miasta
     */
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
