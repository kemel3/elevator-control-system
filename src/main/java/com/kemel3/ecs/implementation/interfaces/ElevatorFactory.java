package main.java.com.kemel3.ecs.implementation.interfaces;

import main.java.com.kemel3.ecs.implementation.enums.ElevatorDirection;
import main.java.com.kemel3.ecs.implementation.enums.ElevatorStatus;

public interface ElevatorFactory {
    public void moveUp();
    public void moveDown();
    public void addNewDestination(Integer destination);
    public ElevatorDirection direction();
    public ElevatorStatus status();
}
