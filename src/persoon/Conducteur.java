package persoon;

import java.time.LocalDate;

public class Conducteur extends Personeel{
    public Conducteur(String voornaam, String achternaam, String rijksregisternummer, String email, LocalDate geboortedatum) {
        super(voornaam, achternaam, rijksregisternummer, geboortedatum, email);
    }
}
