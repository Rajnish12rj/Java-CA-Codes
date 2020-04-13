/*Ashish-11810804*/

/*6.Create an abstract class FundTransfer with following attributes- accountNumber	String,balance	Double

Method	Description
Boolean validate(Double transfer)	to check if the accountNumber is 10 digits,
transfer amount is non-negative and less than balance, and return true, if not return false
Boolean transfer(Double transfer)	abstract method with no definition

Create a class NEFTTransfer which extends FundTransfer and implements transfer method,

Boolean transfer(Double transfer)	check if transfer amount+5% of transfer amount is less than balance,
then subtracts transfer amount and 5% service charge from balance and return true, if not return false

Create a class IMPSTransfer which extends FundTransfer and implements transfer method,

Boolean transfer(Double transfer)	check if transfer amount+2% of transfer amount is less than balance,
then subtracts transfer amount and 2% service charge from balance and return true, if not return false

Create a class RTGSTransfer which extends FundTransfer and implements transfer method,

Boolean transfer(Double transfer)	check if transfer amount is greater than Rs.10000,
then subtracts transfer amount from balance and return true, if not return false

Add appropriate getters/setters, constructors with super() to create objects. Write a driver class Main to test them.

Note: Print "Account number or transfer amount seems to be wrong" if validate function returns false.
print "Transfer could not be made" if transfer function returns false.
Print the statements in main method.
*/

import java.util.Scanner;

abstract class FundTransfer {
    static String account_no;
    static double balance;

    Boolean validate(Double transfer){
        if(account_no.length()==10&&transfer>0&&transfer<balance)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    abstract Boolean transfer(Double transfer);
}

class NEFTTransfer extends FundTransfer{
    public NEFTTransfer(String account_no,Double balance) {
        super.balance=balance;
        super.account_no=account_no;
    }

    Boolean transfer(Double transfer) {
        if (super.balance>1.05*transfer) {
            balance = super.balance - 1.05*transfer;
            System.out.println("Transferred occurred successfully!!!");
            System.out.println("Remaining Balance is : "+balance);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}

class IMPSTransfer extends FundTransfer{
    public IMPSTransfer(String account_no,Double balance) {
        super.balance=balance;
        super.account_no=account_no;
    }

    Boolean transfer(Double transfer) {
        if(transfer*1.02<balance){
            balance=balance-1.02*transfer;
            System.out.println("Transferred occurred successfully!!!");
            System.out.println("Remaining Balance is : "+balance);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}

class RTGSTransfer extends FundTransfer{
    public RTGSTransfer(String account_no,Double balance) {
        super.balance=balance;
        super.account_no=account_no;
    }

    Boolean transfer(Double transfer) {
        if(transfer>10000){
            balance=balance-transfer;
            System.out.println("Transferred occurred successfully!!!");
            System.out.println("Remaining Balance is : "+balance);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}

class Main{
    static Scanner string_obj=new Scanner(System.in);
    static Scanner int_obj=new Scanner(System.in);
    static Scanner double_obj=new Scanner(System.in);
    static int amount;

    static double amount(){
        System.out.println("Enter the amount to be transferred :");
        amount=int_obj.nextInt();
        return (double)amount;
    }

    public static void main(String[]args){
        System.out.println("Enter the account No. :");
        String account_no=string_obj.nextLine();
        System.out.println("Enter the balance of account :");
        double balance=double_obj.nextDouble();

        System.out.println("Enter the type of Fund Transfer to be made :\n1. NEFT\n2. IMPS\n3. RTGS");
        int choice=int_obj.nextInt();
        switch (choice){
            case 1:
                double amount1=amount();
                boolean val1 =new NEFTTransfer(account_no,balance).validate(amount1);
                if(val1) {
                    boolean value1 = new NEFTTransfer(account_no, balance).transfer(amount1);
                    if(!value1)
                        System.out.println("Transfer Failed!!!");
                }
                else
                    System.out.println("Account No or Transfer amount seems to be Wrong!!!");
                break;
            case 2:
                double amount2=amount();
                boolean val2 =new IMPSTransfer(account_no,balance).validate(amount2);
                if(val2) {
                    boolean value2 = new IMPSTransfer(account_no, balance).transfer(amount2);
                    if(!value2)
                        System.out.println("Transfer Failed!!!");
                }
                else
                    System.out.println("Account No or Transfer amount seems to be Wrong!!!");
                break;
            case 3:
                double amount3=amount();
                boolean val3 =new RTGSTransfer(account_no,balance).validate(amount3);
                if(val3) {
                    boolean value3 = new RTGSTransfer(account_no, balance).transfer(amount3);
                    if(!value3)
                        System.out.println("Transfer Failed!!!");
                }
                else
                    System.out.println("Account No or Transfer amount seems to be Wrong!!!");
                break;
            default:
                System.out.println("You have to choose from given 3 options");
        }
    }
}
