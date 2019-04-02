package com.example.m6.model;

public enum Spaceship {
    GNAT(15, 0.7),
    FLEA(20, 0.9);

    private int bay;
    private double efficiency;

    Spaceship(int bay, double efficiency) {
        this.bay = bay;
        this.efficiency = efficiency;
    }
    public int getBay(){
        return bay;
    }
    public double getEfficiency(){return efficiency;}
}

