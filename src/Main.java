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
    static List<Passagier> passagiersLijst = new ArrayList<>();
    static List<Personeel> personeelLijst = new ArrayList<>();
    static List<Reis> reizenLijst = new ArrayList<>();
    Trein trein1 = new Trein("Class 373", 12, 80);
    Trein trein2 = new Trein("Class 374", 14, 80);

    Reis reis1 = new Reis("Brussel", "Parijs", LocalDateTime.of(2026,03,05,12,30), trein1);
    Reis reis2 = new Reis("Amsterdam", "Milaan", LocalDateTime.of(2026,03,04,15,30), trein2);


    public static void main(String[] args) throws Exception {

        while (true) {
            System.out.println("\n--- EUROMOON HOOFDMENU ---");
            System.out.println("1. Passagier registreren");
            System.out.println("2. Passagier inloggen");
            System.out.println("3. Personeel registreren");
            System.out.println("4. Personeel inloggen");
            System.out.println("5. Reizen bekijken (voor passagiers)");
            System.out.println("0. Afsluiten");

            String input = scanner.nextLine();

            switch (input) {

                case "1":
                    registreerPassagier();
                    break;

                case "2":
                    Passagier p = inloggenPassagier();
                    if (p != null) {
                        passagierMenu(p);
                    }
                    break;

                case "3":
                    registreerPersoneel();
                    break;

                case "4":
                    Personeel pers = inloggenPersoneel();
                    if (pers != null) {
                        personeelMenu(pers);
                    }
                    break;

                case "5":
                    toonReizen();
                    break;

                case "0":
                    System.out.println("Programma afgesloten.");
                    return;

                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }
    }

// --- Passagier methods ---

    private static void registreerPassagier() {
        System.out.print("Voornaam: ");
        String voornaam = scanner.nextLine();
        System.out.print("Achternaam: ");
        String achternaam = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Rijksregisternummer: ");
        String rrn = scanner.nextLine();
        System.out.print("Geboortedatum (YYYY-MM-DD): ");
        LocalDate geboortedatum = LocalDate.parse(scanner.nextLine());

        for (Passagier p : passagiersLijst) {
            if (p.getRijksregisternummer().equals(rrn) || p.getEmail().equals(email)) {
                System.out.println("Passagier bestaat al.");
                return;
            }
        }

        passagiersLijst.add(new Passagier(voornaam, achternaam, email, rrn, geboortedatum));
        System.out.println("Passagier geregistreerd!");
    }

    private static Passagier inloggenPassagier() {
        System.out.print("Rijksregisternummer: ");
        String rrn = scanner.nextLine();

        for (Passagier p : passagiersLijst) {
            if (p.getRijksregisternummer().equals(rrn)) {
                System.out.println("Ingelogd als " + p.getVoornaam());
                return p;
            }
        }

        System.out.println("Passagier niet gevonden.");
        return null;
    }

    private static void passagierMenu(Passagier p) {
        while (true) {
            System.out.println("\n--- PASSAGIER MENU ---");
            System.out.println("1. Reizen bekijken");
            System.out.println("2. Reis boeken");
            System.out.println("3. Mijn ticket bekijken");
            System.out.println("0. Uitloggen");

            String keuze = scanner.nextLine();

            switch (keuze) {
                case "1":
                    toonReizen();
                    break;

                case "2":
                    boekReis(p);
                    break;

                case "3":


                    break;

                case "0":
                    System.out.println("Uitgelogd.");
                    return;

                default:
                    System.out.println("Ongeldige keuze.");
            }
        }
    }

    private static void boekReis(Passagier p) {
        if (reizenLijst.isEmpty()) {
            System.out.println("Geen reizen beschikbaar.");
            return;
        }

        System.out.println("Beschikbare reizen:");
        for (int i = 0; i < reizenLijst.size(); i++) {
            System.out.println(i + 1 + ". " + reizenLijst.get(i).getVertrekStation() + " -> " + reizenLijst.get(i).getAankomstStation() + " | " + reizenLijst.get(i).getDatumTijd());
        }

        System.out.print("Kies een reis (nummer): ");
        int keuze = Integer.parseInt(scanner.nextLine()) - 1;

        if (keuze < 0 || keuze >= reizenLijst.size()) {
            System.out.println("Ongeldige keuze.");
            return;
        }

        Reis geselecteerd = reizenLijst.get(keuze);
        if (geselecteerd.getTickets().size() < geselecteerd.getTrein().getTotaleCapaciteit()) {
            Ticket t = new Ticket(p, geselecteerd);
            p.setTicket(t);
            geselecteerd.voegTicketToe(t);
            System.out.println("Ticket succesvol gekocht!");
        } else {
            System.out.println("Helaas, deze trein is vol.");
        }
    }

    private static void toonReizen() {
        if (reizenLijst.isEmpty()) {
            System.out.println("Geen reizen beschikbaar.");
            return;
        }

        for (Reis r : reizenLijst) {
            System.out.println(r.getVertrekStation() + " -> " + r.getAankomstStation() + " | " + r.getDatumTijd());
        }
    }

// --- Personeel methods ---

    private static void registreerPersoneel() {
        System.out.print("Voornaam: ");
        String v = scanner.nextLine();
        System.out.print("Achternaam: ");
        String a = scanner.nextLine();
        System.out.print("Rijksregisternummer: ");
        String rrn = scanner.nextLine();

        Personeel p = new Personeel(
                inloggenPassagier().getVoornaam(), inloggenPassagier().getAchternaam(),
                inloggenPassagier().getRijksregisternummer(),inloggenPersoneel().getGeboortedatum(), inloggenPassagier().getEmail(), inloggenPersoneel().getFunctie());
        personeelLijst.add(p);

        System.out.println("Personeel geregistreerd: " + v);
    }

    private static Personeel inloggenPersoneel() {
        System.out.print("Rijksregisternummer: ");
        String rrn = scanner.nextLine();

        for (Personeel p : personeelLijst) {
            if (p.getRijksregisternummer().equals(rrn)) {
                System.out.println("Ingelogd als " + p.getVoornaam());
                return p;
            }
        }

        System.out.println("Personeel niet gevonden.");
        return null;
    }

    private static void personeelMenu(Personeel p) throws Exception {
        while (true) {
            System.out.println("\n--- PERSONEEL MENU ---");
            System.out.println("Ingelogd als: " + p.getVoornaam());
            System.out.println("1. Reizen bekijken");
            System.out.println("2. Boardinglijst afdrukken");
            System.out.println("0. Uitloggen");

            String keuze = scanner.nextLine();

            switch (keuze) {
                case "1":
                    toonReizen();
                    break;

                case "2":
                    if (reizenLijst.isEmpty()) {
                        System.out.println("Geen reizen beschikbaar.");
                    } else {
                        System.out.println("Welke reis? (nummer)");
                        for (int i = 0; i < reizenLijst.size(); i++) {
                            System.out.println(i + 1 + ". " + reizenLijst.get(i).getVertrekStation() + " -> " + reizenLijst.get(i).getAankomstStation());
                        }
                        int idx = Integer.parseInt(scanner.nextLine()) - 1;
                        if (idx >= 0 && idx < reizenLijst.size()) {
                            reizenLijst.get(idx).printBoardinglijst();
                        } else {
                            System.out.println("Ongeldige keuze.");
                        }
                    }
                    break;

                case "0":
                    System.out.println("Uitgelogd.");
                    return;

                default:
                    System.out.println("Ongeldige keuze.");
            }
        }
    }

    public Reis getReis1() {
        return reis1;
    }
}

