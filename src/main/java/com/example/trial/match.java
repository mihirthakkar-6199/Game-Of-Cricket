package com.example.trial;

import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

public class match {
    private int overs;
    private String tossWon,wonAction,s;
    private team teamOne;
    private team teamTwo;
    innings firstInnings = new innings();
    innings secondInnings = new innings();
    private String result;
    public match(String team1,String team2,int over){
        teamOne = new team(team1);
        teamTwo = new team(team2);
        overs = over;
    }
    public String getResult(){
        return result;
    }
    public innings getFirstInnings(){
        return firstInnings;
    }
    public innings getSecondInnings(){
        return secondInnings;
    }
    public String gettossWon() {
        return tossWon;
    }
    public String getwonAction(){
        return wonAction;
    }
    public team getteamOne(){
        return teamOne;
    }
    public int getOvers(){
        return overs;
    }
    public team getteamTwo(){
        return teamTwo;
    }
    public String startmatch(){
        toss();
        System.out.println(overs);
        s="<center><h1>" + teamOne.getname()+ " Vs " +teamTwo.getname()+"</b></h1></center>";
        s +="<center><b>Team "+tossWon+" won the toss and have decided to "+wonAction+" first.</b><br><br>\n<b>SCORECARD</b></center><br>\n";
        Pair<String,Integer> out = firstInnings.startInnings(teamOne,teamTwo,1,0,overs,s);
        s=out.getKey();
        s=firstInnings.scoreboard(teamOne,teamTwo,s);
        Pair<String,Integer> out1= secondInnings.startInnings(teamTwo,teamOne,2,out.getValue(),overs,s);
        s=out1.getKey();
        s=secondInnings.scoreboard(teamTwo,teamOne,s);
        s+="<b>RESULT: ";
        if(teamOne.getrun()>teamTwo.getrun())
        {
            int rem=teamOne.getrun()-teamTwo.getrun();
            s+=teamOne.getname()+" won by "+rem+" runs</b><br>\n";
            result=teamOne.getname()+" won by "+rem+" runs";
        }
        else if(teamOne.getrun()==teamTwo.getrun())
        {
            s+="Match was a tie!</b><br>\n";
            result="Match was a tie!";
        }
        else
        {
            int rem=10-teamTwo.getwicket();
            if(rem==1) {
                s += teamTwo.getname() + " won by " + rem + " wicket</b><br>\n";
                result = teamTwo.getname() + " won by " + rem + " wicket";
            }
            else{
                s += teamTwo.getname() + " won by " + rem + " wickets</b><br>\n";
                result = teamTwo.getname() + " won by " + rem + " wickets";
            }
        }
        return s;
    }
    public void toss(){
        Random rand = new Random();
        int won = rand.nextInt(2);
        int action =rand.nextInt(2);
        if(won==0) tossWon=teamOne.getname();
        else tossWon=teamTwo.getname();
        if(action==0) wonAction="Bat";
        else wonAction="Bowl";
        if(won==0 && action==1)
        {
            team three = new team(teamTwo.getname());
            teamTwo = teamOne;
            teamOne=three;
        }
        else if(won==1 && action==0){
            team three = new team(teamTwo.getname());
            teamTwo = teamOne;
            teamOne=three;
        }
    }
}
