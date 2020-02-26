# Elevator Control System

Created by using IntelliJ IDEA

## Design

The elevator control system has two classes, an `Elevator` and an `ElevatorControlSystem`

### ElevatorControlSystem

The Elevator control system manages all of the elevators and process the next tick of the system.  It is responsible for
handling pickup requests which come from people outside of the elevator and destination requests which come from users
inside the elevator.

### Elevator

The Elevator manages which floor it's on, which floors it needs to go to, the status, and the direction of the elevator.

__ElevatorDirection__ - An elevator can be going in one of three directions
```java
public enum ElevatorDirection {
  ELEVATOR_UP,      // Elevator is going up
  ELEVATOR_DOWN,    // Elevator is going down
  ELEVATOR_HOLD     // Elevator is being held
}
```

__ElevatorStatus__ - Each elevator has one of two status
```java
public enum ElevatorStatus {
  ELEVATOR_OCCUPIED,  // Elevator is occupied by users inside who are request floors
  ELEVATOR_EMPTY      // Elevator is empty and can be used to request a pickup
}
```

### Running

Tests are created, so you can check this by run these tests.

__What you need to run them__

- org.junit.contrib:junit-theories:4.12
