package Hotel;

public class Reservation {
    //Attributes
    private Costumer costumer;
    private Room room;
    private int ReservationId;
    private String BookingDate;
    private String PaymentStatus;
    private String ReservationStatus;
    private String RefundStatus;

    //Constructor
    public Reservation(int ReservationId, String BookingDate, String PaymentStatus, String ReservationStatus, Costumer costumer, Room room){

            this.ReservationId = ReservationId;
            this.BookingDate = BookingDate;
            this.PaymentStatus = PaymentStatus;
            this.ReservationStatus = ReservationStatus;
            this.costumer = costumer;
            this.room = room;
            this.RefundStatus = "Not Refunded";

        }
        //getter
        public int getResevationId(){
            return ReservationId;
        }
        public String getBookingDate(){
        return BookingDate;
        }
        public String getPaymentStatus(){
        return PaymentStatus;
        }
        public String getReservationStatus(){
        return ReservationStatus;
        }
        public Costumer getCostumer(){
        return costumer;
        }
        public Room getRoom(){
        return room;
        }
        public String getRefundStatus(){
        return RefundStatus;
        }

        //setter
    public void setPaymentStatus(String PaymentStatus){
        this.PaymentStatus = PaymentStatus;
    }
    public void setReservationStatus(String ReservationStatus){
        this.ReservationStatus = ReservationStatus;
    }

    //Payment Method
    public void PaymentMethod(){
        System.out.println("===========Payment Details===========");
        if(PaymentStatus.equalsIgnoreCase("Unpaid")){
            PaymentStatus = "Paid";
            System.out.println("Payment Successfull!");
    }else{
            System.out.println("Payment Already Made!");
        }
        System.out.println("---------------------------------------------------------");
 }
   //Cancel Reservation Method
    public void CancelReservation(){
        System.out.println("=========== Cancel Reservation ==========");
        ReservationStatus="Cancelled";
        room.setavailable(true);
        if(PaymentStatus.equalsIgnoreCase("Paid")) {
            System.out.println("Reservation Cancelled.");
            System.out.println("Please process refund.");

        } else {

            System.out.println("Reservation Cancelled.");
        }
        System.out.println("---------------------------------------------------------");
    }
    //Refund Method
    public void RefundMethod() {
        System.out.println("=========== Refund Status ==========");

        if (ReservationStatus.equalsIgnoreCase("Cancelled")
                && PaymentStatus.equalsIgnoreCase("Paid")
                && RefundStatus.equalsIgnoreCase("Not Refunded")) {

            RefundStatus = "Refunded";
            PaymentStatus = "Unpaid";   // Optional
            System.out.println("Refund Successful!");

        } else if (PaymentStatus.equalsIgnoreCase("Unpaid")) {

            System.out.println("No Payment Found!");

        } else if (RefundStatus.equalsIgnoreCase("Refunded")) {

            System.out.println("Refund Already Processed!");

        } else {

            System.out.println("Refund is only allowed after cancellation!");
        }

        System.out.println("---------------------------------------------------------");
    }

    //Reservations Detail Method
    public void ReservationDetails(){
        System.out.println("=========== Reservation Details ==========");
        System.out.println("Reservation Id: " + ReservationId);
        System.out.println("Costumer: " + costumer.getName());
        System.out.println("Room: " + room.getRoomNumber());
        System.out.println("Category: "+room.getcategory());
        System.out.println("Price: " + room.getprice());
        System.out.println("Booking Date: " + BookingDate);
        System.out.println("Payment Status: " + PaymentStatus);
        System.out.println("Reservation Status: " + ReservationStatus);
        System.out.println("Refund Status: " + RefundStatus);
        System.out.println("---------------------------------------------------------");
    }

}


