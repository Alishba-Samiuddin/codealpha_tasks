package Hotel;

import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        HotelManager hm=new HotelManager();
        FileManager fm=new FileManager();

        //Do While
        int choice;
        do{
            System.out.println("====================================");
            System.out.println("     HOTEL RESERVATION SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Room.");
            System.out.println("2. View All Rooms.");
            System.out.println("3. Search Room by Category.");
            System.out.println("4. Search Available Room.");
            System.out.println("5. Book Room.");
            System.out.println("6. View Reservations.");
            System.out.println("7. Cancel Reservation.");
            System.out.println("8. Save Data.");
            System.out.println("9. Load Data.");
            System.out.println("0. Exit.");
            System.out.println("====================================");
            System.out.print("Enter your choice: ");

            choice=input.nextInt();
            //Switch case
            switch(choice){
                case 1:
                   hm.addRoom(input);
                    break;
                case 2:
                    hm.viewAllRooms();
                     break;
                case 3:
                    System.out.print("Enter category: ");
                    String category = input.next();
                    hm.searchRoomByCategory(category);
                     break;
                case 4:
                    hm.searchAvailableRooms();
                    break;
                case 5:
                    hm.bookRoom(input);
                    break;
                case 6:
                    hm.viewAllReservations();
                      break;
                case 7:
                    hm.cancelReservation(input);
                      break;
                case 8:
                    fm.writeRooms(hm.getRooms());
                      break;
                case 9:
                    fm.readRooms();
                    fm.readReservations();
                     break;
                case 0:
                    System.out.println("Thank You!");
                    break;
                default:
                        System.out.println("Invalid choice please try again.");

            }
        }while(choice!=0);

    }
}

