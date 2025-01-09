package objects.flight;

import objects.exceptions.DoublePerson;
import objects.exceptions.PlaneFullException;
import objects.person.Person;
import objects.person.non_staff.Passenger;
import objects.person.staff.Staff;

import java.util.ArrayList;
import java.util.List;

public class Plane {
    private int planeSize; // Maximale capaciteit van het vliegtuig
    private List<Staff> staffList = new ArrayList<>(); // Lijst van personeel aan boord
    private List<Passenger> passengerList = new ArrayList<>(); // Lijst van passagiers aan boord
    private Flight flight; // De vlucht die aan dit vliegtuig is toegewezen

    public Plane(int planeSize) {
        this.planeSize = planeSize;
    }

    //antal personen aan boord van het vliegtuig (passagiers + personeel) te berekenen
    public int getNumberPersons() {
        return passengerList.size() + staffList.size();
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    // Geeft de maximale capaciteit van het vliegtuig terug
    public int getPlaneSize() {
        return planeSize;
    }

    // Voegt een persoon toe aan het vliegtuig
    public void addPerson(Person person) {
        try {
            // Controleer of de persoon een passagier is
            if (person instanceof Passenger) {
                // Controleer of er nog ruimte is, en voeg toe als dat zo is
                if (passengerList.size() < planeSize) {
                    passengerList.add((Passenger) person);
                    // Controleer of de passagier al aan boord is
                } else if (passengerList.contains(person)){
                    throw new DoublePerson("The person is already on the plane");
                    // Gooi een uitzondering als het vliegtuig vol is
                } else {
                    throw new PlaneFullException("The plane is full");
                }
            }
            // Zelfde als passagier maar met personeel in plaats van passagiers
            else {
                if (staffList.size() < planeSize) {
                    staffList.add((Staff) person);
                } else if (staffList.contains(person)){
                    throw new DoublePerson("The person is already on the plane");
                } else {
                    throw new PlaneFullException("The plane is full");
                }
            }
            // Verwerk mogelijke uitzonderingen voor dubbele personen of een vol vliegtuig
        } catch (DoublePerson | PlaneFullException e) {
            System.out.println("Error in adding person to the plane");
        }
    }
}