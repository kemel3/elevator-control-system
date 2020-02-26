package test.main.java.com.kemel3.esc.implementation;

import main.java.com.kemel3.ecs.implementation.Elevator;
import main.java.com.kemel3.ecs.implementation.ElevatorControlSystem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/** 
* ElevatorControlSystem Tester. 
* 
* @author <Kamil Jop>
* @since <pre>Feb 26, 2020</pre> 
* @version 1.0 
*/ 
public class ElevatorControlSystemTest {
    public static final int ELEVATOR_ID_ZERO = 0;
    public static final int ELEVATOR_ID_ONE = 1;
    public static final int TENTH_FLOOR = 10;
    public static final int FIRST_FLOOR = 1;
    public static final int SEVENTH_FLOOR = 7;
    private ElevatorControlSystem elevatorControlSystem;
    private ArrayList<Elevator> elevators;

    @Before
    public void initialize() {
        elevatorControlSystem = new ElevatorControlSystem(2, 20);
    }

/** 
* 
* Method: getElevators() 
* 
*/ 
    @Test
    public void testGetElevator() {
        elevatorControlSystem.pickup(TENTH_FLOOR);
        for (int i = 0; i < TENTH_FLOOR; i++) {
            elevatorControlSystem.step();
        }
        elevators = elevatorControlSystem.getElevators();
        assertEquals(TENTH_FLOOR, elevators.get(ELEVATOR_ID_ZERO).currentFloor());
    }

    @Test
    public void testElevatorTwoNotMoving(){
        elevatorControlSystem.pickup(TENTH_FLOOR);
        for (int i = 0; i < TENTH_FLOOR; i++){
            elevatorControlSystem.step();
        }
        elevators = elevatorControlSystem.getElevators();
        assertEquals(FIRST_FLOOR, elevators.get(ELEVATOR_ID_ONE).currentFloor());
    }

/** 
* 
* Method: pickup(Integer pickUpFloor) 
* 
*/ 
    @Test
    public void testPickup() {
        elevatorControlSystem.pickup(TENTH_FLOOR);
        elevatorControlSystem.pickup(SEVENTH_FLOOR);
        for (int i = 0; i < TENTH_FLOOR; i++){
            elevatorControlSystem.step();
        }
        elevators = elevatorControlSystem.getElevators();
        assertEquals(TENTH_FLOOR, elevators.get(ELEVATOR_ID_ZERO).currentFloor());
        assertEquals(SEVENTH_FLOOR, elevators.get(ELEVATOR_ID_ONE).currentFloor());
    }

/** 
* 
* Method: destination(Integer elevatorId, Integer destinationFloor) 
* 
*/ 
    @Test
    public void testDestination() {
        elevatorControlSystem.destination(ELEVATOR_ID_ZERO, TENTH_FLOOR);
        for (int i = 0; i < TENTH_FLOOR; i++){
            elevatorControlSystem.step();
        }
        elevators = elevatorControlSystem.getElevators();
        assertEquals(TENTH_FLOOR, elevators.get(ELEVATOR_ID_ZERO).currentFloor());
    }

/** 
* 
* Method: step() 
* 
*/ 
    @Test
    public void testStep() {
        elevatorControlSystem.destination(ELEVATOR_ID_ZERO, TENTH_FLOOR);
        for (int i = 0; i < TENTH_FLOOR; i++){
            elevatorControlSystem.step();
        }
        elevators = elevatorControlSystem.getElevators();
        assertEquals(TENTH_FLOOR, elevators.get(ELEVATOR_ID_ZERO).currentFloor());
    }


/** 
* 
* Method: initializeElevators() 
* 
*/ 
    @Test
    public void testInitializeElevators() {
        elevatorControlSystem.destination(ELEVATOR_ID_ZERO, TENTH_FLOOR);
        elevatorControlSystem.destination(ELEVATOR_ID_ZERO, SEVENTH_FLOOR);
        for (int index = 0; index < TENTH_FLOOR; index++){
            elevatorControlSystem.step();
        }
        elevators = elevatorControlSystem.getElevators();
        assertEquals(TENTH_FLOOR, elevators.get(ELEVATOR_ID_ZERO).currentFloor());
        for (int i = 0; i < TENTH_FLOOR-SEVENTH_FLOOR; i++){
            elevatorControlSystem.step();
        }
        elevators = elevatorControlSystem.getElevators();
        assertEquals(SEVENTH_FLOOR, elevators.get(ELEVATOR_ID_ZERO).currentFloor());
    }
} 
