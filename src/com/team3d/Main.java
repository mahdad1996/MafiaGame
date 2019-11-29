package com.team3d;

public class Main {

    public static void main(String[] args) {

        System.out.println("First Night!");


    }
}


interface Votable{

}

class Person{
    boolean isAlive = true;
    boolean isMafia;
    String talk;

}

    class Citizen extends Person{}

        class Doctor extends Citizen{}
        class Sniper extends Citizen{}
        class Detective extends Citizen{}

    class Mafia extends Person{}

        class  GodFather extends Mafia{}
        class Natasha extends Mafia{}


