package trein;

import java.util.ArrayList;
import java.util.List;
// houdt info over de trein en wagons
public class Trein {
    private String locomotiefType;
    private int maxWagons;
    private List<Wagon> wagons;


    public Trein(String locomotiefType) {
        this.locomotiefType = locomotiefType;
        this.wagons = new ArrayList<>();


    if(locomotiefType.equals("Class 373")) {
        this.maxWagons = 12;
    }else if (locomotiefType.equals("Class 374")) {
        this.maxWagons = 14;
    } else {this.maxWagons = 10; }
     }
    //wagon toevoegen
    public boolean voegWagonToe(Wagon wagon) {
        if (wagons.size() >= maxWagons) {
            System.out.println("Kan geen extra wagons toevoegen.");
            return false;
        }
        System.out.println("Extra wagon toegevoegd.");
        wagons.add(wagon);
        return true;
    }

    public int getTotaleCapaciteit(){
        int totaal = 0;
        for (Wagon wagon : wagons) {
            totaal += wagon.getCapaciteit();
        }
        return totaal;
    }
    //getter loco
    public String getLocomotiefType() {
        return locomotiefType;

    }

    //lijst huidige wagons
    public List<Wagon> getWagons() {
        return wagons;
    }

    public int getAantalWagons(){
        return wagons.size();
    }
}
