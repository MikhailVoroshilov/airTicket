package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.Ticket;
import ru.netology.repository.AirRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AirManagerTest {
    private AirManager manager = new AirManager(new AirRepository());

    private Ticket irk = new Ticket(1, 15620, "IKT", "LED", 300);
    private Ticket nov = new Ticket(5, 14500, "IKT", "LED", 300);
    private Ticket msk = new Ticket(2, 3700, "VKO", "IWA", 60);
    private Ticket pet = new Ticket(3, 5620, "KZN", "KLF", 90);
    private Ticket bel = new Ticket(4, 7450, "EGO", "BQS", 140);

    @Test
    void shouldSort() {
        Ticket[] expected = new Ticket[]{msk, pet, bel};
        Ticket[] actual = new Ticket[]{pet, bel, msk};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindAllTicket() {
        manager.add(irk);
        manager.add(bel);
        manager.add(nov);

        Ticket[] expected = new Ticket[]{irk, nov};
        Ticket[] actual = manager.findAllTicket("IKT", "LED");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdProduct() {
        manager.add(irk);
        manager.add(bel);
        manager.add(nov);

        manager.removeByIdProduct(5);

        Ticket[] expected = new Ticket[]{irk, bel};
        Ticket[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

}