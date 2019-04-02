package com.example.m6.model;

import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Planet implements Serializable {
    private String name;
    private double goodsPrice;
    private int coordinateX, coordinateY;
    private int techLevel;
    private int resource;
    private Map<String, Integer> stock = new HashMap<>();

    public Planet(String name, int coordinateX, int coordinateY, int techLevel, int resource) {
        this(name, 0, coordinateX, coordinateY, techLevel, resource);
    }
    public Planet(String name, double goodsPrice, int coordinateX, int coordinateY, int techLevel, int resource) {

        this.name = name;
        this.goodsPrice = goodsPrice;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.techLevel = techLevel;
        this.resource = resource;
        setStock(stock);
    }
    public Planet(String name, double goodsPrice, int coordinateX, int coordinateY, int techLevel, int resource, Map<String, Integer> stock) {

        this.name = name;
        this.goodsPrice = goodsPrice;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.techLevel = techLevel;
        this.resource = resource;
        this.stock = stock;
    }
    public void setStock(Map<String, Integer> map) {
        for(Goods g : Goods.values()) {
            map.put(g.toString().toLowerCase(), randInt(5, 30));
            Log.d("stock", String.valueOf(stock.get(g.toString().toLowerCase()))+" "+g.toString().toLowerCase()+" IN "+getName());
        }
    }

    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getGoodsPrice() {
        return goodsPrice;
    }
    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public int getCoordinateX() {
        return coordinateX;
    }
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }
    public int getCoordinateY() {
        return coordinateY;
    }
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public int getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
    public Map <String, Integer> getStock(){return stock;}
}
