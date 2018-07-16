package com.example.cjcucsie.weather;

import org.json.JSONException;
import org.json.JSONObject;

class Book {
    Double temp;
    Double pressure;
    Double humidity;
    Double temp_max;
    Double temp_min;
    Double sea_level;
    Double grnd_level;

    Book(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject mainJsonObject = jsonObject.getJSONObject("main");
            temp = mainJsonObject.getDouble("temp");
            pressure = mainJsonObject.getDouble("pressure");
            humidity = mainJsonObject.getDouble("humidity");
            temp_max = mainJsonObject.getDouble("temp_max");
            temp_min = mainJsonObject.getDouble("temp_min");
            sea_level = mainJsonObject.getDouble("sea_level");
            grnd_level = mainJsonObject.getDouble("grnd_level");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
//    private double coord1,coord2;
//    private String weather;
//    private double main;
//    private double wind;
//    private double clouds;
//    private String sys;
//
//    public Book() {
//        super();
//    }
//
//    public Book(double coord1, String weather, double main,double wind,double clouds,String sys) {
//        super();
//        this.coord1=coord.lon;
//        thus.coord2=
//
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public void show() {
//        System.out.println("name = " + name + "; price = " + price
//                + "; author = " + author);
//    }
}
