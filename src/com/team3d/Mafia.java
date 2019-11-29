package com.team3d;

import java.util.Random;

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
