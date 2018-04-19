package com.ttuleja.Service;

import com.ttuleja.Dao.AdminDao;
import com.ttuleja.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Tomal on 2017-06-16.
 */
@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    /**
     * Metoda wywołuje metodę, która usuwa ogłoszenie
     * @param id id ogłoszenia
     */
    public void deleteItem(String id) {
        this.adminDao.deleteItem(id);
    }

    /**
     * Metoda wywołuje metodę, która zwraca listę wszystkich użytkowników
     * @return lista użytkowników
     */
    public Collection<User> showAllUsers() {
        return this.adminDao.showAllUsers();
    }

    /**
     * Metoda wywołuje metodę, która wyłącza danego użytkownika
     * @param user_name nazwa użytkownika
     */
    public void disableUserByName(String user_name) {
        this.adminDao.disableUserByName(user_name);
    }

    /**
     * Metoda wywołuje metodę, która włącza danego użytkownika
     * @param user_name nazwa użytkownika
     */
    public void enableUserByName(String user_name) {
        this.adminDao.enableUserByName(user_name);
    }

    /**
     * Metoda wywołuje metodę, która usuwa daną kategorię
     * @param category nazwa kategoria
     */
    public void deleteCategory(String category) {
        this.adminDao.deleteCategory(category);
    }

    /**
     * Metoda wywołuje metodę, która usuwa dane miasto
     * @param city nazwa miasta
     */
    public void deleteCity(String city) {
        this.adminDao.deleteCity(city);
    }

    /**
     * Metoda wywołuje metodę, która dodaje kategorię
     * @param category nazwa kategorii
     */
    public void addCategory(String category) {
        this.adminDao.addCategory(category);
    }

    /**
     * Metoda wywołuje metodę, która dodaje miasto
     * @param city nazwa miasta
     */
    public void addCity(String city) {
        this.adminDao.addCity(city);
    }
}
