package ticket;

import persoon.Passagier;
import reis.Reis;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
//houdt info van 1 ticket bij (passagier, reis, klasse, datum aankoop)
    public class Ticket {
        private Passagier passagier;
        private Reis reis;
        private String klasse; // "Eerste" of "Tweede"

        public Ticket(Passagier passagier, Reis reis) {
            this.passagier = passagier;
            this.reis = reis;
            this.klasse = "Tweede"; // default
        }

        public void printTicket() {
            System.out.println("Ticket voor: " + passagier.getVoornaam() + " " + passagier.getAchternaam());
            System.out.println("Reis: " + reis.vertrekStation() + " -> " + reis.aankomstStation());
            System.out.println("Klasse: " + klasse);
            System.out.println("Ticket aangekocht op: " + LocalDateTime.now());
        }
        //ticketbeheer
        private List<Ticket> tickets = new ArrayList<>(); //lijst ticket

    public String getKlasse() {
        return klasse;
    }
    public String getPassagier() {
        return passagier.getVoornaam();
    }
    public String getEmail(){
        return email;
    }
    }


