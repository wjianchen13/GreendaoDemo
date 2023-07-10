package com.example.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Card1 {

    @Id(autoincrement = true)
    private Long id;

    @Unique
    @NotNull
    private String cardCode;

    @Generated(hash = 1023828115)
    public Card1(Long id, @NotNull String cardCode) {
        this.id = id;
        this.cardCode = cardCode;
    }

    @Generated(hash = 1214975318)
    public Card1() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardCode() {
        return this.cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }
}
