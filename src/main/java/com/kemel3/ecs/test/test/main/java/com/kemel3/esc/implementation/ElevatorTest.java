package test.main.java.com.kemel3.esc.implementation;

import main.java.com.kemel3.ecs.implementation.Elevator;
import main.java.com.kemel3.ecs.implementation.enums.ElevatorDirection;
import main.java.com.kemel3.ecs.implementation.enums.ElevatorStatus;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/** 
* Elevator Tester. 
* 
* @author <Kamil Jop>
* @since <pre>Feb 26, 2020</pre> 
* @version 1.0 
*/ 
public class ElevatorTest {
    public static final int TENTH_FLOOR = 10;
    public static final int SECOND_FLOOR = 2;
    public static final int BASEMENT = -4;

    private Elevator elevator;

    @Before
    public void initializeElevator() {
        elevator = new Elevator(0);
    }

/** 
* 
* Method: nextDestination() 
* 
*/ 
    @Test
    public void testNextDestination() {
        elevator.addNewDestination(TENTH_FLOOR);
        assertEquals(TENTH_FLOOR, elevator.nextDestination());
    }

/** 
* 
* Method: currentFloor() 
* 
*/
    @Test
    public void testCurrentFloor() {
        // Move to second floor
        elevator.moveUp();
        elevator.moveUp();
        assertEquals(SECOND_FLOOR, elevator.currentFloor());
    }

/** 
* 
* Method: popDestination() 
* 
*/ 
    @Test
    public void testPopDestination() {
        elevator.moveDown();
        elevator.moveDown();
        elevator.moveDown();
        elevator.moveDown();
        assertEquals(BASEMENT, elevator.currentFloor());
    }

/** 
* 
* Method: moveUp() 
* 
*/ 
    @Test
    public void testMoveUp() {
        elevator.addNewDestination(SECOND_FLOOR);
        assertEquals(ElevatorDirection.ELEVATOR_UP, elevator.direction());
    }

/** 
* 
* Method: moveDown() 
* 
*/ 
    @Test
    public void testMoveDown() {
        elevator.addNewDestination(BASEMENT);
        assertEquals(ElevatorDirection.ELEVATOR_DOWN, elevator.direction());
    }

/** 
* 
* Method: direction() 
* 
*/ 
    @Test
    public void testDirectionHold() {
        assertEquals(ElevatorDirection.ELEVATOR_HOLD, elevator.direction());
    }

 /**
 *
 * Method: status()
 *
 */
    @Test
    public void testStatusEmpty() {
        assertEquals(ElevatorStatus.ELEVATOR_EMPTY, elevator.status());
    }

/** 
* 
* Method: status() 
* 
*/ 
    @Test
    public void testStatus() {
        elevator.addNewDestination(TENTH_FLOOR);
        assertEquals(ElevatorStatus.ELEVATOR_OCCUPIED, elevator.status());
    }
}
