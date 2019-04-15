package com.example.m6.model;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Universe implements Serializable {


    private int x;
    private int y;
    private List<SolarSystem> system = new ArrayList<>();

    public Universe(){}

    public List<SolarSystem> getSystem() {
        return system;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSystem(List<SolarSystem> system) {
        this.system = system;
    }
}
