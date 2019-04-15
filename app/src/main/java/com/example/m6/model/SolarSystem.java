package com.example.m6.model;

import java.io.Serializable;

/**
 * solar system class
 */
public class SolarSystem implements Serializable {
    private String name;
    private int coordinate_x;
    private int coordinate_y;
    private int techLevel;
    private int resource;
    private TechLevel techLevelValue;
    private Resource resourceValue;
    private Planet planet;

    /**
     * no arg constructor
     */
    public SolarSystem(){}

    /**
     * constructor of solar system
     * @param name name of solar system
     * @param x x coordinate
     * @param y y coordinate
     * @param techLevel tech level
     * @param resource resource
     */
    public SolarSystem(String name, int x, int y, int techLevel, int resource) {
        this.planet = new Planet(name, x, y, techLevel, resource);
        this.name = name;
        coordinate_x = x;
        coordinate_y = y;
        this.techLevel = techLevel;
        this.resource = resource;
        resourceValue = Resource.values()[resource];
        techLevelValue = TechLevel.values()[techLevel];
    }

    /**
     * get system name
     * @return name of system
     */
    public String getName() {
        return name;
    }

    /**
     * set system name
     * @param name system name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get x coordinate
     * @return x coordinate
     */
    public int getCoordinate_x() {
        return coordinate_x;
    }

    /**
     * set x coordinate
     * @param coordinate_x x coordinate
     */
    public void setCoordinate_x(int coordinate_x) {
        this.coordinate_x = coordinate_x;
    }

    /**
     * y coordinate
     * @return y coordinate
     */
    public int getCoordinate_y() {
        return coordinate_y;
    }

    /**
     * set y coordinate
     * @param coordinate_y y coordinate
     */
    public void setCoordinate_y(int coordinate_y) {
        this.coordinate_y = coordinate_y;
    }

    /**
     * get tech level
     * @return tech level
     */
    public int getTechLevel() {
        return techLevel;
    }

    /**
     * set tech level
     * @param techLevel tech level
     */
    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * get resource
     * @return resource
     */
    public int getResource() {
        return resource;
    }

    /**
     * set resource
     * @param resource resource
     */
    public void setResource(int resource) {
        this.resource = resource;
    }

    /**
     * get tech level
     * @return tech level
     */
    public TechLevel getTechLevelValue() {
        return techLevelValue;
    }

    /**
     * set tech level
     * @param techLevelValue tech level
     */
    public void setTechLevelValue(TechLevel techLevelValue) {
        this.techLevelValue = techLevelValue;
    }

    /**
     * get resource
     * @return resource
     */
    public Resource getResourceValue() {
        return resourceValue;
    }

    /**
     * set resource
     * @param resourceValue resource
     */
    public void setResourceValue(Resource resourceValue) {
        this.resourceValue = resourceValue;
    }

    /**
     * get planet
     * @return planet
     */
    public Planet getPlanet() {
        return planet;
    }

    /**
     * set planet
     * @param planet planet
     */
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
