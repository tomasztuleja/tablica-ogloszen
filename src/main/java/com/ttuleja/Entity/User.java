package com.ttuleja.Entity;

/**
 * Created by Tomal on 2017-06-14.
 */
public class User {

    private int user_id;
    private String user_name;
    private String user_password;
    private String user_role;
    private int user_status;
    private int phone_number;

    /**
     * Konstruktor konta użytkownika
     * @param user_id id użytkownika
     * @param user_name nazwa użytkownika
     * @param user_password hasło użytkownika
     * @param user_role rola użytkownika
     * @param user_status status użytkownika
     * @param phone_number numer telefonu użytkownika
     */
    public User(int user_id, String user_name, String user_password, String user_role, int user_status, int phone_number) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_role = user_role;
        this.user_status = user_status;
        this.phone_number = phone_number;
    }

    public User() {
    }

    /**
     * Metoda pobiera id użytkownika
     * @return id użytkownika
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Metoda ustawia id użytkownika
     * @param user_id id użytkownika
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
     * @param user_name nazwa użytkownika
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * Metoda pobiera hasło użytkownika
     * @return hasło użytkownika
     */
    public String getUser_password() {
        return user_password;
    }

    /**
     * Metoda ustawia hasło użytkownika
     * @param user_password hasło użytkownika
     */
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    /**
     * Metoda pobiera rolę użytkownika
     * @return rola użytkownika
     */
    public String getUser_role() {
        return user_role;
    }

    /**
     * Metoda ustawia rolę użytkownika
     * @param user_role rola użytkownika
     */
    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    /**
     * Metoda pobiera status użytkownika
     * @return status użytkownika
     */
    public int getUser_status() {
        return user_status;
    }

    /**
     * Metoda ustawia status użytkownika
     * @param user_status status uzytkownika
     */
    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }

    /**
     * Metoda pobiera numer telefonu użytkownika
     * @return numer telefonu użytkownika
     */
    public int getPhone_number() {
        return phone_number;
    }

    /**
     * Metoda ustawia numer telefonu użytkownika
     * @param phone_number numer telefonu uzytkownika
     */
    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
}
