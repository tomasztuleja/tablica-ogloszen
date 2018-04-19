package com.ttuleja.Dao;

import com.ttuleja.Entity.Category;
import com.ttuleja.Entity.City;
import com.ttuleja.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Tomal on 2017-06-16.
 */
@Repository
public class BbsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Metoda pobiera z bazy danych listę ogłoszeń
     * @param sort_by metoda sortowania
     * @param category wybrana kategoria
     * @param city wybrane miasto
     * @return lista ogłoszeń
     */
    public Collection<Item> showItems(String sort_by, String category, String city) {

        String sql;
        Collection<Item> items;

        if (category.equals("all") && city.equals("all")) {
            sql = String.format("SELECT * FROM item ORDER BY %s DESC", sort_by);
            items = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Item.class));
        } else if (city.equals("all")) {
            sql = String.format("SELECT * FROM item WHERE item_category=? ORDER BY %s DESC", sort_by);
            items = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Item.class), category);

        } else if (category.equals("all")) {
            sql = String.format("SELECT * FROM item WHERE item_city=? ORDER BY %s DESC", sort_by);
            items = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Item.class), city);

        } else {
            sql = String.format("SELECT * FROM item WHERE item_city=? AND item_category=? ORDER BY %s DESC", sort_by);
            items = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Item.class), city, category);
        }
        return items;
    }

    /**
     * Metoda pobiera z bazy danych dane ogłoszenie
     * @param id id ogłoszenia
     * @return lista zawierająca pojedyncze ogłoszenie
     */
    public Item showItemDescription(int id) {
        String sql = "SELECT * FROM item WHERE item_id=?";
        Item item_description = (Item) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Item.class), id);
        return item_description;

    }

    /**
     * Metoda pobiera z bazy danych numer telefonu użytkownika
     * @param id id użytkownika
     * @return numer telefonu
     */
    public String getUsersPhoneNumber(int id) {
        String sql = "SELECT user_name FROM item WHERE item_id=?";
        String user_name = jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);

        String sql1 = "SELECT phone_number FROM user WHERE user_name=?";
        String phone_number = jdbcTemplate.queryForObject(sql1, new Object[]{user_name}, String.class);

        return phone_number;
    }

    /**
     * Metoda pobiera z bazy danych listę kategorii do wyboru
     * @return kolekcja kategorii
     */
    public Collection<Category> showCategories() {

        String sql = "SELECT * FROM category";
        Collection<Category> categories = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Category.class));

        return categories;
    }

    /**
     * Metoda pobiera z bazy danych listę miast do wyboru
     * @return kolekcja miast
     */
    public Collection<City> showCities() {

        String sql = "SELECT * FROM city";
        Collection<City> cities = jdbcTemplate.query(sql, new BeanPropertyRowMapper(City.class));

        return cities;
    }

    /**
     * Metoda wysyła do bazy danych ogłoszenie
     * @param item_city nazwa miasta
     * @param item_price cena przedmiotu
     * @param item_category kategoria przedmiotu
     * @param user_name nazwa użytkownika, który wystawia przedmiot
     * @param item_description opis przedmiotu
     * @param item_name nazwa przedmiotu
     */
    public void addItem(String item_city, String item_price, String item_category, String user_name, String item_description, String item_name) {
        String sql = "INSERT INTO item (item_city,item_price, user_name, item_name, item_description, item_category) VALUES (?,?,?,?,?,?)";

        jdbcTemplate.update(sql, new Object[]{item_city, item_price, user_name, item_name, item_description, item_category});

    }

}
