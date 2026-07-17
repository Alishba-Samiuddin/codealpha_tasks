package Hotel;
import java.io.*;
import java.util.ArrayList;


public class FileManager {
    //write Reservations
    public void writeReservations(Reservation reservation) {

        try {
            FileWriter writer = new FileWriter("booking.txt", true);
            writer.write("Reservation Id: " + reservation.getResevationId() + "\n");
            writer.write("Customer: " + reservation.getCostumer().getName() + "\n");
            writer.write("Room: " + reservation.getRoom().getRoomNumber() + "\n");
            writer.write("Category: " + reservation.getRoom().getcategory() + "\n");
            writer.write("Price: " + reservation.getRoom().getprice() + "\n");
            writer.write("Booking Date: " + reservation.getBookingDate() + "\n");
            writer.write("Reservation Status: " + reservation.getReservationStatus() + "\n");
            writer.write("Refund Status: " + reservation.getRefundStatus()+"\n");
            writer.write("Payment Status: " + reservation.getPaymentStatus() + "\n");
            writer.write("------------------------------------------------------------------------------\n");
            writer.close();
            System.out.println("Reservation has been saved successfully");
        }catch(IOException e){
            System.out.println("Error while saving reservation");
        }
    }
    //Read Reservations
    public void readReservations(){

        try{
            FileReader reader=new FileReader("booking.txt");
            BufferedReader br=new BufferedReader(reader);
            String line;
            while ((line= br.readLine()) !=null){
            System.out.println(line);
            }
            br.close();
        }catch(IOException e){
            System.out.println("Error while reading reservations");
        }
    }
    //Write Rooms
    public void writeRooms(ArrayList<Room> rooms) {

        try{
            FileWriter writer= new FileWriter("room.txt");
            for(Room room:rooms){
                writer.write("Room Number: " + room.getRoomNumber()+"\n");
                writer.write("Category: " + room.getcategory()+"\n");
                writer.write("Price: " + room.getprice()+"\n");
                writer.write("Availability: " + (room.isavailable() ? "Yes" : "No") +"\n");
                writer.write("---------------------------------------------------------\n");
            }
            writer.close();
            System.out.println("Room has been saved to the file successfully.");
        }catch(IOException e){
            System.out.println("Error while saving rooms.");
        }

    }
    //Read Rooms
    public void readRooms() {

        try{
            FileReader reader= new FileReader("room.txt");
            BufferedReader br=new BufferedReader(reader);
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
        }catch(IOException e){
            System.out.println("Error while reading rooms");
        }
    }

}



