package com.ttuleja.Controller;

import com.ttuleja.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;

/**
 * Created by Tomal on 2017-06-14.
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Metoda pokazuje formularz rejestracji użytkownika
     * @return widok rejestracji użytkownika
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String addUserPanel() {

        return "register";
    }

    /**
     * Metoda rejestruje użytkownika w bazie danych jezeli to możliwe i podano poprawne dane
     * @param username nazwa użytkownika
     * @param pass hasło użytkownika
     * @param phone_number numer telefonu
     * @return przekierowanie na widok logowania lub przekierowanie na widok rejestracji jeżeli podano złe dane
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "username", defaultValue = " ") String username,
                          @RequestParam(value = "password", defaultValue = " ") String pass,
                          @RequestParam(value = "phone_number", defaultValue = " ") String phone_number) {

        String redirectUrlError = "/error";
        String redirectUrlSuccess = "/user/login";

        Pattern p = Pattern.compile("[a-zA-Z0-9]*");
        Pattern pphonenumber = Pattern.compile("[0-9]*");
        if (!p.matcher(username).matches()) return "redirect:" + redirectUrlError;
        if (!p.matcher(pass).matches()) return "redirect:" + redirectUrlError;
        if (!pphonenumber.matcher(phone_number).matches()) return "redirect:" + redirectUrlError;

        userService.addUser(username, pass, phone_number);
        return "redirect:" + redirectUrlSuccess;

    }

    /**
     * Metoda pokazuje formularz logowania
     * @return widok logowania
     */
    @RequestMapping(value = {"/login"})
    public String login() {
        return "login";
    }

    /**
     * Metoda pokazująca profil zalogowanego użytkownika
     * @param model przechowuje nazwę użytkownika
     * @return widok własnego profilu
     */
    @RequestMapping(value = "/my_profile", method = RequestMethod.GET)
    public String myProfile(Model model) {

        String user_name = userService.getUserName();
        model.addAttribute("user_name", user_name);
        return "my_profile";


    }

    /**
     * Metoda pokazuje profil danego użytkownika
     * @param target_name nazwa danego użytkownika
     * @param model przechowuje nazwę zalogowanego użytkownika, oraz docelowego użytkownika
     * @return widok błędu jeżeli nie istnieje docelowy użytkownik lub widok profilu docelowego użytkownika
     */
    @RequestMapping(value = "/user_profile/{user_name}", method = RequestMethod.GET)
    public String userProfile(@PathVariable("user_name") String target_name, Model model) {

        String user_name = userService.getUserName();

        if (target_name.equals(user_name)) return "my_profile";

        else if (userService.checkIfUserExists(target_name)) {

            model.addAttribute("user_name", user_name);
            model.addAttribute("target_name", target_name);
            return "user_profile";
        } else return "error";

    }

}
