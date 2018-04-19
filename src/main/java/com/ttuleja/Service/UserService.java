package com.ttuleja.Service;

import com.ttuleja.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Tomal on 2017-06-14.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * Metoda wywołuje metodę dodającą do bazy danych danego użytkownika
     * @param username nazwa użytkownika
     * @param pass hasło użytkownika
     * @param phone_number numer telefonu użytkownika
     */
    public void addUser(String username, String pass, String phone_number) {

        userDao.addUser(username, generate(pass), phone_number);
    }

    /**
     * Metoda szyfruje hasło użytkownika
     * @param pass hasło użytkownika
     * @return zaszyfrowane hasło
     */
    public static String generate(String pass) {
        int i = 0;
        String hashedPassword = "";
        while (i < 10) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            hashedPassword = passwordEncoder.encode(pass);
            i++;
        }
        return hashedPassword;
    }

    /**
     * Metoda wywołuje metodę zwracającą nazwę zalogowanego użytkownika
     * @return nazwa użytkownika
     */
    public String getUserName() {

        return this.userDao.getUserName();
    }

    /**
     * Metoda wywołuje metodę sprawdzającą, czy użytkownik o danej nazwie istnieje
     * @param target_name nazwa użytkownika
     * @return prawda jeżeli użytkownik istnieje, fałsz jeżeli nie
     */
    public boolean checkIfUserExists(String target_name) {
        return this.userDao.checkIfUserExists(target_name);
    }
}
