package com.example.trial;

import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

public class match {
    private int overs;
    private String toss_won,won_action,s;
    private team one;
    private team two;
    innings firstInnings = new innings();
    innings secondInnings = new innings();
    private String result;
    public match(String team1,String team2,int over){
        one = new team(team1);
        two = new team(team2);
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
    public String getToss_won() {
        return toss_won;
    }
    public String getWon_action(){
        return won_action;
    }
    public team getOne(){
        return one;
    }
    public int getOvers(){
        return overs;
    }
    public team gettwo(){
        return two;
    }
    public String startmatch(){
        toss();
        System.out.println(overs);
        s="<center><h1>" + one.getname()+ " Vs " +two.getname()+"</b></h1></center>";
        s +="<center><b>Team "+toss_won+" won the toss and have decided to "+won_action+" first.</b><br><br>\n<b>SCORECARD</b></center><br>\n";
        Pair<String,Integer> out = firstInnings.startInnings(one,two,1,0,overs,s);
        s=out.getKey();
        s=firstInnings.scoreboard(one,two,s);
        Pair<String,Integer> out1= secondInnings.startInnings(two,one,2,out.getValue(),overs,s);
        s=out1.getKey();
        s=secondInnings.scoreboard(two,one,s);
        s+="<b>RESULT: ";
        if(one.getrun()>two.getrun())
        {
            int rem=one.getrun()-two.getrun();
            s+=one.getname()+" won by "+rem+" runs</b><br>\n";
            result=one.getname()+" won by "+rem+" runs";
        }
        else if(one.getrun()==two.getrun())
        {
            s+="Match was a tie!</b><br>\n";
            result="Match was a tie!";
        }
        else
        {
            int rem=10-two.getwicket();
            if(rem==1) {
                s += two.getname() + " won by " + rem + " wicket</b><br>\n";
                result = two.getname() + " won by " + rem + " wicket";
            }
            else{
                s += two.getname() + " won by " + rem + " wickets</b><br>\n";
                result = two.getname() + " won by " + rem + " wickets";
            }
        }
        return s;
    }
    public void toss(){
        Random rand = new Random();
        int won = rand.nextInt(2);
        int action =rand.nextInt(2);
        if(won==0) toss_won=one.getname();
        else toss_won=two.getname();
        if(action==0) won_action="Bat";
        else won_action="Bowl";
        if(won==0 && action==1)
        {
            team three = new team(two.getname());
            two = one;
            one=three;
        }
        else if(won==1 && action==0){
            team three = new team(two.getname());
            two = one;
            one=three;
        }
    }
}
