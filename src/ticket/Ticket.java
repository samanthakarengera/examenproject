package ticket;

import persoon.Passagier;
import reis.Reis;

public class Ticket {
    private Passagier passagier;
    private Reis reis;
    private String klasse;

    public Ticket(Passagier passagier,
                  Reis reis,
                  String klasse){
        this.passagier = passagier;
        this.reis = reis;
        this.klasse = klasse;
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
}
