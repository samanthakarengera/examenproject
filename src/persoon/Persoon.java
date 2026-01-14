package persoon;

import java.time.LocalDate;

public class Persoon {
    private String voornaam;
    private String achternaam;
    private String rijksregisternummer;
    private String email;
    private LocalDate geboortedatum;

    public Persoon(String voornaam,
                   String achternaam,
                   String rijksregisternummer,
                   String email,
                   LocalDate geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.rijksregisternummer = rijksregisternummer;
        this.email = email;
        this.geboortedatum = geboortedatum;
    }
    public String getVoornaam() {
        return voornaam;
    }
    public String getAchternaam() {
        return achternaam;
    }
    public String getRijksregisternummer() {
        return rijksregisternummer;
    }
    public String getEmail() {
        return email;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }
}
