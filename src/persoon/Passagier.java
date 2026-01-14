package persoon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//slaat gegevens van passagier op
public class Passagier extends Persoon {
    private List<String> tickets = new ArrayList<>();

    public Passagier(String voornaam,
                     String achternaam,
                     String rijksregisternummer,
                     String email,
                     LocalDate geboortedatum) {
        super(voornaam, achternaam, rijksregisternummer, email, geboortedatum);


    }
    public void voegTicketToe(String ticket) {
        tickets.add(ticket);
    }
}
