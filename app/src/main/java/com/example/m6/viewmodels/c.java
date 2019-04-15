package com.example.m6.viewmodels;

import android.util.Log;

import com.example.m6.model.Goods;
import com.example.m6.model.Planet;
import com.example.m6.model.Player;
import com.example.m6.model.Resource;
import com.example.m6.model.SolarSystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@SuppressWarnings({"UtilityClass", "ChainedMethodCall", "LawOfDemeter",
        "OverlyLongMethod", "OverlyComplexMethod", "JavaDoc"})
public class c {

    @SuppressWarnings({"FeatureEnvy", "TypeMayBeWeakened"})
    public static List<SolarSystem> validPlanet(Player p,
                                @SuppressWarnings("TypeMayBeWeakened") List<SolarSystem> s) {
        List<SolarSystem> filtered = new ArrayList<>();
        for (SolarSystem e : s) {
            @SuppressWarnings("ChainedMethodCall") int d =
                    (int) distanceBetween(p.getCurrentplanet().getCoordinateX(),
                    p.getCurrentplanet().getCoordinateY(),
                    e.getPlanet().getCoordinateX(), e.getPlanet().getCoordinateY());
            //noinspection ChainedMethodCall
            Log.d("d1", String.valueOf(d)+"to "+e.getPlanet().getName()+
                    "fuel criteria"+p.getFuel() * p.getSpaceship().getEfficiency());
            //below value 30 is just for testing whether it takes only valid item or not
            if ((d > 0) && (d < (p.getFuel() * p.getSpaceship().getEfficiency()))) {
                filtered.add(e);
            }
        }
        return filtered;
    }
    private static double distanceBetween(int x1, int y1, int x2, int y2) {
        return Math. sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
    }

    @SuppressWarnings("FeatureEnvy")
    public static int calculatePrice(Goods goods, Planet planet){
        int resource = planet.getResource();
        int price = goods.getBasePrice() +
                (goods.getIPL() * (planet.getTechLevel() - goods.getMTLP()));

        @SuppressWarnings("MagicNumber") boolean head = (Math.random() < 0.5);
        if (head) {
            price +=goods.getBasePrice()*((int)(Math.random()*goods.getVar())/100);
        } else {
            price -= goods.getBasePrice()*((int)(Math.random()*goods.getVar())/100);
        }

        if (goods.equals(Goods.WATER)) {
            if (resource== Resource.DROUGHT.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.LOTSOFWATER.getNumber()) {
                price = price / 3;
            }
            if (resource==Resource.DESERT.getNumber()) {
                price = price * 2;
            }
        }
        if (goods.equals(Goods.FURS)) {
            if (resource==Resource.COLD.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.RICHFAUNA.getNumber()) {
                price = price / 3;
            }
            if (resource==Resource.LIFELESS.getNumber()) {
                price = price * 2;
            }
        }

        if (goods.equals(Goods.FOOD)) {
            if (resource==Resource.CROPFAIL.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.RICHSOIL.getNumber()) {
                price = price / 3;
            }
            if (resource==Resource.POORSOIL.getNumber()) {
                price = price * 2;
            }
        }
        if (goods.equals(Goods.ORE)) {

            if (resource==Resource.MINERALRICH.getNumber()) {
                price = price / 3;
            }
            if (resource==Resource.MINERALPOOR.getNumber()) {
                price = price * 2;
            }
        }
        if (goods.equals(Goods.GAMES)) {
            if (resource==Resource.BOREDOM.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.ARTISTIC.getNumber()) {
                price = price / 3;
            }
        }
        if (goods.equals(Goods.FIREARMS)) {
            if (resource==Resource.WAR.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.WARLIKE.getNumber()) {
                price = price / 3;
            }
        }
        if (goods.equals(Goods.MEDICINE)) {
            if (resource==Resource.PLAGUE.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.LOTSOFHERBS.getNumber()) {
                price = price / 3;
            }
        }
        if (goods.equals(Goods.MACHINES)) {
            if (resource==Resource.LACKOFWORKERS.getNumber()) {
                price = price * 3;
            }
        }
        if (goods.equals(Goods.NARCOTICS)) {
            if (resource==Resource.LACKOFWORKERS.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.WEIRDMUSHROOMS.getNumber()) {
                price = price / 3;
            }
        }
        if (goods.equals(Goods.ROBOTS)) {
            if (resource==Resource.LACKOFWORKERS.getNumber()) {
                price = price * 3;
            }
        }

        return price;
    }


}
