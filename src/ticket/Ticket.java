package ticket;

import persoon.Passagier;
import reis.Reis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//houdt info van 1 ticket bij (passagier, reis, klasse, datum aankoop)
public class Ticket {
    private Passagier passagier;
    private Reis reis;
    private String klasse;
    private LocalDate datumAankoop;


    public Ticket(Passagier passagier,
                  Reis reis,
                  String klasse){
        this.passagier = passagier;
        this.reis = reis;
        this.klasse = klasse;
        this.datumAankoop = LocalDate.now();
    }
    public Passagier getPassagier() {
        return passagier;
    }
    public Reis getReis() {
        return reis;
    }
    public String getKlasse() {
        return klasse;
    }
    public LocalDate getDatumAankoop() {
        return datumAankoop;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                " passagier = " + passagier.getVoornaam() + " " + passagier.getAchternaam() +
                ", reis = " + reis.vertrekStation() + " -> " + reis.aankomstStation() +
                ", klasse = " + klasse +
                ", datum aankoop = " + datumAankoop + " }";
    }

    //ticketbeheer
    private List<Ticket> tickets = new ArrayList<>(); //lijst ticket


}
