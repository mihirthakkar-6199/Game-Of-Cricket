package com.example.trial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class team {
    private String name;
    private int runs=0;
    private int wickets=0;
    private int balls=0;
    private float overs=0;
    private player[] players;
    public team(String name){
        this.name=name;
        players = new player[11];
        List<Integer> temp = new ArrayList<>();
        double next;
        for(int i=0;i<11;i++)
        {
            players[i] = new player(name+ " "+ (i+1));
        }
        //The first 6 players of both teams are batsmen and their batting rating will be between 80 and 100
        //Generate 6 numbers between 80 and 100 and then sort it in descending order,ie, the first batsman will get the highest rating
        for(int i=0;i<6;i++){
            players[i].setType(PlayerType.Batsman);
            next=Math.random();
            next=next*20+80;
            temp.add((int)next);
        }
        Collections.sort(temp,Collections.reverseOrder());
        for(int i=0;i<6;i++){
            players[i].setBattingRating(temp.get(i));
        }
        //The next 5 players of both the teams are bowlers and their batting rating will be between 60 and 80
        //Generate 5 numbers between 60 and 80 and then sort it in descending order,ie, the 7th batsman will get the highest rating
        temp.clear();
        for(int i=6;i<11;i++){
            players[i].setType(PlayerType.Bowler);
            next=Math.random();
            next=next*20+60;
            temp.add((int)next);
        }
        Collections.sort(temp,Collections.reverseOrder());
        for(int i=6;i<11;i++){
            players[i].setBattingRating(temp.get(i-6));
        }
    }
    public String getname(){
        return name;
    }
    public int getrun(){
        return runs;
    }
    public int getwicket(){
        return wickets;
    }
    public float getOvers(){
        return overs;
    }
    //public int getball(){
    //    return balls;
    //}
    public player[] getPlayers(){
        return players;
    }
    public void setrun(int runs){
        this.runs=runs;
    }
    public void setOvers(float overs){
        this.overs=overs;
    }
    public void setwicket(int wickets){
        this.wickets=wickets;
    }
    public void setball(int balls){
        this.balls=balls;
    }
    public String getBatsmenName(int index){
        return players[index].getName();
    }
    public String getBowlerName(int index){
        return players[index].getName();
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
