import java.util.*;

public class ParkingLotSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot(10,5,3);

        int option;

        do{

            System.out.println("\n---- Parking Lot Menu ----");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Parking Status");
            System.out.println("0. Exit");

            option = sc.nextInt();
            sc.nextLine();

            switch(option){

                case 1:

                    System.out.println("Select vehicle type:");
                    System.out.println("1.Car 2.Bike 3.Truck");

                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter vehicle number: ");
                    String number = sc.nextLine();

                    Vehicle vehicle;

                    if(type==1)
                        vehicle = new Car(number);
                    else if(type==2)
                        vehicle = new Bike(number);
                    else
                        vehicle = new Truck(number);

                    Ticket ticket = parkingLot.parkVehicle(vehicle);

                    if(ticket != null){
                        System.out.println("Vehicle parked successfully!");
                        ticket.printTicket();
                    }else{
                        System.out.println("Parking full!");
                    }

                    break;

                case 2:

                    System.out.print("Enter ticket id: ");
                    int id = sc.nextInt();

                    parkingLot.exitVehicle(id);

                    break;

                case 3:

                    parkingLot.showStatus();
                    break;
            }

        }while(option!=0);

        sc.close();
    }
}

abstract class Vehicle {

    protected String vehicleNumber;

    public Vehicle(String number){
        vehicleNumber = number;
    }

    public abstract String getType();
}

class Car extends Vehicle {

    public Car(String number){
        super(number);
    }

    public String getType(){
        return "Car";
    }
}

class Bike extends Vehicle {

    public Bike(String number){
        super(number);
    }

    public String getType(){
        return "Bike";
    }
}

class Truck extends Vehicle {

    public Truck(String number){
        super(number);
    }

    public String getType(){
        return "Truck";
    }
}

class ParkingSpot {

    int spotId;
    String type;
    boolean occupied;

    public ParkingSpot(int id,String type){
        this.spotId=id;
        this.type=type;
        this.occupied=false;
    }
}

class Ticket {

    int ticketId;
    Vehicle vehicle;
    ParkingSpot spot;
    long entryTime;

    public Ticket(int id,Vehicle vehicle,ParkingSpot spot){

        this.ticketId=id;
        this.vehicle=vehicle;
        this.spot=spot;
        this.entryTime=System.currentTimeMillis();
    }

    public void printTicket(){

        System.out.println("\n----- Ticket -----");
        System.out.println("Ticket ID: "+ticketId);
        System.out.println("Vehicle: "+vehicle.vehicleNumber);
        System.out.println("Type: "+vehicle.getType());
        System.out.println("Spot: "+spot.spotId);
    }
}

class ParkingLot {

    List<ParkingSpot> spots = new ArrayList<>();
    Map<Integer,Ticket> activeTickets = new HashMap<>();

    int ticketCounter=1;

    public ParkingLot(int car,int bike,int truck){

        int id=1;

        for(int i=0;i<car;i++)
            spots.add(new ParkingSpot(id++,"Car"));

        for(int i=0;i<bike;i++)
            spots.add(new ParkingSpot(id++,"Bike"));

        for(int i=0;i<truck;i++)
            spots.add(new ParkingSpot(id++,"Truck"));
    }

    public Ticket parkVehicle(Vehicle vehicle){

        for(ParkingSpot spot:spots){

            if(!spot.occupied && spot.type.equals(vehicle.getType())){

                spot.occupied=true;

                Ticket ticket = new Ticket(ticketCounter++,vehicle,spot);

                activeTickets.put(ticket.ticketId,ticket);

                return ticket;
            }
        }

        return null;
    }

    public void exitVehicle(int ticketId){

        if(!activeTickets.containsKey(ticketId)){
            System.out.println("Invalid ticket!");
            return;
        }

        Ticket ticket = activeTickets.get(ticketId);

        long exitTime = System.currentTimeMillis();

        long hours = (exitTime-ticket.entryTime)/3600000 +1;

        int fee = calculateFee(ticket.vehicle.getType(),(int)hours);

        ticket.spot.occupied=false;

        activeTickets.remove(ticketId);

        System.out.println("Parking fee: Rs "+fee);
        System.out.println("Vehicle exited.");
    }

    private int calculateFee(String type,int hours){

        int rate;

        if(type.equals("Car"))
            rate=30;
        else if(type.equals("Bike"))
            rate=10;
        else
            rate=50;

        return rate*hours;
    }

    public void showStatus(){

        int free=0;

        for(ParkingSpot spot:spots)
            if(!spot.occupied)
                free++;

        System.out.println("Total spots: "+spots.size());
        System.out.println("Free spots: "+free);
    }
}
