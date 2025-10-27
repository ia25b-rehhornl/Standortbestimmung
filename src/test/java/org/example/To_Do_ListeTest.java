package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class To_Do_ListeTest {

    @BeforeEach
    void setUp() {
        To_Do_Liste.aufgaben.clear();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main() {
    }

    @Test
    void addToListe(){
        To_Do_Liste.addToListe("Pizza");
        assertTrue(To_Do_Liste.aufgaben.contains("Pizza"));
        To_Do_Liste.addToListe("Hallo");
        assertTrue(To_Do_Liste.aufgaben.contains("Hallo"));
        }


    @Test
    void showAll() {

    }

    @Test
    void edit() {
        To_Do_Liste.addToListe("Aufgabe 1");
        To_Do_Liste.addToListe("Aufgabe 2");
        To_Do_Liste.edit(1, "Aufgabe 2 - geändert");
        assertEquals("Aufgabe 2 - geändert", To_Do_Liste.aufgaben.get(1));
        assertEquals("Aufgabe 1", To_Do_Liste.aufgaben.get(0));

    }

    @Test
    void delet() {


        To_Do_Liste.addToListe("Aufgabe 1");
        To_Do_Liste.addToListe("Aufgabe 2");
        To_Do_Liste.delete(0);
        assertFalse(To_Do_Liste.aufgaben.contains("Aufgabe 1"));
        assertTrue(To_Do_Liste.aufgaben.contains("Aufgabe 2"));
        assertEquals(1, To_Do_Liste.aufgaben.size());
        


    }

    @Test
    void breakProgramm() {
    }
}