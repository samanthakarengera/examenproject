package reis;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

import persoon.Conducteur;
import persoon.Personeel;
import persoon.Steward;
import trein.Trein;
import ticket.Ticket;

public class Reis {
    private String vertrekStation;
    private String aankomstStation;
    private LocalDateTime datumTijd;
    private Trein trein;

    private List<Personeel> personeel = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public Reis(String vertrekStation,
                String aankomstStation,
                LocalDateTime datumTijd) {
        this.vertrekStation = vertrekStation;
        this.aankomstStation = aankomstStation;
        this.datumTijd = datumTijd;
    }

    public void setTrein(Trein trein){
        this.trein = trein;
    }
    public Trein getTrein(){
        return trein;
    }

    public void voegPersoneel(Personeel p){
        personeel.add(p);
    }

    public boolean heeftGenoegPersoneel(){
        int aantalConducteurs = 0;
        int aantalStewards = 0;
        for(Personeel p : personeel){
            if (p instanceof Conducteur){
                aantalConducteurs++;
            }else if(p instanceof Steward){
                aantalStewards++;
            }
        }
        return aantalConducteurs >= 1 && aantalStewards >= 3;
    }
    private boolean heeftPlaats(){
        return trein != null && tickets.size() < trein.getTotaleCapaciteit();
    }
    public void voegTicket(Ticket t){
        if(heeftPlaats()){
            tickets.add(t);
        }else {
            System.out.println("Geen plaats meer beschikbaar op deze trein");
        }}

    public List<Ticket> getTickets(){
        return tickets;
    }
}
