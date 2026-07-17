package Hotel;

public class Costumer {
    //Attributes
    private String name;
    private int id;
    private String phonenumber;

    //constructor
    public Costumer(String name, int id, String phonenumber) {
        this.name = name;
        this.id = id;
        this.phonenumber = phonenumber;
    }

    //getter
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getPhonenumber() {
        return phonenumber;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }
    public void setphonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    //Display Method
    public void displaycustomerdetails()
    {
        System.out.println("========================= Costumer deatils ===================");
        System.out.println("Customer Name: " + name);
        System.out.println("Customer ID: " + id);
        System.out.println("Customer Phone Number: " + phonenumber);
        System.out.println("----------------------------------------------------------------------");
    }
}

