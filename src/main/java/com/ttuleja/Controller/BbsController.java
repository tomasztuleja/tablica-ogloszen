package com.ttuleja.Controller;

import com.ttuleja.Service.BbsService;
import com.ttuleja.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

@Controller
public class BbsController {

    @Autowired
    private BbsService bbsService;

    @Autowired
    private UserService userService;

    /**
     * Metoda pokazująca listę przedmiotow
     * @param sort_by metoda sortowania
     * @param category nazwa kategorii
     * @param city nazwa miasta
     * @param model przechowuje liste przedmiotow
     * @return widok tablicy
     */
    @RequestMapping(value = "/")
    public String showItems(@RequestParam(value = "sort_by", defaultValue = "date") String sort_by,
                            @RequestParam(value = "category", defaultValue = "all") String category,
                            @RequestParam(value = "city", defaultValue = "all") String city, Model model) {


        model.addAttribute("items", bbsService.showItems(sort_by, category, city));
        model.addAttribute("categories", bbsService.showCategories());
        model.addAttribute("cities", bbsService.showCities());


        return "index";
    }

    /**
     * Metoda pokazuje opis ogłoszenia
     * @param id id ogloszenia
     * @param model przechowuje opis przedmiotu i numer telefonu
     * @return strona główna
     */
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String showItemDescription(@PathVariable("id") int id, Model model) {

        model.addAttribute("item_description", bbsService.showItemDescription(id));
        model.addAttribute("phone_number", bbsService.getUsersPhoneNumber(id));


        return "item_description";
    }

    /**
     * Metoda pokazuje panel dodawania ogłoszenia
     * @param model pozwala na wybór kategorii i miast
     * @return widok panelu dodawania ogłoszenia
     */
    @RequestMapping(value = "/add_item/", method = RequestMethod.GET)
    public String add_item_panel(Model model) {

        model.addAttribute("categories", bbsService.showCategories());
        model.addAttribute("cities", bbsService.showCities());

        return "add_item";
    }

    /**
     * Metoda dodaje ogłoszenie
     * @param item_description opis ogłoszenia
     * @param item_category kategoria przedmiotu
     * @param item_name nazwa przedmiotu
     * @param item_price cena przedmiotu
     * @param item_city nazwa miasta
     * @return strona główna lub błąd
     */
    @RequestMapping(value = "/add_item/", method = RequestMethod.POST)
    public String add_item(@RequestParam(value = "item_description", defaultValue = " ") String item_description,
                           @RequestParam(value = "item_category", defaultValue = " ") String item_category,
                           @RequestParam(value = "item_name", defaultValue = " ") String item_name,
                           @RequestParam(value = "item_price", defaultValue = " ") String item_price,
                           @RequestParam(value = "item_city", defaultValue = " ") String item_city) {

        String user_name = userService.getUserName();

        Pattern p = Pattern.compile("[0-9]*");
        if (!p.matcher(item_price).matches()) return "error";

        if (!(item_city.equals(" ")) && !(item_price.equals(" ")) && !(item_description.equals(" ")) && !(item_name.equals(" ")) && !(item_category.equals(" "))) {
            bbsService.addItem(item_city, item_price, item_category, user_name, item_description, item_name);

            String redirectUrl = "/";
            return "redirect:" + redirectUrl;

        } else {
            String redirectUrl = "/error";
            return "redirect:" + redirectUrl;
        }
    }

}
