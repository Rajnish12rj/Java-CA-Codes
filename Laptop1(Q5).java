/*Ashish-11810804*/

/*5. Create a class Laptop with attributes model_number, price and RAM.
In main class prompt the user to filter on the basis of model, price or RAM
if user selects Price then display all the laptops in descending order of the price
if user selects RAM then display all the laptops in ascending order of their RAM
if user select model then ask to enter the keyword for model and display all the laptops which contain that keyword in model_number.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Laptop1 {
String model_number;
int price,RAM;
boolean sorted=false;
static Laptop1 var;

Laptop1(){}

public Laptop1(String model_number, int price, int RAM) {
        this.model_number = model_number;
        this.price = price;
        this.RAM = RAM;
}

void price_method(ArrayList<Laptop1> array){
    System.out.println("Here,s the Laptops in descending order of Price :\n");
    //bubble sort
    Laptop1[] array1 = test_method(array);
    while (!sorted){
        sorted=true;
        for(int i=0;i<array1.length-1;i++){
            if(array1[i+1].price>array1[i].price){
                var=array1[i];
                array1[i]=array1[i+1];
                array1[i+1]=var;
                sorted=false;
            }
        }
    }
    print(array1);
}

void ram_method(ArrayList<Laptop1> array){
    System.out.println("Here,s the Laptops in ascending order of RAM :\n");
    //bubble sort
    Laptop1[] array1 = test_method(array);
    while (!sorted){
        sorted=true;
        for(int i=0;i<array1.length-1;i++){
            if(array1[i].RAM>array1[i+1].RAM){
                var=array1[i];
                array1[i]=array1[i+1];
                array1[i+1]=var;
                sorted=false;
            }
        }
    }
    print(array1);
}

void model_method(String pat, ArrayList<Laptop1> array){
    String pattern=pat.toLowerCase();
    int pattern_length=pattern.length();
    Laptop1[] array1 = test_method(array);

    ArrayList<Laptop1> to_store=new ArrayList<>();

    for(int i=0;i<array1.length;i++) {
        String txt = array1[i].model_number.toLowerCase();
        int text_length=txt.length();
        //string matching algorithm(Naive's algo)
        for(int j=0;j<=text_length-pattern_length;j++){
            int k;
            for(k=0;k<pattern_length;k++)
                if(txt.charAt(j+k)!=pattern.charAt(k))
                    break;
            if(k==pattern_length)
                to_store.add(array1[i]);
        }
    }
    Laptop1[] spare_array=test_method(to_store);
    print(spare_array);
}

Laptop1[] test_method(ArrayList<Laptop1> array){
    Laptop1[] array1 = new Laptop1[array.size()];
    array1=array.toArray(array1);
    return array1;
}

void print(Laptop1[] array){
    for (int i=0;i<array.length;i++){
        System.out.println("Model No. : "+array[i].model_number+"  Price :"+array[i].price+"  RAM : "+array[i].RAM);
    }
}

public static void main(String[]args){
    ArrayList<Laptop1> alist=new ArrayList<>();
    alist.add(new Laptop1("DellInspiron",30000,4));
    alist.add(new Laptop1("AcerPredator",65000,8));
    alist.add(new Laptop1("DellAeroblad",40000,4));
    alist.add(new Laptop1("AcerTrextron",70000,8));
    alist.add(new Laptop1("HPtransitant",35000,4));
    alist.add(new Laptop1("AcerNitroart",75000,8));
    alist.add(new Laptop1("HPforceLitGo",55000,4));


    System.out.println("1. Price\n2. RAM\n3. Model NO.\n");
    System.out.println("Enter corresponding no. for your choice :");
    int obj1=new Scanner(System.in).nextInt();
    try {
        switch (obj1) {
            case 1:
                new Laptop1().price_method(alist);
                break;
            case 2:
                new Laptop1().ram_method(alist);
                break;
            case 3:
                System.out.println("Enter the Model No you are searching :");
                String keyword = new Scanner(System.in).nextLine();
                new Laptop1().model_method(keyword, alist);
                break;
            default:
                System.out.println("Wrong!!! You typed the invalid option you dumbass!!!");

        }
    }catch (Exception e){
    }
}
}