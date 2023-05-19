package strategies;

import models.*;
import repository.ParkingLotRepository;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{

    private ParkingLotRepository parkingLotRepository;

    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository=parkingLotRepository;
    }
    public RandomSpotAssignmentStrategy(){};

    @Override
    public ParkingSpot getSpot(Gate gate, VehicleType vehicleType) {
        ParkingLot parkingLot=parkingLotRepository.getParkingLotForGate(gate);

        for(ParkingFloor parkingFloor : parkingLot.getParkingFloors()){
            for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()){
                if((parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)) && parkingSpot.getSupportedVehicleType().contains(vehicleType)){
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
