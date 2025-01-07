package objects.flight;

import objects.person.non_staff.Passenger;
import objects.person.staff.FlightAttendant;
import objects.person.staff.Staff;

import java.util.ArrayList;
import java.util.List;

public class Flight {
     private int flightNumber;
     private String endDestination;
     private String startDestination;
     private Plane plane;

     public Flight() {
     }

     public Flight(int flightNumber, String endDestination, String startDestination, Plane plane) {
         this.flightNumber = flightNumber;
         this.endDestination = endDestination;
         this.startDestination = startDestination;
         this.plane = new Plane();

     }


     public int getFlightNumber() {
         return flightNumber;
     }

     public void setFlightNumber(int flightNumber) {
         this.flightNumber = flightNumber;
     }

     public String getEndDestination() {
         return endDestination;
     }

     public void setEndDestination(String endDestination) {
         this.endDestination = endDestination;
     }

     public String getStartDestination() {
         return startDestination;
     }

     public void setStartDestination(String startDestination) {
         this.startDestination = startDestination;
     }

     public Plane getPlane() {
         return plane;
     }

     public void setPlane(Plane plane) {
         this.plane = plane;
     }
 }



