/*Ashish-11810804*/

/*WAP to define 2 interfaces UGC and AICTE both
with default method int getAdmission() to take admisiion and 
an abstract method String payFee()
getAdmission in UGC must ask percentage in qualifying exam and 
if % >=60 then generate and return regNo 
getAdmission in AICTE must ask user to join counceling after 5 days and 
display date of counseling and return counseling token no

Create a class University which inherits both UGC and AICTE
overrides the getAdmission() method only such that it will ask the percentage
if direct admission through UGC is possible then proceed otherwise proceed through AICTE.
University must have attribute fee_due and it should be assigned the due amount accordingly.
(E.g fee through UGC is 25000 & fee through AICTE is 34000)
Create a class LPU which inherits University and overrides all the methods.
Ask the user to deposit the fee and display the fee due.
After depositing the fee display the remaining due fee and return the receipt number.
*/

import java.util.Scanner;
interface UGC1{
    String payFee(int a);

    default int getAdmission(){
        System.out.println("Enter your percentage again");
        float per=new Scanner(System.in).nextFloat();
        if(per>=60.00f){
            System.out.println("So you percentage is "+per+"\nYou pass the quota!!!\nHere's your reg no :");
        }
        return (int)per*101;
    }
}

interface AICTE1 {
    String payFee(int a);

    default int getAdmission() {
        System.out.println("You are applicable for counseling after 5 days\nEnter 1 if You wanna Join in");
        int ask = new Scanner(System.in).nextInt();
        if (ask == 1) {
            System.out.println("See you at RADWIMPS Hotel on 1st April 2020 \nHere's your token no :");
        }
        return 2020;
    }
}

class University1 implements UGC1,AICTE1{
    int fee_due;
    public String payFee(int a){
        int fee=new Scanner(System.in).nextInt();
        if(a==0){
            fee_due=25000-fee;
            System.out.println("You paid your fee \nDue is "+fee_due);
            return "k18sp";
        }
        else {
            fee_due=34000-fee;
            System.out.println("You paid your fee \nDue is "+fee_due);
            return "k18tp";
        }
    }

    public int getAdmission(){
        float per=new Scanner(System.in).nextFloat();
        if(per>=60.0){
            int token_no=UGC1.super.getAdmission();
            System.out.println(token_no);
            return 0;
        }
        else{
            int a=AICTE1.super.getAdmission();
            System.out.println(a);
            return 1;
        }
    }
}

class LPU1 extends University1{
    public static void main(String[]args){
        System.out.println("Enter your percentage");
        int a=new University1().getAdmission();

            System.out.println("Would you like to pay your fee Now???\n34000 by counseling and 25000 on percentage basis -\nPress 1 for Yes and 0 for no");
            int yes=new Scanner(System.in).nextInt();
            if(yes==1) {
                System.out.println("Pay your fee");
                if (a == 0) {
                    String var1 = new University1().payFee(a);
                    System.out.println("Your receipt no is :\n" + var1);
                }
                if (a == 1) {
                    String var2 = new University1().payFee(a);
                    System.out.println("Your receipt no is :\n" + var2);
                }
            }
        else
            System.out.println("Hope you will join US!!!");
    }
}