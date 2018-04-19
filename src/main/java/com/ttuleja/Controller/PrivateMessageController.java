package com.ttuleja.Controller;

import com.ttuleja.Entity.PrivateMessage;
import com.ttuleja.Service.PrivateMessageService;
import com.ttuleja.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * Created by Tomal on 2017-06-15.
 */
@RequestMapping(value = "/private_messages")
@Controller
public class PrivateMessageController {

    @Autowired
    private UserService userService;

    @Autowired
    private PrivateMessageService privateMessageService;

    /**
     * Metoda pokazująca prywatne otrzymane wiadomości
     * @param model przechowuje kolekcję otrzymanych prywatnych wiadomości
     * @return widok odebranych prywatnych wiadomości
     */
    @RequestMapping("/")
    public String showReceivedPrivateMessages(Model model) {

        String user_name = userService.getUserName();

        Collection<PrivateMessage> receivedMessages = privateMessageService.showReceivedPrivateMessages(user_name);
        model.addAttribute("receivedMessages", receivedMessages);

        return "received_private_messages";
    }

    /**
     * Metoda pokazująca prywatne wysłane wiadomości
     * @param model przechowuje kolekcję wysłanych prywatnych wiadomości
     * @return widok wysłanych prywatnych wiadomości
     */
    @RequestMapping("/sent")
    public String showSentPrivateMessages(Model model) {

        String user_name = userService.getUserName();
        model.addAttribute("sentMessages", privateMessageService.showSentPrivateMessages(user_name));


        return "sent_private_messages";
    }

    /**
     * Metoda obsługująca wysyłanie prywatnej wiadomości
     * @param target_name nazwa odbiorcy
     * @param model przechowuje nazwy użytkowników
     * @return widok błędu lub widok do wysłania wiadomości
     */
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendPrivateMessage(@RequestParam(value = "user", defaultValue = " ") String target_name, Model model) {

        String user_name = userService.getUserName();

        if (userService.checkIfUserExists(target_name) && !(target_name.equals(user_name))) {
            model.addAttribute("target_name", target_name);
            model.addAttribute("user_name", user_name);

            return "send_private_message";
        } else return "error";
    }

    /**
     * Metoda wysyłająca prywatną wiadomość
     * @param topic temat wiadomości
     * @param content treść wiadomości
     * @param target_name nazwa odbiorcy
     * @return przekierowanie na widok listy prywatnych wiadomości
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendPrivateMessage(@RequestParam(value = "topic", defaultValue = " ") String topic,
                                     @RequestParam(value = "content", defaultValue = " ") String content,
                                     @RequestParam(value = "user", defaultValue = " ") String target_name) {

        String user_name = userService.getUserName();

        privateMessageService.sendPrivateMessage(user_name, target_name, topic, content);


        String redirectUrl = "/private_messages/";
        return "redirect:" + redirectUrl;
    }

    /**
     * Metoda pokazująca daną prywatną wiadomość
     * @param id id wiadomości
     * @param model przechowuje wiadomość
     * @return widok prywatnej wiadomości
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showEntireMessage(@PathVariable("id") int id, Model model) {

        String user_name = userService.getUserName();

        int check;
        check = privateMessageService.checkIfMessageBelongsToUser(id, user_name);

        if (check == 0) return "403";


        PrivateMessage msg = privateMessageService.showPrivateMessage(id);

        model.addAttribute("msg", msg);

        return "private_message";


    }


}
