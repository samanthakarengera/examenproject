package persoon;

import java.time.LocalDate;

public class BagagePersoneel extends Persoon{
    public BagagePersoneel
            (String voornaam,
             String achternaam,
             String rijksregisternummer,
             String email,
             LocalDate geboortedatum) {
        super(voornaam, achternaam, rijksregisternummer,email, geboortedatum);
    }
}
