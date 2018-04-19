package com.ttuleja.Entity;

/**
 * Created by Tomal on 2017-06-16.
 */
public class Item {
    private int item_id;
    private String item_name;
    private String user_name;
    private String item_description;
    private String item_category;
    private String date;
    private int item_price;
    private String item_city;

    /**
     * Konstruktor ogłoszenia
     * @param item_id id ogłoszenia
     * @param item_name nazwa przedmiotu
     * @param user_name nazwa użytkownika
     * @param item_description opis przedmiotu
     * @param item_category kategoria przedmiotu
     * @param date data
     * @param item_price cena przedmiotu
     * @param item_city nazwa miasta
     */
    public Item(int item_id, String item_name, String user_name, String item_description, String item_category, String date, int item_price, String item_city) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.user_name = user_name;
        this.item_description = item_description;
        this.item_category = item_category;
        this.date = date;
        this.item_price = item_price;
        this.item_city = item_city;
    }

    public Item() {
    }

    /**
     * Metoda pobiera id ogłoszenia
     * @return id ogłoszenia
     */
    public int getItem_id() {
        return item_id;
    }

    /**
     * Metoda ustawia id ogłoszenia
     * @param item_id id ogłoszenia
     */
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    /**
     * Metoda pobiera nazwę przedmiotu
     * @return nazwa przedmiotu
     */
    public String getItem_name() {
        return item_name;
    }

    /**
     * Metoda ustawia nazwę przedmiotu
     * @param item_name nazwa przedmiotu
     */
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    /**
     * Metoda pobiera nazwę użytkownika
     * @return nazwa użytkownika
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * Metoda ustawia nazwę użytkownika
     * @param user_name nazwa użytkowika
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * Metoda pobiera opis przedmiotu
     * @return opis przedmiotu
     */
    public String getItem_description() {
        return item_description;
    }

    /**
     * Metoda ustawia opis przedmiotu
     * @param item_description opis przedmiotu
     */
    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    /**
     * Metoda pobiera kategorię przedmiotu
     * @return kategoria przedmiotu
     */
    public String getItem_category() {
        return item_category;
    }

    /**
     * Metoda ustawia kategorię przedmiotu
     * @param item_category kategoria przedmiotu
     */
    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    /**
     * Metoda pobiera datę wystawienia przedmiotu
     * @return data wystawienia przedmiotu
     */
    public String getDate() {
        return date;
    }

    /**
     * Metoda ustawia datę wystawienia przedmiotu
     * @param date data wystawienia przedmiotu
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Metoda pobiera cenę przedmiotu
     * @return cena przedmiotu
     */
    public int getItem_price() {
        return item_price;
    }

    /**
     * Metoda ustawia cenę przedmiotu
     * @param item_price cena przedmiotu
     */
    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    /**
     * Metoda pobiera miasto przedmiotu
     * @return miasto przedmiotu
     */
    public String getItem_city() {
        return item_city;
    }

    /**
     * Metoda ustawia miasto przedmiotu
     * @param item_city miasto przedmiotu
     */
    public void setItem_city(String item_city) {
        this.item_city = item_city;
    }
}
