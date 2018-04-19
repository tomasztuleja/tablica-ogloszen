package com.ttuleja.Service;

import com.ttuleja.Dao.PrivateMessageDao;
import com.ttuleja.Entity.PrivateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Tomal on 2017-06-15.
 */
@Service
public class PrivateMessageService {

    @Autowired
    private PrivateMessageDao privateMessageDao;

    /**
     * Metoda wywołuje metodę zwracającą listę otrzymanych prywatnych wiadomości należących do danego użytkownika
     * @param user_name nazwa użytkownika
     * @return lista wiadomości prywatnych
     */
    public Collection<PrivateMessage> showReceivedPrivateMessages(String user_name) {
        return this.privateMessageDao.showReceivedPrivateMessages(user_name);

    }

    /**
     * Metoda wywołuje metodę zwracającą listę wysłanych prywatnych wiadomości przez danego użytkownika
     * @param user_name nazwa użytkownika
     * @return lista wiadomości wysłanych lub null
     */
    public Collection<PrivateMessage> showSentPrivateMessages(String user_name) {
        return this.privateMessageDao.showSentPrivateMessages(user_name);

    }

    /**
     * Metoda wywołuje metodę zwracającą informację o tym, czy dana wiadomość prywatna należy do danego użytkownika
     * @param id id wiadomości
     * @param user_name nazwa użytkownika
     * @return 1 jeżeli wiadomość należy do użytkownika, 0 jeżeli nie
     */
    public int checkIfMessageBelongsToUser(int id, String user_name) {
        return this.privateMessageDao.checkIfMessageBelongsToUser(id, user_name);

    }

    /**
     * Metoda wywołuje metodę zwracającą daną otrzymaną prywatną wiadomość
     * @param id id wiadomości
     * @return lista zawierająca jedną wiadomość
     */
    public PrivateMessage showPrivateMessage(int id) {
        return this.privateMessageDao.showPrivateMessage(id);

    }

    /**
     * Metoda wywołuje metodę, która zapisuje w bazie danych prywatną wiadomość
     * @param user_name nazwa nadawcy
     * @param target_name nazwa odbiorcy
     * @param topic nazwa tematu
     * @param content treść wiadomości
     */
    public void sendPrivateMessage(String user_name, String target_name, String topic, String content) {
        this.privateMessageDao.sendPrivateMessage(user_name, target_name, topic, content);

    }
}
