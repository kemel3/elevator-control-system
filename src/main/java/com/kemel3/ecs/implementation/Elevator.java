package main.java.com.kemel3.ecs.implementation;

import main.java.com.kemel3.ecs.implementation.enums.ElevatorDirection;
import main.java.com.kemel3.ecs.implementation.enums.ElevatorStatus;
import main.java.com.kemel3.ecs.implementation.interfaces.ElevatorFactory;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements ElevatorFactory {
    private Integer currentFloor;
    private Queue<Integer> destinationFloors;

    public Elevator(Integer currentFloor) {
        this.currentFloor = currentFloor;
        this.destinationFloors = new LinkedList<>();
    }

    public int nextDestination() {
        return this.destinationFloors.peek();
    }

    public int currentFloor() {
        return this.currentFloor;
    }

    public void popDestination() {
        this.destinationFloors.remove();
    }

    @Override
    public void moveUp() {
        currentFloor++;
    }

    @Override
    public void moveDown() {
        currentFloor--;
    }

    @Override
    public void addNewDestination(Integer destination) {
        this.destinationFloors.add(destination);
    }

    @Override
    public ElevatorDirection direction() {
        if (destinationFloors.size() > 0) {
            if (currentFloor < destinationFloors.peek()) {
                return ElevatorDirection.ELEVATOR_UP;
            } else if (currentFloor > destinationFloors.peek()) {
                return ElevatorDirection.ELEVATOR_DOWN;
            }
        }
        return ElevatorDirection.ELEVATOR_HOLD;
    }

    @Override
    public ElevatorStatus status() {
        return (destinationFloors.size() > 0)?ElevatorStatus.ELEVATOR_OCCUPIED:ElevatorStatus.ELEVATOR_EMPTY;
    }
}
