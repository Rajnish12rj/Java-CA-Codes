/*Ashish-11810804*/

/*2. Write a program to create a class Voter which contains attributes name, date_of_birth and voter_id and voter has a Voter_Card.
Provide appropriate constructor to initialize all the attributes of the Voter but voter id must be assigned automatically
only when the age of the voter is greater than or equal to 18 years. VoterCard is a nested class with attributes voter_id and Voter_name.
Make sure that voter card is created only when user is a valid voter and if it is already created then must not be assigned the new voter id.
*/


import java.util.*;

class Voter1 {
    String name;
    int age, voter_id;
    VoterCard1 v;

    Voter1(String name, int age, int voter_id) {
        this.name = name;
        this.age = age;
        this.voter_id = voter_id;
        if (age >= 18) {
            if (voter_id == 0)
                this.voter_id = age * 110;
            v = new VoterCard1(name, age);
        }
    }

    class VoterCard1 {
        String voter_name;
        int voter_id;

        VoterCard1(String voter_name, int voter_id) {
            this.voter_name = voter_name;
            this.voter_id = voter_id;
        }
    }

    static void check_VoterCard(String name, ArrayList<Voter1> array) {
        boolean b1 = false;
        String check = null;
        Iterator<Voter1> itr = array.iterator();
        while (itr.hasNext()) {
            Voter1 st = itr.next();

            if (st.v != null) {
                if (st.v.voter_name.equals(name)) {
                    System.out.println("So your name is " + st.v.voter_name + "\nYou have a voter card \nAnd your voter id is " + st.voter_id);
                    b1 = true;
                    check = st.v.voter_name;
                }
            }
        }
        if (!b1)
            System.out.println("Sorry, it seems you are a kid!!!\nGo back and grow a little.");
    }

    public static void main(String[] args) {
        java.util.Scanner s1 = new java.util.Scanner(System.in);
        ArrayList<Voter1> array = new ArrayList<Voter1>();

        Voter1 ob1 = new Voter1("Hashirama", 22, 1181);
        Voter1 ob2 = new Voter1("Sarutobi", 20, 1182);
        Voter1 ob3 = new Voter1("Jiraya", 20, 1183);
        Voter1 ob4 = new Voter1("Minato", 18, 0);
        Voter1 ob5 = new Voter1("Naruto", 15, 0);
        Voter1 ob6 = new Voter1("Boruto", 12, 0);
        array.add(ob1);
        array.add(ob2);
        array.add(ob3);
        array.add(ob4);
        array.add(ob5);
        array.add(ob6);

        System.out.println("Enter your name : ");
        String s = s1.nextLine();
        check_VoterCard(s, array);
    }
}
