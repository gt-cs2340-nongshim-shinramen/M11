package com.example.m6.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * universe
 */
public class Universe implements Serializable {


    private int x;
    private int y;
    private List<SolarSystem> system = new ArrayList<>();

    /**
     * no arg constructor
     */
    @SuppressWarnings("RedundantNoArgConstructor")
    public Universe(){}

    /**
     * get solar system
     * @return system
     */
    public List<SolarSystem> getSystem() {
        //noinspection AssignmentOrReturnOfFieldWithMutableType
        return system;
    }

    /**
     * get x coordinate
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * set x coordinate
     * @param x x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * get y coordinate
     * @return y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * set y coordinate
     * @param y y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * set system
     * @param system system
     */
    public void setSystem(List<SolarSystem> system) {
        //noinspection AssignmentOrReturnOfFieldWithMutableType
        this.system = system;
    }
}
