package org.example;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class To_Do_Liste {


    private static ArrayList<String> aufgaben = new ArrayList<>(); //aufgaben werden in liste gespeichert
    private static Scanner scanner = new Scanner(System.in); //scanner


    public static void main(String[] args) {

        boolean laufend = true; //solange boolean true, while schlaufe von unten wird ausgeführt

        while (laufend) {

            System.out.println("1. Aufgabe hinzufügen"); //gibt nummer und option in konsole aus
            System.out.println("2. Alle Aufgaben anzeigen");
            System.out.println("3. Aufgabe bearbeiten");
            System.out.println("4. Aufgabe löschen");
            System.out.println("5. Programm beenden");
            System.out.println(); //macht abstand
            System.out.println("Geben Sie die Zahl des gewünschten Programmpunktes ein: ");
            int zahlLesen = scanner.nextInt(); //eingegebene zahl wird in varibale gespeichert

            if (zahlLesen == 1) { //wenn variabel 1 ist, wird auf addToList methode zugegriffen
                addToListe();
            } else if (zahlLesen == 2) { //wenn eingescante variabel entsprechender zahl entspricht, wird auf methode zugegriffen, ansonsten geht es weiter
                showAll();
            } else if (zahlLesen == 3) {
                edit();
            } else if (zahlLesen == 4) {
                delet();
            } else if (zahlLesen == 5) {
                laufend = false; //wenn boolean falsch, also zahl 5, greift auf methode break zu
                breakProgramm();

            } else {
                System.out.println("Die eingegbene Zahl ist keine Menuoption!"); //wenn irgend andere eingabe, printet das
            }
        }
        aufgaben.clear(); //löscht ganzer inhalt von liste
        scanner.close();// schliesset scanner von liste
                        // kann hier gemacht werden, weil methoden werden ja in main bereits aufgerufen, nur methode an sich ist unterhalb
    } //hiermit wird programm geschlossen


    public static void addToListe() {
        boolean weitermachen = true; //solange boolean true ist, while schlaufe von unten wird ausgeführt

        scanner.nextLine(); //scant, was bis jetzt vorhanden ist

        while (weitermachen) {
            System.out.println("Welche Aufgabe möchten Sie Ihrer To-Do-Liste hinzufügen: ");
            String neueAufgabe = scanner.nextLine(); //eingegebene aufgabe von oben wird gespeichert unter variabel name neueAufgabe
            aufgaben.add(neueAufgabe); //neue aufgabe wird zu liste hinzugefügt

            System.out.println("Aufgabe wurde hinzugefügt.");

            System.out.println("Möchten Sie noch mehr Aufgaben hinzufügen? (Ja/Nein)");
            String antwort = scanner.nextLine().trim().toLowerCase(); //egal welche art von eingabe von ja/ nein, hauptsache eingabe ja/nein

            if (!antwort.equals("ja")) { //wenn antwort nicht ja ist, boolean auf falsch
                weitermachen = false;
                System.out.println(); //wird für abstand gemacht
                }
        }
    }


    public static void showAll() {
        if (aufgaben.isEmpty()) { //falls aufgabe lehr ist, bekommt rückmeldung in konsole
            System.out.println("Ihre To-Do Liste ist leer.");
        } else {
            System.out.println("Ihre Aufgaben:");
            for (int i = 0; i < aufgaben.size(); i++) { //aufgaben werden aufgelistet, bis alle sind
                System.out.println((i + 1) + ". " + aufgaben.get(i)); //aufgaben werden der reihe nach von eins nach nummeriert, bis alle nummeriert wurden
            }
        }
        System.out.println();
    }

    public static void edit() {

        scanner.nextLine();

        if (aufgaben.isEmpty()) {
            System.out.println("Es gibt keine Aufgaben zum Bearbeiten.");
            return;
        }

        showAll(); //greift auf mehtode von oben zu, bei der alle aufgaben nummeriert aufgelistet wurden
        System.out.print("Welche Aufgabe möchten Sie bearbeiten (Nummer eingeben)? ");
        int index;

        try {
            index = Integer.parseInt(scanner.nextLine()) - 1; //eingabe von nummer wird -1 gerechnet, wegen korrekter index zuprdnung in java
        } catch (NumberFormatException e) { //umwandeln, damit auf richitger index zugreift
            System.out.println("Ungültige Eingabe!");
            return;
        }

        if (index < 0 || index >= aufgaben.size()) { //falls index grösser ist als möglich (weil ist ja immer -1)
            System.out.println("Ungültige Aufgabennummer!");
            return;
        }

        System.out.print("Geben Sie den neuen Text für die Aufgabe ein: ");
        String neueAufgabe = scanner.nextLine(); //eingegebenen text von oben wird ib variabel gespeichert
        aufgaben.set(index, neueAufgabe); //greift auf angegbenen index zu und überschreibt diese
        System.out.println("Aufgabe wurde aktualisiert!");
        System.out.println();
    }


    public static void delet() {

        scanner.nextLine();

        if (aufgaben.isEmpty()) {
            System.out.println("Es gibt keine Aufgaben zum Löschen.");
            return;
        }

        showAll();
        System.out.print("Welche Aufgabe möchten Sie löschen (Nummer eingeben)? ");
        int index;

        try {
            index = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Ungültige Eingabe!");
            return;
        }

        if (index < 0 || index >= aufgaben.size()) {
            System.out.println("Ungültige Aufgabennummer!");
            return;
        }

        String entfernteAufgabe = aufgaben.remove(index); //entfernt aufgabe aus liste
        System.out.println("Aufgabe \"" + entfernteAufgabe + "\" wurde gelöscht!"); //meldung dass aufgbae entfertn wurde, wobei aufgabe nochmals genannt wird
        System.out.println();
    }




    public static boolean breakProgramm() {
        System.out.println("Programm wird beendet. Auf Wiedersehen!");
        System.out.println();
            return false;

        }

    }




