package persoon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
// conducteur,stewardsz, bagagepersoneel + certificaties
public class Personeel extends Persoon {
    private List<String> certificaties = new ArrayList<>();
    private List<String> personeelLijst = new ArrayList<>();
    private String functie;

    public Personeel(String voornaam,
                     String achternaam,
                     String rijksregisternummer,
                     LocalDate geboortedatum,
                     String email,
                     String functie){
        super(voornaam,achternaam,rijksregisternummer, email, geboortedatum);
        this.functie = functie;
    }
    public void voegCertificatieToe(String certificaat){
        certificaties.add(certificaat);
    }
    public List<String> getCertificaties() {
        return certificaties;
    }
    public List<String> getPersoneelLijst() {
        return personeelLijst;
    }
    public String getFunctie() {
        return functie;
    }
}