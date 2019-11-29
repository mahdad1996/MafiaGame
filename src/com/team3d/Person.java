package com.team3d;

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
