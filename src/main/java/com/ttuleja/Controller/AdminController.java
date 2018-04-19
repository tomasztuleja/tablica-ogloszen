package com.ttuleja.Controller;

import com.ttuleja.Service.AdminService;
import com.ttuleja.Service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;

/**
 * Created by Tomal on 2017-06-16.
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BbsService bbsService;

    /**
     * Metoda pokazuje panel administratora
     * @return panel administratora
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String adminPanel() {


        return "admin_panel";
    }

    /**
     * Metoda usuwa ogłoszenie z bazy
     * @param id id ogłoszenia
     * @return strona główna
     */
    @RequestMapping(value = "/delete/item", method = RequestMethod.POST)
    public String deleteItem(@RequestParam(value = "id", defaultValue = " ") String id) {

        if (!(id.equals(" "))) adminService.deleteItem(id);

        String redirectUrl = "/";
        return "redirect:" + redirectUrl;
    }

    /**
     * Metoda pokazuje listę użytkowników
     * @param model przechowuje listę użytkowników
     * @return widok z listą użytkowników
     */
    @RequestMapping(value = "/list_all", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("user_list", adminService.showAllUsers());
        return "list_all";
    }

    /**
     * Metoda blokuje danego użytkownika
     * @param user_name nazwa użytkownika
     * @return przekierowanie na widok listy użytkowników
     */
    @RequestMapping(value = "/disable_user", method = RequestMethod.POST)
    public String disableUserByName(@RequestParam(value = "user_name", defaultValue = "") String user_name) {
        if (!(user_name.equals("admin"))) adminService.disableUserByName(user_name);
        String redirectUrl = "/admin/list_all";
        return "redirect:" + redirectUrl;
    }

    /**
     * Metoda odblokowuje danego użytkownika
     * @param user_name nazwa użytkownika
     * @return przekierowanie na widok listy użytkowników
     */
    @RequestMapping(value = "/enable_user", method = RequestMethod.POST)
    public String enableUserByName(@RequestParam(value = "user_name", defaultValue = "") String user_name) {
        if (!(user_name.equals("admin"))) adminService.enableUserByName(user_name);
        String redirectUrl = "/admin/list_all/";
        return "redirect:" + redirectUrl;
    }

    /**
     * Metoda pozwala na zarządzanie kategoriami ogłoszeń
     * @param model zawiera listę kategorii
     * @return widok strony zarządzania kategoriami
     */
    @RequestMapping(value = "/manage_categories", method = RequestMethod.GET)
    public String manageCategories(Model model) {
        model.addAttribute("categories", bbsService.showCategories());
        return "manage_categories";
    }

    /**
     * Metoda pozwala na zarządzanie miastami do wyboru
     * @param model zawiera listę miast
     * @return widok strony zarządzania miastami
     */
    @RequestMapping(value = "/manage_cities", method = RequestMethod.GET)
    public String manageCities(Model model) {
        model.addAttribute("cities", bbsService.showCities());
        return "manage_cities";
    }

    /**
     * Metoda dodaje nową kategorię ogłoszeń
     * @param category kategoria do dodania
     * @return widok strony zarządzania kategoriami lub błąd
     */
    @RequestMapping(value = "/add_category", method = RequestMethod.POST)
    public String addCategory(@RequestParam(value = "category_name", defaultValue = "") String category) {

        String redirectUrlError = "/error";

        Pattern p = Pattern.compile("[a-zA-Z0-9]*");
        if (!p.matcher(category).matches()) return "redirect:" + redirectUrlError;
        else {
            adminService.addCategory(category);
            String redirectUrl = "/admin/manage_categories";
            return "redirect:" + redirectUrl;
        }
    }

    /**
     * Metoda dodaje nowe miasto do wyboru
     * @param city miasto do dodania
     * @return widok strony zarządzania miastami lub błąd
     */
    @RequestMapping(value = "/add_city", method = RequestMethod.POST)
    public String addCity(@RequestParam(value = "city_name", defaultValue = "") String city) {

        String redirectUrlError = "/error";

        Pattern p = Pattern.compile("[a-zA-Z0-9]*");
        if (!p.matcher(city).matches()) return "redirect:" + redirectUrlError;
        else {
            adminService.addCity(city);
            String redirectUrl = "/admin/manage_cities";
            return "redirect:" + redirectUrl;
        }
    }

    /**
     * Metoda usuwa kategorię ogłoszeń
     * @param category kategoria do usunięcia
     * @return widok strony zarządzania kategoriami
     */
    @RequestMapping(value = "/delete_category", method = RequestMethod.POST)
    public String deleteCategory(@RequestParam(value = "category_name", defaultValue = "") String category) {

        adminService.deleteCategory(category);
        String redirectUrl = "/admin/manage_categories";
        return "redirect:" + redirectUrl;
    }

    /**
     * Metoda usuwa miasto do wyboru
     * @param city miasto do usunięcia
     * @return widok strony zarządzania miastami
     */
    @RequestMapping(value = "/delete_city", method = RequestMethod.POST)
    public String deleteCity(@RequestParam(value = "city_name", defaultValue = "") String city) {

        adminService.deleteCity(city);
        String redirectUrl = "/admin/manage_cities";
        return "redirect:" + redirectUrl;
    }


}
