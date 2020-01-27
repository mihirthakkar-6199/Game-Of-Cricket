package com.example.trial;

public class player {
    private String name;
    private int noOfRuns=0,noOfBallsPlayed=0,noOfFours=0,noOfSixes=0,noOfBallsBowled=0,runsGiven=0,wicketsTaken=0,maidenOvers=0;
    public player(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public int getNoOfRuns(){
        return noOfRuns;
    }
    public int getNoOfBallsPlayed(){
        return noOfBallsPlayed;
    }
    public int getNoOfFours(){
        return noOfFours;
    }
    public int getNoOfSixes(){
        return noOfSixes;
    }
    public int getNoOfBallsBowled(){
        return noOfBallsBowled;
    }
    public int getRunsGiven(){
        return runsGiven;
    }
    public int getWicketsTaken(){
        return wicketsTaken;
    }
    public int getMaidenOvers(){
        return maidenOvers;
    }
    public void setNoOfRuns(int noOfRuns){
        this.noOfRuns=noOfRuns;
    }
    public void setNoOfBallsPlayed(int noOfBallsPlayed){
        this.noOfBallsPlayed=noOfBallsPlayed;
    }
    public void setNoOfFours(int noOfFours){
        this.noOfFours=noOfFours;
    }
    public void setNoOfSixes(int noOfSixes){
        this.noOfSixes=noOfSixes;
    }
    public void setNoOfBallsBowled(int noOfBallsBowled){
        this.noOfBallsBowled=noOfBallsBowled;
    }
    public void setRunsGiven(int runsGiven){
        this.runsGiven=runsGiven;
    }
    public void setWicketsTaken(int wicketsTaken){
        this.wicketsTaken=wicketsTaken;
    }
    public void setMaidenOvers(int maidenOvers){
        this.maidenOvers=maidenOvers;
    }
}
