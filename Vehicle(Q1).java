/*1. Write a program to create a class named “Vehicle” having attributes name, mileage and price and a parameterized constructor
Vehicle must contain a method public int getPrice() to return the price of the vehicle.
Create 3 Vehicle objects and write them in a file named “record.doc”.
Write a method to display the name of the Vehicle with minimum price. (Use ObjectOutputStream)
*/

import java.io.*;
public class Vehicle implements Serializable {
    String name;
    int mileage,price;
    public Vehicle(String name, int mileage, int price) {
        this.name = name;
        this.mileage = mileage;
        this.price = price; }
    public int getPrice() {
        return price; }
    public static void main(String[]args) throws IOException, ClassNotFoundException {
        Vehicle obj1 = new Vehicle("A", 20, 10000);
        Vehicle obj2 = new Vehicle("B", 25, 20000);
        Vehicle obj3 = new Vehicle("C", 30, 30000);
        Vehicle array[]=new Vehicle[]{obj1,obj2,obj3};
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Ashish\\Desktop\\record.txt"));
        oos.writeObject(array);
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("C:\\Users\\Ashish\\Desktop\\record.txt"));
        Vehicle v1[]= (Vehicle[]) ois.readObject();
        int min=v1[0].price;
        int check=0;
        for (int i=0;i<array.length;i++) {
            if (min > v1[i].price) {
                min = v1[i].price;
                check = i; } }
        System.out.println("Minimum Price of vehicle is : "+v1[check].getPrice());
        System.out.println("Name of the vehicle with min price is : "+v1[check].name);
    }
}
