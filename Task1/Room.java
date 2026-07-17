package Hotel;

public class Room {
    //Attributes
    private String RoomNumber;
    private String category;
    private double price;
    private boolean available;

    //Constructor
    public Room(String roomNumber, String category, double price) {
        this.RoomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.available = true;
    }

    //getter
    public String getRoomNumber() {
        return RoomNumber;
    }
    public String getcategory() {
        return category;
    }
    public double getprice() {
        return price;
    }
    public boolean isavailable() {
        return available;
    }

    //setter
    public void setavailable(boolean available) {
        this.available = available;
    }

    //Display Method
    public void displayroom(){
        System.out.println("========================= Room Details ========================");
        System.out.println("Room Number: " + RoomNumber);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
        System.out.println("Available: " + (available?"Yes":"No"));

    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
}}
