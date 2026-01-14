package trein;

import java.util.ArrayList;
import java.util.List;
// houdt info over de trein en wagons
public class Trein {
    private String locomotiefType;
    private int aantalWagons;
    private int maxPerWagon;

    public Trein(String locomotiefType, int aantalWagons, int capaciteitPerWagon) {
        this.locomotiefType = locomotiefType;
        this.aantalWagons = aantalWagons;
        this.maxPerWagon = capaciteitPerWagon;
    }

    public int getTotaleCapaciteit() {
        return aantalWagons * maxPerWagon;
    }

    public String getLocomotiefType() {
        return locomotiefType;
    }
}


