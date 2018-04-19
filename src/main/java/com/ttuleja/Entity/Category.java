package com.ttuleja.Entity;

/**
 * Created by Tomal on 2017-06-16.
 */
public class Category {
    private int category_id;
    private String category_name;

    /**
     * Konstruktor kategorii
     * @param category_id id kategorii
     * @param category_name nazwa kategorii
     */
    public Category(int category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public Category() {
    }

    /**
     * Metoda pobiera id kategorii
     * @return id kategorii
     */
    public int getCategory_id() {
        return category_id;
    }

    /**
     * Metoda ustawia id kategorii
     * @param category_id id kategorii
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    /**
     * Metoda pobiera nazwę kategorii
     * @return nazwa kategorii
     */
    public String getCategory_name() {
        return category_name;
    }

    /**
     * Metoda ustawia nazwę kategorii
     * @param category_name nazwa kategorii
     */
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
