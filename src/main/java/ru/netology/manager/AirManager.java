package ru.netology.manager;

import ru.netology.NotFoundException;
import ru.netology.Ticket;
import ru.netology.repository.AirRepository;

public class AirManager {
    private AirRepository repository;

    public AirManager(AirRepository repository) {
        this.repository = repository;
    }
    // добавьте необходимые поля, конструкторы и методы

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

//    public Ticket[] searchBy(String text) {
//        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты
//        for (Ticket product : repository.findAll()) {
//            if (matches(product, text)) {
////                return new Product[]{product};
//                int lenght = result.length + 1;
//                Ticket[] tmp = new Ticket[lenght];
//                System.arraycopy(result, 0, tmp, 0, result.length);
//                int lastIndex = tmp.length - 1;
//                tmp[lastIndex] = product;
//                result = tmp;
//
//                // "добавляем в конец" массива result продукт product
//            }
//        }
//        return result;
//    }
//
//    // метод определения соответствия товара product запросу search
//    public boolean matches(Ticket ticket, String search) {
//        if (ticket.getDepartureAirport().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }
//        // или в одну строку:
//        // return product.getName().contains(search);
//    }

    public Ticket[] removeByIdProduct(int id) throws NotFoundException {
        return repository.removeByID(id);
    }

    public Ticket[] findAllTicket(String departureAirport, String arrivalAirpor) {
        return repository.findAll(departureAirport, arrivalAirpor);
    }
    public Ticket[] findAll(){
        return repository.findAll();
    }
}
