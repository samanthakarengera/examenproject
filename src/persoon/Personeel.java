package persoon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
// conducteur,stewardsz, bagagepersoneel + certificaties
public abstract class Personeel extends Persoon {
    private List<String> certificaties = new ArrayList<>();
    private List<String> personeelLijst = new ArrayList<>();

    public Personeel(String voornaam,
                     String achternaam,
                     String rijksregisternummer,
                     LocalDate geboortedatum,
                     String email){
        super(voornaam,achternaam,rijksregisternummer, email, geboortedatum);
    }
    public void voegCertificatieToe(String certificatie){
        certificaties.add(certificatie);
    }
    public List<String> getCertificaties() {
        return certificaties;
    }
    public List<String> getPersoneelLijst() {
        return personeelLijst;
    }
}