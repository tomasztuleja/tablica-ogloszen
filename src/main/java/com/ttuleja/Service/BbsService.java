package com.ttuleja.Service;

import com.ttuleja.Dao.BbsDao;
import com.ttuleja.Entity.Category;
import com.ttuleja.Entity.City;
import com.ttuleja.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Tomal on 2017-06-16.
 */
@Service
public class BbsService {

    @Autowired
    private BbsDao bbsDao;

    /**
     * Metoda wywołuje metodę zwracającą listę ogłoszeń
     * @param sort_by metoda sortowania
     * @param category nazwa kategorii
     * @param city nazwa miasta
     * @return kolekcja ogłoszeń
     */
    public Collection<Item> showItems(String sort_by, String category, String city) {
        return this.bbsDao.showItems(sort_by, category, city);
    }

    /**
     * Metoda wywołuje metodę zwracającą treść ogłoszenia
     * @param id id ogłoszenia
     * @return treść ogłoszenia
     */
    public Item showItemDescription(int id) {
        return this.bbsDao.showItemDescription(id);

    }

    /**
     * Metoda wywołuje metodę zwracającą numer telefonu użytkownika
     * @param id id użytkownika
     * @return numer telefonu użytkownika
     */
    public String getUsersPhoneNumber(int id) {
        return this.bbsDao.getUsersPhoneNumber(id);

    }

    /**
     * Metoda wywołuje metodę zwracającą listę kategorii
     * @return lista kategorii
     */
    public Collection<Category> showCategories() {
        return this.bbsDao.showCategories();
    }

    /**
     * Metoda wywołuje metodę zwracającą listę miast
     * @return lista miast
     */
    public Collection<City> showCities() {
        return this.bbsDao.showCities();
    }

    /**
     * Metoda wywołuje metodę, która dodaje ogłoszenie do bazy danych
     * @param item_city miasto ogłoszenia
     * @param item_price cena przedmiotu
     * @param item_category kategoria przedmiotu
     * @param user_name nazwa użytkownika
     * @param item_description opis ogłoszenia
     * @param item_name nazwa ogłoszenia
     */
    public void addItem(String item_city, String item_price, String item_category, String user_name, String item_description, String item_name) {
        this.bbsDao.addItem(item_city, item_price, item_category, user_name, item_description, item_name);
    }

}
