import reis.Reis;
import ticket.Ticket;
import trein.*;
import persoon.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Passagier> passagiers = new ArrayList<>();
    static List<Reis> reizen = new ArrayList<>();
    static List<Trein> treinen = new ArrayList<>();
    static List<Personeel> personeelLijst = new ArrayList<>();
    //huidig ingelogde passagier
    static Passagier ingelogdePassagier = null;
    static Reis laatsgekozenReis = null;


    public static void main(String[] args) throws IOException {
        //personeellijst
        Personeel conducteur1 = new Conducteur("Jan","Jansens", "123","jan@mail.com", LocalDate.of(1990, 1, 1));
        Personeel stew1 = new Conducteur("Aan","Jansens", "123","jan@mail.com", LocalDate.of(1990, 1, 1));
        Personeel stew2 = new Conducteur("Ban","Jansens", "123","jan@mail.com", LocalDate.of(1990, 1, 1));
        Personeel stew3 = new Conducteur("Lan","Jansens", "123","jan@mail.com", LocalDate.of(1990, 1, 1));

        personeelLijst.add(conducteur1);
        personeelLijst.add(stew1);
        personeelLijst.add(stew2);
        personeelLijst.add(stew3);

        //trein aanmaaksysteem
        Trein trein1 = new Trein("Class 373");
        for (int i = 0; i < 12; i++) {
            trein1.voegWagonToe(new Wagon(40));
        }
        Trein trein2 = new Trein("Class 374");
        for (int i = 0; i < 14; i++) {
            trein2.voegWagonToe(new Wagon(40));
        }
        treinen.add(trein1);
        treinen.add(trein2);
        //===== REIZEN =====
        List<Personeel> personeelReis = new ArrayList<>();
        personeelReis.add(stew1);
        personeelReis.add(stew2);
        personeelReis.add(stew3);
        personeelReis.add(conducteur1);

        reizen.add(new Reis("Brussel","Parijs", LocalDateTime.of(2026,3,5,12,30), trein1, personeelReis));
        reizen.add(new Reis("Amsterdam","Berlijn", LocalDateTime.of(2026,3,4,10,30), trein1, personeelReis));

        //=====HOOFDMENU=====

        boolean running = true;
        while (running) {
            System.out.println("\n ===== EUROMOON MENU =====");
            System.out.println("1. Passagier registreren");
            System.out.println("2. Passagier inloggen");
            System.out.println("3. Reis boeken / Ticket kopen");
            System.out.println("4. Mijn tickets bekijken");
            System.out.println("5. Boardinglijst afdrukken");
            System.out.println("6. Euromoon personeel");
            System.out.println("7. Stoppen");
            System.out.println("Maak uw keuze: ");

            int keuze = Integer.parseInt(scanner.nextLine());
            switch (keuze) {
                case 1:
                    registreerPassagier();
                    break;
                case 2:
                    inloggen();
                    break;
                case 3:
                    boekReis();
                    break;
                case 4:
                    bekijkTicket();
                    break;
                case 5:
                    printBoardinglijst();
                    break;
                case 6:
                    registreerPersoneel();
                case 7:
                    inloggenPersoneel();
                case 8: {
                    running = false;
                    System.out.println("Programma gestopt.");
                }
                break;
                default:
                    System.out.println("Ongeldige optie.");

            }
        }
    }

    //alle methodes
    private static void registreerPassagier() {
        System.out.println("REGISTREREN:");
        System.out.println("Voornaam: ");
        String voornaam = scanner.nextLine();
        System.out.println("Achternaam: ");
        String achternaam = scanner.nextLine();
        System.out.println("E-mail: ");
        String email = scanner.nextLine();
        for (Passagier passagier : passagiers) {
            if (passagier.getEmail().equals(email)) {
                System.out.println("E-mail bestaat al. Ongeldig.");
                return;
            }
        }
        System.out.println("Rijksregisternummer: ");
        String rijksregisternummer = scanner.nextLine();
        for (Passagier passagier : passagiers) {
            if (passagier.getRijksregisternummer().equals(rijksregisternummer)) {
                System.out.println("Rijksregisternummer bestaat al. Ongeldig.");
                return;
            }
        }
        System.out.println("Geboortedatum (YYYY-MM-DD): ");
        String geboortedatumStr = scanner.nextLine();

        //geboortedatum omzetten naar localdate
        java.time.LocalDate geboortedatum = java.time.LocalDate.parse(geboortedatumStr);
        Passagier p = new Passagier(voornaam, achternaam, rijksregisternummer, email, geboortedatum);
        passagiers.add(p);
        System.out.println("Passagier geregistreerd!");
        System.out.println(" ");


    }

    //inloggen
    private static void inloggen() {
        System.out.println("INLOGGEN:");
        System.out.println("Rijksregisternummer: ");
        String rijksregisternummer = scanner.nextLine();
        for (Passagier passagier : passagiers) {
            if (passagier.getRijksregisternummer().equals(rijksregisternummer)) {
                ingelogdePassagier = passagier;
                System.out.println("Succesvol ingelogd " + passagier.getVoornaam());
                return;
            }
        }
        System.out.println("Rijksregisternummer niet gevonden. Inloggen mislukt.");
    }
    private static void boekReis() {
        if (ingelogdePassagier == null) {
            System.out.println("Je moet eerst inloggen.");
            return;
        }
        if (reizen.isEmpty()) {
            System.out.println("Er zijn geen reizen meer beschikbaar.");
            return;
        }
        //toon beschikbare reizen
        System.out.println("Beschikbare reizen: " + reizen);
        for(int i = 0; i < reizen.size(); i++) {
            Reis r = reizen.get(i);
            System.out.println(i+1 + ". " + r.vertrekStation() + " -> " + r.aankomstStation()
                    + " om " + r.getVertrekTijd());
        }
        System.out.println("Kies een reis (nummer): ");
        int reisKeuze =  Integer.parseInt(scanner.nextLine()) -1;
        Reis gekozenReis = reizen.get(reisKeuze);
        laatsgekozenReis = gekozenReis;

        System.out.println("Welke klasse? (Eerste/Tweede)");
        String klasse = scanner.nextLine();
        boolean succes = gekozenReis.verkoopTicket(ingelogdePassagier, klasse);
        if (succes) {
            System.out.println("Ticket succesvol gekocht.");
        }else {
            System.out.println("Kan geen ticket kopen, de trein zit vol.");
    }

}

//ticket raadplegen
    private static void bekijkTicket() {
        if (ingelogdePassagier == null) {
            System.out.println("Je moet eerst inloggen.");
            return;
        }
        boolean heeftTickets = false;
        for(Reis r: reizen) {
            for (Ticket t: r.getTickets()) {
                if (t.getPassagier().equals(ingelogdePassagier)) {
                    System.out.println(t.toString());
                    heeftTickets = true;
                }
            }
        }
        if (!heeftTickets) {
            System.out.println("Je hebt nog geen ticket.");
        }
    }
    private static void printBoardinglijst() throws IOException {
        System.out.println("====BOARDINGLIST==== ");
        if (reizen.isEmpty()) {
            System.out.println("Er zijn geen reizen.");
            return;
        }
        if (laatsgekozenReis == null) {
            System.out.println("Er is nog geen reis gekozen, boek eerst een reis.");
        }

        laatsgekozenReis.printBoardinglijst();
        System.out.println("Boardinglijst opgeslagen voor " + laatsgekozenReis.vertrekStation() + " -> " + laatsgekozenReis.aankomstStation());


    }

    private static void registreerPersoneel() {
        System.out.println("ENKEL PERSONEEL: ");
        System.out.println("Voornaam: ");
        String voornaamP = scanner.nextLine();
        System.out.println("Achternaam: ");
        String achternaamP =  scanner.nextLine();
        System.out.println("Rijksregisternummer: ");
        String rijksregisternummerP = scanner.nextLine();
        System.out.println("E-mail: ");
        String emailP = scanner.nextLine();
        System.out.println("Geboortedatum (YYYY-MM-DD): ");
        LocalDate geboortedatumP = LocalDate.parse(scanner.nextLine());

        System.out.println("Functie: 1 = Conducteur , 2 = Steward , 3 = Bagagepersoneel");
        int functie = Integer.parseInt(scanner.nextLine());
        Personeel p;
        switch(functie){
            case 1 :
                p = new Conducteur(voornaamP,achternaamP,rijksregisternummerP,emailP,geboortedatumP);
            break;
            case 2:
                p = new Steward(voornaamP,achternaamP,rijksregisternummerP,emailP,geboortedatumP);
            break;
            case 3:
                p= new BagagePersoneel(voornaamP,achternaamP,rijksregisternummerP,emailP,geboortedatumP);
            break;
            default:
                System.out.println("Ongeldige functie");
                return;
        }
        personeelLijst.add(p);
        System.out.println(p.getVoornaam() + " geregistreerd als " + p.getClass().getSimpleName());

    }
    private static void inloggenPersoneel(){
        if(personeelLijst.isEmpty()){
            System.out.println("Geen personeel geregistreerd.");
            return;
        }
        System.out.println("Kies personeelslid: ");
        for(int i = 0; i< personeelLijst.size();i++){
            Personeel p = personeelLijst.get(i);
            System.out.println(i++ +". " + p.getVoornaam()+ " " + p.getAchternaam() + " (" +p.getClass().getSimpleName() + ")");
        }
        Personeel gekozen = personeelLijst.get(Integer.parseInt(scanner.nextLine())-1);
        System.out.println("Ingelogd als " +gekozen.getVoornaam()+ " "+ gekozen.getAchternaam() + " (" +gekozen.getClass().getSimpleName() + ")");
    }


}
