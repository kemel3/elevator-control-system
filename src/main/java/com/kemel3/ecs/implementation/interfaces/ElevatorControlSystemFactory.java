package main.java.com.kemel3.ecs.implementation.interfaces;

public interface ElevatorControlSystemFactory {
    public void pickup(Integer pickUpFloor);
    public void destination(Integer elevatorId, Integer destinationFloor);
    public void step();
}
