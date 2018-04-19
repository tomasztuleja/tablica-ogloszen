package com.ttuleja.Dao;

import com.ttuleja.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomal on 2017-06-14.
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Metoda dodaje do bazy danych użytkownika
     * @param username nazwa użytkownika
     * @param pass hasło użytkownika
     * @param phone_number numer telefonu użytkownika
     */
    public void addUser(String username, String pass, String phone_number) {
        String sql = "INSERT INTO user (user_name,user_password,phone_number) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[]{username, pass, phone_number});
    }

    /**
     * Metoda pobiera z bazy danych nazwę zalogowanego użytkownika
     * @return nazwa użytkownika
     */
    public String getUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user_name = auth.getName();
        return user_name;
    }

    /**
     * Metoda sprawdza czy użytkownik istnieje
     * @param target_name nazwa użytkownika
     * @return prawda jeżeli użytkownik istnieje, fałsz jeżeli nie
     */
    public boolean checkIfUserExists(String target_name) {
        try {
            String sql = "SELECT * FROM user WHERE user_name=?";
            jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(User.class), target_name);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }
}
