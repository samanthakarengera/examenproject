package persoon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Passagier extends Persoon {
    private String wachtwoord;
    private List<String> tickets = new ArrayList<>();

    public Passagier(String voornaam,
                     String achternaam,
                     String rijksregisternummer,
                     String email,
                     LocalDate geboortedatum,
                     String wachtwoord) {
        super(voornaam, achternaam, rijksregisternummer, email, geboortedatum);
        this.wachtwoord = wachtwoord;
    }
    public boolean controleWachtwoord(String wachtwoord) {

        return wachtwoord.equals(this.wachtwoord);
    }
    public void voegTicketToe(String ticket) {
        tickets.add(ticket);
    }
}
