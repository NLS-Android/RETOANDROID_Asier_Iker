package com.ciber.retoandroid_asier_iker;

import com.google.gson.annotations.SerializedName;

public class Post {

    private String lastactive_eur;
    private String lastactive_int;
    private int card_europe;
    private int card_international;
    private String current_card;

    public String getLastactive_eur() {
        return lastactive_eur;
    }
    public String getLastactive_int() {
        return lastactive_eur;
    }

    public int getCard_europe() {
        return card_europe;
    }

    public int getCard_international() {
        return card_international;
    }

    public String getCurrent_card() {
        return current_card;
    }
}
