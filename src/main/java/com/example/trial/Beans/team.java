package com.example.trial.Beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class team {
    private String name;
    private int runs,wickets,balls;
    private float overs;
    private player[] players;
    public team(String name) {
        this.name = name;
        players = new player[11];
        for(int i=0;i<11;i++)
        {
            players[i] = new player(name+ " "+ (i+1),i);
      }
    }
    public void setBatsmenNoOfRuns(int index,int run){
        players[index].setNoOfRuns(run);
    }
    public int getBatsmenNoOfRuns(int index){
        return players[index].getNoOfRuns();
    }
    public int getBatsmenBattingRating(int index){
        return players[index].getBattingRating();
    }
    public void setBatsmenBattingRating(int index,int rating){
        players[index].setBattingRating(rating);
    }
    public void setBatsmenNoOfBallsPlayed(int index,int ball){
        players[index].setNoOfBallsPlayed(ball);
    }
    public int getBatsmenNoOfBallsPlayed(int index){
        return players[index].getNoOfBallsPlayed();
    }

    public void setBatsmenNoOfFours(int index,int bound){
        players[index].setNoOfFours(bound);
    }
    public int getBatsmenNoOfFours(int index){
        return players[index].getNoOfFours();
    }

    public void setBatsmenNoOfSixes(int index,int bound){
        players[index].setNoOfSixes(bound);
    }
    public int getBatsmenNoOfSixes(int index){
        return players[index].getNoOfSixes();
    }

    public void setBowlerNoOfBallsBowled(int index,int a){
        players[index].setNoOfBallsBowled(a);
    }
    public int getBowlerNoOfBallsBowled(int index){
        return players[index].getNoOfBallsBowled();
    }

    public void setBowlerRunsGiven(int index,int a){
        players[index].setRunsGiven(a);
    }
    public int getBowlerRunsGiven(int index){
        return players[index].getRunsGiven();
    }

    public void setBowlerWicketsTaken(int index,int a){
        players[index].setWicketsTaken(a);
    }
    public int getBowlerWicketsTaken(int index){
        return players[index].getWicketsTaken();
    }

    public void setBowlerMaidenOvers(int index,int a){
        players[index].setMaidenOvers(a);
    }
    public int getBowlerMaidenOvers(int index){
        return players[index].getMaidenOvers();
    }
}
