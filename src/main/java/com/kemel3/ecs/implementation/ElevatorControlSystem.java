package main.java.com.kemel3.ecs.implementation;

import main.java.com.kemel3.ecs.implementation.enums.ElevatorDirection;
import main.java.com.kemel3.ecs.implementation.interfaces.ElevatorControlSystemFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ElevatorControlSystem implements ElevatorControlSystemFactory {

    public static final int MAX_ELEVATORS = 16;
    Integer numberOfElevators = 0;
    Integer numberOfFloors = 0;
    ArrayList<Elevator> elevators;
    Queue<Integer> pickupLocations;

    public ElevatorControlSystem(Integer numberOfElevators, Integer numberOfFloors) {
        this.numberOfElevators = (numberOfElevators > MAX_ELEVATORS)?MAX_ELEVATORS:numberOfElevators;
        this.numberOfFloors = numberOfFloors;
        initializeElevators();
        pickupLocations = new LinkedList<>();
    }

    private void initializeElevators() {
        elevators = new ArrayList<>();
        for (int i = 0; i < this.numberOfElevators; i++) {
            elevators.add(new Elevator(1));
        }
    }

    public ArrayList<Elevator> getElevators() {
        return elevators;
    }

    @Override
    public void pickup(Integer pickUpFloor) {
        pickupLocations.add(pickUpFloor);
    }

    @Override
    public void destination(Integer elevatorId, Integer destinationFloor) {
        elevators.get(elevatorId).addNewDestination(destinationFloor);
    }

    @Override
    public void step() {
        for (Elevator currentElevator : elevators) {
            switch (currentElevator.status()) {
                case ELEVATOR_EMPTY:
                    if (!pickupLocations.isEmpty()) {
                        currentElevator.addNewDestination(pickupLocations.poll());
                    }
                    break;
                case ELEVATOR_OCCUPIED:
                    switch (currentElevator.direction()) {
                        case ELEVATOR_UP -> currentElevator.moveUp();
                        case ELEVATOR_DOWN -> currentElevator.moveDown();
                        case ELEVATOR_HOLD -> currentElevator.popDestination();
                    }
                    if (currentElevator.direction() == ElevatorDirection.ELEVATOR_UP) {
                        break;
                    }
            }
        }
    }
}
