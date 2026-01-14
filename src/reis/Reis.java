package reis;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

import persoon.*;
import trein.Trein;
import ticket.Ticket;
// houdt info over de reis, lijst van tickets, verkoopt tickets, maakt boardinglijst
public class Reis {
    private String vertrekStation;
    private String aankomstStation;
    private LocalDateTime vertrekTijd;
    private Trein trein;
    private List<Personeel> personeel;
    private List<Ticket> tickets;
    private int maxPlaatsen;

    public Reis(String vertrekStation,
                String aankomstStation,
                LocalDateTime datumTijd,
                Trein trein,
                List<Personeel> personeel) {
        this.vertrekStation = vertrekStation;
        this.aankomstStation = aankomstStation;
        this.vertrekTijd = datumTijd;
        this.trein = trein;
        this.personeel = personeel;
        this.tickets = new ArrayList<>();
        this.maxPlaatsen = trein.getAantalWagons();
    }

    public String vertrekStation() {
        return vertrekStation;
    }

    public String aankomstStation() {
        return aankomstStation;
    }

    public LocalDateTime getVertrekTijd() {
        return vertrekTijd;
    }

    public Trein getTrein() {
        return trein;
    }

    public List<Personeel> getPersoneel() {
        return personeel;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    // ticketverkoop
    public boolean verkoopTicket(Passagier passagier, String klasse) {
        if (tickets.size() >= maxPlaatsen) {
            System.out.println("Sorry, de trein is volboekt.");
            return false;
        }
        Ticket ticket = new Ticket(passagier, this, klasse);
        tickets.add(ticket);
        System.out.println("Ticket verkocht aan " + passagier.getVoornaam() + " " + passagier.getAchternaam());
        return true;

    }


    //boardinglijst afdrukken
    public void printBoardinglijst() throws IOException {

        String bestandsNaam = vertrekStation + "_"
                + aankomstStation + "_"
                + LocalDate.now() + ".txt";
        PrintWriter writer = new PrintWriter(new FileWriter(bestandsNaam));

        writer.println("Boardinglijst");
        writer.println("Reis : " + vertrekStation + " -> " + aankomstStation);
        writer.println("Vertrektijd: " + vertrekTijd);
        writer.println("----------------------------------");

        for (Ticket ticket : tickets) {
          Passagier passagier = ticket.getPassagier();
          writer.println(
                  passagier.getVoornaam() + " "
                  + passagier.getAchternaam() + " "
                  +  " | Klasse: " + ticket.getKlasse()
          );
        }
        writer.close(); // sluit het bestand
        System.out.println("Boardinglijst opgeslagen als: " + bestandsNaam);
        for (Ticket t: tickets){
            System.out.println("Dit wordt automatisch verzonden naar " + t.getPassagier().getEmail());
        }



    }
}
