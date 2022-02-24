package ru.netology.repository;

import ru.netology.NotFoundException;
import ru.netology.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirRepository {
    private Ticket[] items = new Ticket[0];

    public void save(Ticket item) {
        int lenght = this.items.length + 1;
        Ticket[] tmp = new Ticket[lenght];
        System.arraycopy(this.items, 0, tmp, 0, this.items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        this.items = tmp;
    }

    public Ticket[] findAll() {
        return this.items;
    }

    public Ticket[] findAll(String departureAirport, String arrivalAirport) {
        Ticket[] tmp = new Ticket[this.items.length - 1];
        int index = 0;
        for(Ticket item : this.items) {
            if (item.getDepartureAirport().contains(departureAirport) && item.getArrivalAirport().contains(arrivalAirport)) {
                tmp[index] = item;
                index++;
            }
        }

        this.items = tmp;
        return items;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : this.items) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public Ticket[] removeByID(int id) throws NotFoundException {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }

        int length = this.items.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket item : this.items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }

        this.items = tmp;

        return tmp;
    }
}
