package com.example.sony.mainhi;

import java.util.Date;

/**
 * Created by SONY on 4/6/2018.
 */

public class MoneyLog {
    private double amount;
    private String content;
    private String category;
    private String date;
    private String note;

    public MoneyLog() {
    }

    public MoneyLog(int amount, String content, String category, String date, String note) {
        this.amount = amount;
        this.content = content;
        this.category = category;
        this.date = date;
        this.note = note;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "MoneyLog{" +
                "amount=" + amount +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", date=" + date +
                ", note='" + note + '\'' +
                '}';
    }
}
