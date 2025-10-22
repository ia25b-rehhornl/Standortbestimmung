package org.example;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class To_Do_Liste {


    private static ArrayList<String> aufgaben = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        boolean laufend = true;

        while (laufend) {

            System.out.println("1. Aufgabe hinzufügen");
            System.out.println("2. Alle Aufgaben anzeigen");
            System.out.println("3. Aufgabe bearbeiten");
            System.out.println("4. Aufgabe löschen");
            System.out.println("5. Programm beenden");
            System.out.println(); //macht abstand
            System.out.println("Geben Sie die Zahl des gewünschten Programmpunktes ein: ");
            int zahlLesen = scanner.nextInt();

            if (zahlLesen == 1) {
                addToListe();
            } else if (zahlLesen == 2) {
                showAll();
            } else if (zahlLesen == 3) {
                edit();
            } else if (zahlLesen == 4) {
                delet();
            } else if (zahlLesen == 5) {
                laufend = false;
                breakProgramm();

            } else {
                System.out.println("Die eingegbene Zahl ist keine Menuoption!");
            }
        }
        aufgaben.clear();
        scanner.close();

    }


    public static void addToListe() {
        boolean weitermachen = true;

        scanner.nextLine();

        while (weitermachen) {
            System.out.println("Welche Aufgabe möchten Sie Ihrer To-Do-Liste hinzufügen: ");
            String neueAufgabe = scanner.nextLine();
            aufgaben.add(neueAufgabe);

            System.out.println("Aufgabe wurde hinzugefügt.");

            System.out.println("Möchten Sie noch mehr Aufgaben hinzufügen? (Ja/Nein)");
            String antwort = scanner.nextLine().trim().toLowerCase();

            if (!antwort.equals("ja")) {
                weitermachen = false;
                System.out.println();
                }
        }
    }


    public static void showAll() {
        if (aufgaben.isEmpty()) {
            System.out.println("Ihre To-Do Liste ist leer.");
        } else {
            System.out.println("Ihre Aufgaben:");
            for (int i = 0; i < aufgaben.size(); i++) {
                System.out.println((i + 1) + ". " + aufgaben.get(i));
                System.out.println();
            }
        }
    }

    public static void edit() {

        scanner.nextLine();

        if (aufgaben.isEmpty()) {
            System.out.println("Es gibt keine Aufgaben zum Bearbeiten.");
            return;
        }

        showAll();
        System.out.print("Welche Aufgabe möchten Sie bearbeiten (Nummer eingeben)? ");
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

        System.out.print("Geben Sie den neuen Text für die Aufgabe ein: ");
        String neueAufgabe = scanner.nextLine();
        aufgaben.set(index, neueAufgabe);
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

        String entfernteAufgabe = aufgaben.remove(index);
        System.out.println("Aufgabe \"" + entfernteAufgabe + "\" wurde gelöscht!");
        System.out.println();
    }




    public static boolean breakProgramm() {
        System.out.println("Programm wird beendet. Auf Wiedersehen!");
        System.out.println();
            return false;

        }

    }




