package com.example.m6.model;

import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * planet class
 */
@SuppressWarnings({"ChainedMethodCall", "SameParameterValue",
        "AssignmentOrReturnOfFieldWithMutableType", "ConstructorWithTooManyParameters",
        "ClassWithTooManyDependents"})
public class Planet implements Serializable {
    private String name;
    private int coordinateX;
    private int coordinateY;
    private int techLevel;
    private int resource;
    private Map<String, Integer> stock = new HashMap<>();


    /**
     * empty constructor
     */
    public Planet(){}

    /**
     * planet constructor
     * @param name name
     * @param coordinateX coordinate x
     * @param coordinateY coordinate y
     * @param techLevel tech level
     * @param resource resource
     */
    public Planet(String name, int coordinateX, int coordinateY, int techLevel, int resource) {
        this(name, 0, coordinateX, coordinateY, techLevel, resource);
    }

    /**
     * constructor
     * @param name name
     * @param goodsPrice goods price
     * @param coordinateX x coordinate
     * @param coordinateY y coordinate
     * @param techLevel tech level
     * @param resource resource
     */
    private Planet(String name, double goodsPrice, int coordinateX, int coordinateY,
                   int techLevel, int resource) {

        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.techLevel = techLevel;
        this.resource = resource;
        initializedStock(stock);
    }

    @SuppressWarnings("MagicNumber")
    private void initializedStock(Map<String, Integer> map) {
        for(Goods g : Goods.values()) {
            map.put(g.toString().toLowerCase(), randInt(5, 30));
            //noinspection ChainedMethodCall
            Log.d("stock", String.valueOf(stock.get(g.toString().toLowerCase()))+
                    " "+g.toString().toLowerCase()+" IN "+getName());
        }
    }

    /**
     * rand int
     * @param min min val
     * @param max max val
     * @return rand int
     */
    private int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    /**
     * get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get coordinate x
     * @return x coordinate
     */
    public int getCoordinateX() {
        return coordinateX;
    }

    /**
     * set coordinate x
     * @param coordinateX coordinate x
     */
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    /**
     * get coordinate y
     * @return coordinate y
     */
    public int getCoordinateY() {
        return coordinateY;
    }

    /**
     * set coordinate y
     * @param coordinateY coordinate y
     */
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    /**
     * tech level
     * @return tech level
     */
    public int getTechLevel() {
        return techLevel;
    }

    /**
     * get resource
     * @return resource
     */
    public int getResource() {
        return resource;
    }

    /**
     * get stock of planet
     * @return stock
     */
    public Map <String, Integer> getStock(){return stock;}

    /**
     * set stock of planet
     * @param stock stock
     */
    public void setStock(Map<String, Integer> stock){
        this.stock = stock;
    }
}
