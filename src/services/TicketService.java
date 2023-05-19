package services;

import exceptions.GateNotFoundException;
import models.*;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import repository.VehicleRepository;
import strategies.SpotAssignmentStrategy;
import strategies.SpotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, TicketRepository ticketRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository){
        this.gateRepository=gateRepository;
        this.ticketRepository=ticketRepository;
        this.vehicleRepository=vehicleRepository;
        this.parkingLotRepository=parkingLotRepository;
    }

    public Ticket issueTicket(VehicleType vehicleType, String vehicleNumber, String ownerName, Long gateId) throws GateNotFoundException {
        Ticket ticket=new Ticket();
        ticket.setEntryTime(new Date());
        Optional<Gate> gateOptional=gateRepository.findGateBy(gateId);

        if(gateOptional.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate=gateOptional.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getCurrOperator());

        Vehicle savedVehicle;

        Optional<Vehicle> vehicleOptional=vehicleRepository.getVehicleNumber(vehicleNumber);

        if(vehicleOptional.isEmpty()){
            Vehicle vehicle=new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setNumber(vehicleNumber);
            vehicle.setName(ownerName);
            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        }else{
            savedVehicle=vehicleOptional.get();
        }
        ticket.setVehicle(savedVehicle);

        SpotAssignmentStrategyType assignmentStrategyType =parkingLotRepository.getParkingLotForGate(gate).getSpotAssignmentStrategyType();

        SpotAssignmentStrategy spotAssignmentStrategy= SpotAssignmentStrategyFactory.getSpotForType(assignmentStrategyType);

        ticket.setAssignedSpot(spotAssignmentStrategy.getSpot(gate, vehicleType));

        ticket.setNumber("ticket" + ticket.getId());

        return ticketRepository.saveTicket(ticket);

    }
}
