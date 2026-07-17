package Hotel;
import java.util.Scanner;
import java.util.ArrayList;

public class HotelManager {
    //Attributes
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    //Constructor
    public HotelManager() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    //Add Room
    public void addRoom(Room room) {
        rooms.add(room);
    }
   //Method overloaded
    public void addRoom(Scanner Input){
        System.out.print("Enter Room Number: ");
        String RoomNumber = Input.next();

        System.out.print("Enter Room Category (Standard/Deluxe/Suite)");
        String  category= Input.next();

        System.out.print("Enter Room Price: ");
        double price = Input.nextDouble();

        //Room Object
        Room room = new Room(RoomNumber, category, price);
        //Call Method
        this.addRoom(room);
        //Save Rooms To File
        FileManager fm = new FileManager();
        fm.writeRooms(rooms);
        System.out.println("Room Added Successfully ");

    }

    //View All Rooms
    public void viewAllRooms() {
        if (rooms.isEmpty()) {
            System.out.println("There are no room available.");
            return;
        }
        for (Room room : rooms) {
            room.displayroom();
        }
    }
    //getter
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    //Search Room By category
    public void searchRoomByCategory(String Category) {
        boolean found = false;
        for (Room room : rooms) {
            if (room.getcategory().equalsIgnoreCase(Category)) {
                room.displayroom();
                found = true;

            }
        }
        if (!found) {
            System.out.println("No Rooms Found In This Category.");
        }

    }

    //Search Availabe Rooms
    public void searchAvailableRooms() {
        boolean found = false;
        for (Room room : rooms) {
            if (room.isavailable()) {
                room.displayroom();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Available Rooms Found.");
        }

    }

    //Book Room
    public boolean bookRoom(Reservation reservation) {
        if(reservation.getRoom().isavailable()) {
            reservations.add(reservation);
            reservation.getRoom().setavailable(false);
            System.out.println("Room Booked Successfully!.");
            return true;
        }else{
            System.out.println("Sorry room Is already Booked.");
            return false;
        }
    }

    //Method Overload bookRoom
    public void bookRoom( Scanner Input) {
        System.out.print("Enter Your Name");
        String name = Input.next();

        System.out.print("Enter Your Id");
        int id = Input.nextInt();

        System.out.print("Enter Your Phone Number");
        String phonenumber = Input.next();

        System.out.print("Enter Your Room Number");
        String RoomNumber = Input.next();
        Room room = null;
        for (Room r : rooms) {
            if(r.getRoomNumber().equalsIgnoreCase(RoomNumber)) {
                room=r;
                break;
            }
        }if(room==null) {
            System.out.println("Room Not Found.");
            return;
        }

        //Costumer
        Costumer c = new Costumer(name,id,phonenumber);

        //Reservation Object
        System.out.print("Enter Reservation ID");
        int reservationId = Input.nextInt();

        System.out.print("Enter Your Booking Dates");
        String BookingDate =Input.next();

        System.out.print("Enter Your Payment status(Paid/Unpaid)");
        String PaymentStatus =Input.next();

        //Reservation Object
        Reservation reservation = new Reservation(reservationId,BookingDate,PaymentStatus,"Booked",c,room);

        //save Reservation to File
       if(this.bookRoom(reservation)) {
           FileManager fm = new FileManager();
           fm.writeReservations(reservation);
           fm.writeRooms(rooms);
       }

    }
    // Call Cancel Reservation
    public void cancelReservation(Reservation reservation) {
        if(reservations.contains(reservation)) {
            reservation.CancelReservation();
        }else{
            System.out.println("Reservation Not Found.");
        }
    }

    //Overload Cancel reservation
    public void cancelReservation(Scanner input) {

        System.out.print("Enter Reservation ID: ");
        int reservationId = input.nextInt();

        Reservation reservation = null;

        for (Reservation r : reservations) {
            if (r.getResevationId() == reservationId) {
                reservation = r;
                break;
            }
        }

        if (reservation == null) {
            System.out.println("Reservation Not Found.");
            return;
        }

        this.cancelReservation(reservation);

        FileManager fm = new FileManager();
        fm.writeRooms(rooms);
    }



    //View All Reservations
    public void viewAllReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No Reservation Found.");
            return;
        }
        for (Reservation reservation : reservations) {
            reservation.ReservationDetails();
        }
    }

}

