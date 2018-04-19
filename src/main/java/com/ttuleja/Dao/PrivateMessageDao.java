package com.ttuleja.Dao;

import com.ttuleja.Entity.PrivateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Tomal on 2017-06-15.
 */
@Repository
public class PrivateMessageDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Metoda zwraca listę otrzymanych prywatnych wiadomości
     * @param user_name nazwa użytkownika
     * @return lista prywatnych wiadomości
     */
    public Collection<PrivateMessage> showReceivedPrivateMessages(String user_name) {
        String sql;
        Collection<PrivateMessage> private_messages;

        sql = "SELECT * FROM private_message WHERE receiver_name=? ORDER BY date DESC";
        private_messages = jdbcTemplate.query(sql, new BeanPropertyRowMapper(PrivateMessage.class), user_name);

        return private_messages;
    }

    /**
     * Metoda zwraca listę wysłanych prywatnych wiadomości
     * @param user_name nazwa użytkownika
     * @return lista wysłanych prywatnych wiadomości
     */
    public Collection<PrivateMessage> showSentPrivateMessages(String user_name) {
        String sql = "SELECT * FROM private_message WHERE author_name=? ORDER BY date DESC";
        Collection<PrivateMessage> sent_private_messages = jdbcTemplate.query(sql, new BeanPropertyRowMapper(PrivateMessage.class), user_name);

        return sent_private_messages;
    }

    /**
     * Metoda sprawdza, czy wiadomość należy do użytkownika.
     * @param id id wiadomości prywatnej
     * @param user_name nazwa użytkownika
     * @return 0 lub 1 w zależności od tego, czy użytkownik należy do wiadomości
     */
    public int checkIfMessageBelongsToUser(int id, String user_name) {
        String sql = "SELECT * FROM private_message WHERE private_message_id=? AND (receiver_name=? OR author_name=?)";

        try {
            jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(PrivateMessage.class), id, user_name, user_name);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
        return 1;

    }

    /**
     * Metoda pobiera z bazy danych prywatną wiadomość
     * @param id id wiadomości
     * @return wiadomość
     */
    public PrivateMessage showPrivateMessage(int id) {
        String sql = "SELECT * FROM private_message WHERE private_message_id=?";
        PrivateMessage message = (PrivateMessage) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(PrivateMessage.class), id);
        return message;
    }

    /**
     * Metoda wysyła do bazy danych prywatną wiadomość
     * @param user_name nazwa nadawcy
     * @param target_name nazwa odbiorcy
     * @param topic nazwa tematu
     * @param content treść wiadomości
     */
    public void sendPrivateMessage(String user_name, String target_name, String topic, String content) {
        String sql = "INSERT INTO private_message (author_name, receiver_name, topic, content) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{user_name, target_name, topic, content});

    }
}
