package repository;

import models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    GateRepository gateRepository;
    VehicleRepository vehicleRepository;

    Map<Long, Ticket> tickets = new TreeMap<>();
    private int prev=0;

    public Ticket saveTicket(Ticket ticket){
        prev+=1;
        ticket.setId(Long.valueOf(prev));
        tickets.put(Long.valueOf(prev), ticket);
        return ticket;
    }
}
