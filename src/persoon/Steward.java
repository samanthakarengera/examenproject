package persoon;

import java.time.LocalDate;

public class Steward extends Personeel{
    public Steward(String voornaam, String achternaam, String rijksregisternummer, String email, LocalDate geboortedatum) {
        super(voornaam, achternaam, rijksregisternummer, geboortedatum, email);
    }
}
