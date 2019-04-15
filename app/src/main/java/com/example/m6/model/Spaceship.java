package com.example.m6.model;

/**
 * space ship enum class
 */
@SuppressWarnings("CanBeFinal")
public enum Spaceship {
    GNAT(15, 0.7),
    FLEA(20, 0.9);

    @SuppressWarnings("FieldMayBeFinal")
    private int bay;
    @SuppressWarnings("FieldMayBeFinal")
    private double efficiency;

    Spaceship(int bay, double efficiency) {
        this.bay = bay;
        this.efficiency = efficiency;
    }

    /**
     * get bay of spaceship
     * @return the bay
     */
    public int getBay(){
        return bay;
    }

    /**
     * get efficiency
     * @return efficiency
     */
    public double getEfficiency(){return efficiency;}
}

