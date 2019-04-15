package com.example.m6.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Player
 */
@SuppressWarnings({"ConstructorWithTooManyParameters", "ClassWithTooManyDependents"})
public class Player implements Serializable {

    private static final long serialVersionUID= 1L;
    @SuppressWarnings("RedundantFieldInitialization")
    private boolean warped = false;
    private String name;
    @SuppressWarnings("FieldCanBeLocal")
    private String difficulty;
    private Spaceship spaceship;
    private int pilot;
    private int fighter;
    private int trader;
    private int engineer;
    private int credit;
    private int cargo;
    private int fuel;
    private Map<String, Integer> inven;
    private Universe system;
    private Planet currentplanet;


    /**
     * no arg constructor
     */
    public Player(){}

    @SuppressWarnings("JavaDoc")
    public Player(String name, int pilot, int fighter, int trader, int engineer,
                  String difficulty, Universe universe, Map<String, Integer> map) {
        this.name = name;
        this.pilot = pilot;
        this.fighter = fighter;
        this.trader = trader;
        this.engineer = engineer;
        this.difficulty = difficulty;
        this.system = universe;
        //noinspection AssignmentOrReturnOfFieldWithMutableType
        inven = map;

        //this will be acamar solarsystem with acamar planet.
        //noinspection ChainedMethodCall
        currentplanet = system.getSystem().get(0).getPlanet();
        credit = 1000;
        spaceship = Spaceship.GNAT;
        cargo = 0;
        //noinspection MagicNumber
        fuel = 80;
    }

    /**
     * get serialVersionUID
     * @return serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * is Warped
     * @return boolean warped
     */
    public boolean isWarped() {
        return warped;
    }

    /**
     * set boolean
     * @param warped boolean warped
     */
    public void setWarped(boolean warped) {
        this.warped = warped;
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
     * get spaceship
     * @return spaceship
     */
    public Spaceship getSpaceship() {
        return spaceship;
    }

    /**
     * set spaceship
     * @param spaceship spaceship
     */
    public void setSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    /**
     * get pilot point
     * @return pilot point
     */
    public int getPilot() {
        return pilot;
    }

    /**
     * set pilot point
     * @param pilot pilot point
     */
    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    /**
     * get fighter point
     * @return fighter point
     */
    public int getFighter() {
        return fighter;
    }

    /**
     * set fighter point
     * @param fighter fighter point
     */
    public void setFighter(int fighter) {
        this.fighter = fighter;
    }
    /**
     * get trader point
     * @return trader point
     */
    public int getTrader() {
        return trader;
    }

    /**
     * set trader point
     * @param trader trader point
     */
    public void setTrader(int trader) {
        this.trader = trader;
    }

    /**
     * get engineer point
     * @return engineer point
     */
    public int getEngineer() {
        return engineer;
    }

    /**
     * set engineer point
     * @param engineer engineer point
     */
    public void setEngineer(int engineer) {
        this.engineer = engineer;
    }

    /**
     * get credit
     * @return credit
     */
    public int getCredit() {
        return credit;
    }

    /**
     * set credit
     * @param credit credit
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }

    /**
     * get cargo
     * @return cargo
     */
    public int getCargo() {
        return cargo;
    }

    /**
     * set cargo
     * @param cargo cargo
     */
    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    /**
     * get fuel
     * @return fuel
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * set fuel
     * @param fuel fuel
     */
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    /**
     * get inven
     * @return inven
     */
    public Map<String, Integer> getInven() {
        //noinspection AssignmentOrReturnOfFieldWithMutableType
        return inven;
    }

    /**
     * set inven
     * @param inven inven
     */
    public void setInven(Map<String, Integer> inven) {
        //noinspection AssignmentOrReturnOfFieldWithMutableType
        this.inven = inven;
    }

    /**
     * get system
     * @return system
     */
    public Universe getSystem() {
        return system;
    }

    /**
     * set system
     * @param system system
     */
    public void setSystem(Universe system) {
        this.system = system;
    }

    /**
     * get current planet
     * @return current planet
     */
    public Planet getCurrentplanet() {
        return currentplanet;
    }

    /**
     * set current planet
     * @param currentplanet current planet
     */
    public void setCurrentplanet(Planet currentplanet) {
        this.currentplanet = currentplanet;
    }
}
