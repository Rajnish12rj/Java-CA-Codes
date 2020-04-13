/*Ashish-11810804*/

/*WAP wih class IPL_Team with team_name,wicketkeeper,allrounder and captain, initialize by cons.
Player is private nested class with player_name,price and initialize with cons. 
In main class, create at least 3 teams each having a captain and a wicket-keeper and at least one all-rounder
store the teams in an arraylist.
Implement a method which displays the name of the team and details of all the players of that
team whose captain is having highest price.



int a=Integer.parseInt(args[0]);    to take commandline input
*/

import java.util.ArrayList;
import java.util.Iterator;

class IPL_Team{
    String team_name,wicketkeeper,captain;
    int allrounder;
    Player01 P;

    IPL_Team(){}
    IPL_Team(String N,String W,int Ano,String C){
        this.team_name=N;
        this.wicketkeeper=W;
        if(Ano>=1)
            allrounder=Ano;
        else
            System.out.println("Add AllRounders");
        this.captain=C;
        P=new Player01(C,Ano*1000);
    }

    private class Player01{
        String player_name;
        int price;

        Player01(String player_name,int price){
            this.player_name=player_name;
            this.price=price;
        }
    }

    void display(ArrayList<IPL_Team> listDemo){
        int max=0,Ano=0;
        String Cname=null,Wname=null,Tname=null;
        Iterator itr=listDemo.iterator();
        while(itr.hasNext())
        {
            IPL_Team st=(IPL_Team)itr.next();
            if((int)st.P.price>=max){
                max=(int)st.P.price;
                Cname=(String)st.captain;
                Wname=(String)st.wicketkeeper;
                Tname=(String)st.team_name;
                Ano=(int)st.allrounder;
            }
        }
        System.out.println("The max salary awarded is :"+max+"\nCaptain with the max salary is :"+Cname+"\nName of his Team is :"+Tname+"\nName of the wicketkeeper is :"+Wname+"\nNo of allrounders on the team is :"+Ano);
    }

        public static void main(String[]args){
            ArrayList<IPL_Team> list1=new ArrayList<IPL_Team>();
            IPL_Team obj1=new IPL_Team("Chennai","Dhoni",2,"Dhoni");
            IPL_Team obj2=new IPL_Team("Delhi","Kohli",1,"Kholi");
            IPL_Team obj3=new IPL_Team("Hola","Virk",5,"Virz");

            list1.add(obj1);
            list1.add(obj2);
            list1.add(obj3);

            new IPL_Team().display(list1);
        }
    }