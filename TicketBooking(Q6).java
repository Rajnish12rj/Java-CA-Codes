/*Ashish-11810804*/

/*5. Create a class named TicketBooking with the following private attributes.
Attributes	Datatype
stageEvent	String
customer	String
noOfSeats	Integer

Include getters and setters for the class.
Include default and parameterized constructors.

public void makePayment(Double amount)	-This method is for cash payment.
This method accepts amount as input and displays the transaction detail.
public void makePayment(String walletNumber ,Double amount)- This method is for wallet payment.
This method accepts amount and wallet number as input and displays the transaction detail.
public void makePayment(String creditCard,String ccv,String name,Double amount)-This method is for credit card payment.
This method accepts credit card detail,ccv, card holder name ,and amount as input and displays the transaction detail.

Create Main class. In the Main method, obtain input from the user in CSV format and call appropriate methods for transactions.
If choice other than specified is chosen, print "Invalid choice".
Note: display one digit after decimal point for double values.
Format for TicketBooking Input is stageEvent,customer,noOfSeats
[Strictly adhere to the Object-Oriented Specifications given in the problem statement.
All class names, attribute names and method names should be the same as specified in the problem statement.
*/


import java.util.Scanner;

class TicketBooking {
    private String stage_event,customer;
    private int no_of_seats;

    public void setStage_event(String stage_event) {
        this.stage_event = stage_event;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setNo_of_seats(int no_of_seats) {
        this.no_of_seats = no_of_seats;
    }

    public String getStage_event() {
        return stage_event;
    }

    public String getCustomer() {
        return customer;
    }

    public int getNo_of_seats() {
        return no_of_seats;
    }

    TicketBooking(){}
    TicketBooking(String stage_event,String customer,int no_of_seats){
        setStage_event(stage_event);
        setCustomer(customer);
        setNo_of_seats(no_of_seats);
    }

    public void display(){
        System.out.println("Stage Event :"+getStage_event());
        System.out.println("Customer :"+getCustomer());
        System.out.println("No. of seats :"+getNo_of_seats());
    }

    public void makePayment(Double amount){
        display();
        System.out.println("Amount "+amount+" paid in cash");
    }

    public void makePayment(String walletNumber ,Double amount){
        display();
        System.out.println("Amount "+amount+" paid Using Wallet No. : "+walletNumber);
    }

    public void makePayment(String creditCard,String ccv,String name,Double amount){
        display();
        System.out.println("Holder Name : "+name+"\nAmount "+amount+" paid Using : "+creditCard+"\nCVV : "+ccv);
    }
}

class Main{
    static Scanner int_obj=new Scanner(System.in);
    static Scanner string_obj=new Scanner(System.in);

    static double amount(){
        System.out.println("Enter the amount :");
        int amount=int_obj.nextInt();
        return (double)amount;
    }

    public static void main(String[]args){
        System.out.println("Enter Booking Details :");
        try {
            String input = string_obj.nextLine();
            String[] numbers = input.split(",");

            String event_name = numbers[0];
            String customer = numbers[1];
            int no_of_customers = Integer.parseInt(numbers[2]);

        System.out.println("Payment Mode :\n1. Cash Payment\n2. Wallet Payment\n3. Card Payment");
        int choice=int_obj.nextInt();
        switch (choice){
            case 1:
                double amount=amount();
                new TicketBooking(event_name,customer,no_of_customers).makePayment(amount);
                break;
            case 2:
                double amount1=amount();
                System.out.println("Enter the wallet No. :");
                String wallet_no=string_obj.nextLine();
                new TicketBooking(event_name,customer,no_of_customers).makePayment(wallet_no,amount1);
                break;
            case 3:
                System.out.println("Enter the card holder name :");
                String name=string_obj.nextLine();
                double amount2=amount();
                System.out.println("Enter credit card type :");
                String card_type=string_obj.nextLine();
                System.out.println("Enter the CVV no. :");
                String cvv=string_obj.nextLine();
                new TicketBooking(event_name,customer,no_of_customers).makePayment(card_type,cvv,name,amount2);
                break;
            default:
                System.out.println("Invalid Choice");
        }
        } catch (Exception e) {
            System.out.println("The format should be :-\nEvent_name,Customer_name,No_Of_Tickets");;
        }
    }
}
