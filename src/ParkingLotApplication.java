import controllers.TicketController;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import repository.VehicleRepository;
import services.TicketService;

public class ParkingLotApplication {

    public static void main(String[] args) {

        GateRepository gateRepository=new GateRepository();
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
        TicketRepository ticketRepository=new TicketRepository();
        VehicleRepository vehicleRepository=new VehicleRepository();

        TicketService ticketService=new TicketService(gateRepository, ticketRepository, vehicleRepository, parkingLotRepository);

        TicketController ticketController=new TicketController(ticketService);
    }
}
