package com.ciber.retoandroid_asier_iker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("lastactive_eur")
    @Expose
    private String lastactiveEur;
    @SerializedName("lastactive_int")
    @Expose
    private String lastactiveInt;
    @SerializedName("card_europe")
    @Expose
    private String cardEurope;
    @SerializedName("card_international")
    @Expose
    private String cardInternational;
    @SerializedName("current_card")
    @Expose
    private String currentCard;

    public String getLastactiveEur() {
        return lastactiveEur;
    }

    public void setLastactiveEur(String lastactiveEur) {
        this.lastactiveEur = lastactiveEur;
    }

    public String getLastactiveInt() {
        return lastactiveInt;
    }

    public void setLastactiveInt(String lastactiveInt) {
        this.lastactiveInt = lastactiveInt;
    }

    public String getCardEurope() {
        return cardEurope;
    }

    public void setCardEurope(String cardEurope) {
        this.cardEurope = cardEurope;
    }

    public String getCardInternational() {
        return cardInternational;
    }

    public void setCardInternational(String cardInternational) {
        this.cardInternational = cardInternational;
    }

    public String getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(String currentCard) {
        this.currentCard = currentCard;
    }
}
