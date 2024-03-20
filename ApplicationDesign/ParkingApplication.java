package ApplicationDesign;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;


//RAZORPAY: Technical round question

class Vehicle {
    String type;
    String vehicleNumber;
    LocalTime entryTime;

    public Vehicle(String type, String vehicleNumber, LocalTime entryTime) {
        this.type = type;
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
    }
}

public class ParkingApplication {
    Map<Vehicle, String> vehicles = new HashMap<>();
    int intialSUVParkingSpace = 10;
    int intialHatchBackParkingSpace = 10;
    int noOfHatchBacksEntered = 0;
    int noOfSuvEntered = 0;

    public void vehicleEntered(Vehicle vehicle, LocalTime timeOfEntry) {
        if (vehicle.type == "SUV") {
            if (intialSUVParkingSpace > 0) {
                vehicle.entryTime = timeOfEntry;
                vehicles.put(vehicle, vehicle.vehicleNumber);
                intialSUVParkingSpace--;

            }
        } else if (vehicle.type == "hatchBack") {
            if (intialHatchBackParkingSpace > 0) {
                vehicle.entryTime = timeOfEntry;
                vehicles.put(vehicle, vehicle.vehicleNumber);
                intialHatchBackParkingSpace--;
            } else if (intialSUVParkingSpace > 0) {
                vehicle.entryTime = timeOfEntry;
                vehicles.put(vehicle, vehicle.vehicleNumber);
                intialSUVParkingSpace--;
            }
        }
        System.out.println("Vehicles entering compound");
        vehicles.forEach((vehicle1, vehicleNumber) -> {
            System.out.println("[ " + vehicle1.type + " : " + vehicleNumber + " ]");
        });
    }

    public long vehicleExited(Vehicle vehicle) {
        long totalParkingCharge = 0;
        LocalTime currentTime = LocalTime.now();
        long totalTime = ChronoUnit.HOURS.between(vehicle.entryTime, currentTime);
        if (vehicle.type == "SUV") {

            totalParkingCharge = 20 * totalTime;
        } else if (vehicle.type == "hatchback") {
            totalParkingCharge = 10 * totalTime;

        }
        System.out.println("Vehicle exiting");
        System.out.println("[ " + vehicle.type + " : " + vehicle.vehicleNumber + " ]");
        vehicles.remove(vehicle);

        return totalParkingCharge;
    }

    public static void main(String args[]) {
        ParkingApplication parkingApplication = new ParkingApplication();
        Vehicle v1 = new Vehicle("SUV", "kl7sj1056", LocalTime.now());
        parkingApplication.vehicleEntered(v1, v1.entryTime);
        parkingApplication.vehicleExited(v1);
    }

}
