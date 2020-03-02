package com.tamara;

import java.util.Date;

public class CustomerJsonRecord {

    private String title;
    private Date purchaseDate;
    private int price;
    private String country;

    @Override
    public String toString() {
        return "CustomerDbRecord{" +
                "title='" + title + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", country='" + country + '\'' +
                "}\n";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
