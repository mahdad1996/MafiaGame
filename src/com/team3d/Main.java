package com.team3d;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("First Night!");

        RolesSource.citizens.add(new Doctor());
        RolesSource.citizens.add(new Sniper());
        RolesSource.citizens.add(new Detective());
        for (int i=1; i<=12; i++){
            RolesSource.citizens.add(new Citizen());
        }


        RolesSource.mafias.add(new GodFather());
        RolesSource.mafias.add(new Natasha());
        for (int i=1; i <= 3; i++){
            RolesSource.mafias.add(new Mafia());
        }

        while (RolesSource.mafias.size() != RolesSource.citizens.size() || RolesSource.mafias.size() == 0){

            for (Person i : RolesSource.mafias){
                if (i.isAlive()){
                    i.vote();
                }
            }
            int maxVote = 0;
            Person maxVoted = null;
            for (Person i:RolesSource.citizens){
                if (i.getNumberOfVotes() > maxVote){
                    maxVote = i.getNumberOfVotes();
                    maxVoted = i;
                }
            }

            RolesSource.citizens.remove(maxVoted);
//            maxVoted.setAlive(false);

            for (Person i : RolesSource.citizens)
                i.setNumberOfVotes(0);
            printPersons();




            

        }



    }

    public static Person voteResult(ArrayList<Person> selectedList){
        int maxVote = 0;
        Person maxVoted = null;
        for (Person i:selectedList){
            if (i.getNumberOfVotes() > maxVote){
                maxVote = i.getNumberOfVotes();
                maxVoted = i;
            }
        }
        return maxVoted;
    }

    public static void printPersons(){
        System.out.println("citizens");
        for (Person i : RolesSource.citizens)
            System.out.println(i.isAlive());
        System.out.println("mafias");
        for (Person i : RolesSource.mafias)
            System.out.println(i.isAlive());
    }
}



abstract class Person {
    private boolean isAlive = true;
    private String talk;
    private int numberOfVotes;

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    abstract public void vote();

}

    class Citizen extends Person{
        @Override
        public void vote() {

        }
    }

        class Doctor extends Citizen{}
        class Sniper extends Citizen{}
        class Detective extends Citizen{}

    class Mafia extends Person{
        @Override
        public void vote() {


            int citizenIndexToVote = new Random().nextInt(15);
            while (RolesSource.citizens.get(citizenIndexToVote).isAlive() == false ){
                citizenIndexToVote = new Random().nextInt(15);
            }
            Citizen selectedCitizen = RolesSource.citizens.get(citizenIndexToVote);
            selectedCitizen.setNumberOfVotes(selectedCitizen.getNumberOfVotes()+1);
        }
    }

        class  GodFather extends Mafia{}
        class Natasha extends Mafia{}


