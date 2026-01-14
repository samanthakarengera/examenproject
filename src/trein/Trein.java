package trein;

import java.util.ArrayList;
import java.util.List;

public class Trein {
    private Locomotief locomotief;
    private List<Wagon> wagons = new ArrayList<>();

    public Trein(Locomotief locomotief) {
        this.locomotief = locomotief;
    }
    public boolean magExtraWagon(){
        return wagons.size() < locomotief.getMaxWagons();
    }

    public void extraWagon(Wagon wagon){
        if (magExtraWagon()) {
            wagons.add(wagon);
        }else{
            System.out.println("Maximum bereikt, kan geen wagon meer toeveogen.");
        }
    }
    public int getTotaleCapaciteit(){
        return locomotief.getCapaciteit();
    }
}
