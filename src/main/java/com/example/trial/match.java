package com.example.trial;

import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

public class match {
    private team one;
    private team two;
    private int overs,target;
    private String toss_won,won_action,s;
    public match(String team1,String team2,int over){
        one = new team(team1);
        two = new team(team2);
        overs = over;
    }
    public String startmatch(){
        toss();
        System.out.println(overs);
        s="<center><h1>" + one.getname()+ " Vs " +two.getname()+"</b></h1></center>";
        s +="<center><b>Team "+toss_won+" won the toss and have decided to "+won_action+" first.</b><br><br>\n<b>SCORECARD</b></center><br>\n";
        innings firstInnings = new innings();
        Pair<String,Integer> out = firstInnings.startInnings(one,two,1,0,overs,s);
        s=out.getKey();
        s=firstInnings.scoreboard(one,two,s);
        innings secondInnings = new innings();
        Pair<String,Integer> out1= secondInnings.startInnings(two,one,2,out.getValue(),overs,s);
        s=out1.getKey();
        s=secondInnings.scoreboard(two,one,s);
        s+="<b>RESULT: ";
        if(one.getrun()>two.getrun())
        {
            int rem=one.getrun()-two.getrun();
            s+=one.getname()+" won by "+rem+" runs.</b><br>\n";
        }
        else if(one.getrun()==two.getrun())
        {
            s+="Match was a tie!</b><br>\n";
        }
        else
        {
            int rem=10-two.getwicket();
            s+=two.getname()+" won by "+rem+" wickets.</b><br>\n";
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
