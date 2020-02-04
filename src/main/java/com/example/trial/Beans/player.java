package com.example.trial.Beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class player {
    enum PlayerType{
        Batsman,Bowler;
    }
    private String name;
    private int noOfRuns,noOfBallsPlayed,noOfFours,noOfSixes,noOfBallsBowled,runsGiven,wicketsTaken,maidenOvers,battingRating;
    private PlayerType type;
    public player(String name,int i){
        this.name=name;
        if(i>=0 && i<=5)
            this.type=PlayerType.Batsman;
        else
            this.type=PlayerType.Bowler;
    }
}
