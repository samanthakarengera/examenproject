package persoon;

import ticket.Ticket;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//slaat gegevens van passagier op

    public class Passagier {
        private String voornaam;
        private String achternaam;
        private String email;
        private String rijksregisternummer;
        private LocalDate geboortedatum;
        private Ticket ticket; // <-- Belangrijk!

        public Passagier(String v, String a, String email, String rrn, LocalDate g) {
            this.voornaam = voornaam;
            this.achternaam = achternaam;
            this.email = email;
            this.rijksregisternummer = rijksregisternummer;
            this.geboortedatum = geboortedatum;
        }

        public String getVoornaam() {
            return voornaam;
        }

        public String getAchternaam() {
            return achternaam;
        }

        public String getEmail() {
            return email;
        }

        public String getRijksregisternummer() {
            return rijksregisternummer;
        }

        // Ticket koppelen
        public void setTicket(Ticket t) {
            this.ticket = t;
        }

        public Ticket getTicket() {
            return ticket;
        }
    }
