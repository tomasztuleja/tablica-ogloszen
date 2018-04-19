package com.ttuleja.Entity;

/**
 * Created by Tomal on 2017-06-15.
 */
public class PrivateMessage {

    private int private_message_id;
    private String author_name;
    private String receiver_name;
    private String topic;
    private String content;
    private String date;

    /**
     * Kontruktor prywatnej wiadomości
     * @param private_message_id id prywatnej wiadomości
     * @param author_name nazwa nadawcy
     * @param receiver_name nazwa odbiorcy
     * @param topic temat
     * @param content treść wiadomości
     * @param date data wysłania
     */
    public PrivateMessage(int private_message_id, String author_name, String receiver_name, String topic, String content, String date) {
        this.private_message_id = private_message_id;
        this.author_name = author_name;
        this.receiver_name = receiver_name;
        this.topic = topic;
        this.content = content;
        this.date = date;
    }

    public PrivateMessage() {
    }

    /**
     * Metoda pobiera id prywatnej wiadomości
     * @return id prywatnej wiadomości
     */
    public int getPrivate_message_id() {
        return private_message_id;
    }

    /**
     * Metoda ustawia id prywatnej wiadomości
     * @param private_message_id id prywatnej wiadomości
     */
    public void setPrivate_message_id(int private_message_id) {
        this.private_message_id = private_message_id;
    }

    /**
     * Metoda pobiera nazwę nadawcy
     * @return nazwa nadawcy
     */
    public String getAuthor_name() {
        return author_name;
    }

    /**
     * Metoda ustawia nazwę nadawcy
     * @param author_name nazwa nadawcy
     */
    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    /**
     * Metoda pobiera nazwę odbiorcy
     * @return nazwa odbiorcy
     */
    public String getReceiver_name() {
        return receiver_name;
    }

    /**
     * Metoda ustawia nazwę odbiorcy
     * @param receiver_name nazwa odbiorcy
     */
    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    /**
     * Metoda pobiera nazwę tematu
     * @return nazwa tematu
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Metoda ustawia nazwę tematu
     * @param topic nazwa tematu
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Metoda pobiera treść wiadomości
     * @return treść wiadomości
     */
    public String getContent() {
        return content;
    }

    /**
     * Metoda ustawia treść wiadomości
     * @param content treść wiadomości
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Metoda pobiera datę wysłania
     * @return data wysłania
     */
    public String getDate() {
        return date;
    }

    /**
     * Metoda ustawia datę wsyłania
     * @param date data wysłania
     */
    public void setDate(String date) {
        this.date = date;
    }
}
