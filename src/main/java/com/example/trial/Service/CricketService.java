package com.example.trial.Service;

import com.example.trial.Beans.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CricketService implements GameService {

    @Override
    public match start(String team1, String team2, int over) {
        match m = new match(team1,team2,over);
        setBatsman(m.getTeamOne());
        setBowler(m.getTeamOne());
        setBatsman(m.getTeamTwo());
        setBowler(m.getTeamTwo());
        toss(m);
        Integer target = startInnings(m.getTeamOne(),m.getTeamTwo(),1,0,m.getOvers(),m.getFirstInnings());
        target = startInnings(m.getTeamTwo(),m.getTeamOne(),2,target,m.getOvers(),m.getSecondInnings());
        result(m);
        return m;
    }
    public void result(match m){
        if(m.getTeamOne().getRuns()>m.getTeamTwo().getRuns())
        {
            int rem=m.getTeamOne().getRuns()-m.getTeamTwo().getRuns();
            m.setResult(m.getTeamOne().getName()+" won by "+rem+" runs");
        }
        else if(m.getTeamOne().getRuns()==m.getTeamTwo().getRuns())
        {
            m.setResult("Match was a tie!");
        }
        else
        {
            int rem=10-m.getTeamTwo().getWickets();
            if(rem==1) {
                m.setResult(m.getTeamTwo().getName() + " won by " + rem + " wicket");
            }
            else{
                m.setResult(m.getTeamTwo().getName() + " won by " + rem + " wickets");
            }
        }
    }
    public void toss(match m){
        Random rand = new Random();
        int won = rand.nextInt(2);
        int action =rand.nextInt(2);
        if(won==0) m.setTossWon(m.getTeamOne().getName());
        else m.setTossWon(m.getTeamTwo().getName());
        if(action==0) m.setWonAction("Bat");
        else m.setWonAction("Bowl");
        if((won==0 && action==1) || (won==1 && action==0))
        {
            team three = m.getTeamTwo();
            m.setTeamTwo(m.getTeamOne());
            m.setTeamOne(three);
        }
    }
    public void setBatsman(team t){
        //The first 6 players of both teams are batsmen and their batting rating will be between 80 and 100
        //Generate 6 numbers between 80 and 100 and then sort it in descending order,ie, the first batsman will get the highest rating
        List<Integer> temp = new ArrayList<>();
        double next;
        for(int i=0;i<6;i++){
            next=Math.random();
            next=next*20+80;
            temp.add((int)next);
        }
        Collections.sort(temp,Collections.reverseOrder());
        for(int i=0;i<6;i++){
            t.setBatsmenBattingRating(i,temp.get(i));
        }
    }
    public void setBowler(team t) {
        //The next 5 players of both the teams are bowlers and their batting rating will be between 60 and 80
        //Generate 5 numbers between 60 and 80 and then sort it in descending order,ie, the 7th batsman will get the highest rating
        List<Integer> temp = new ArrayList<>();
        double next;
        for (int i = 6; i < 11; i++) {
            next = Math.random();
            next = next * 20 + 60;
            temp.add((int) next);
        }
        Collections.sort(temp, Collections.reverseOrder());
        for (int i = 6; i < 11; i++) {
            t.setBatsmenBattingRating(i, temp.get(i - 6));
        }
    }
    public Integer startInnings(team bat, team bowl, int number, int target, int overs, innings inning){
        inning.setBatting(bat);
        inning.setBowling(bowl);
        inning.setInningsNumber(number);
        inning.setTarget(target);
        int flag=0,lastRun=-1;
        for(int i=1;i<=overs;i++)
        {
            lastRun = startOver(inning);
            validate(inning,lastRun);
            if(lastRun==-1) {
                break;
            }
        }
        target=inning.getRuns();
        inning.getBatting().setBalls(inning.getBalls());
        inning.getBatting().setOvers(convert(inning.getBalls()));
        return target;
    }
    public float convert(int ball){
        if(ball%6==0) return ball/6;
        else if(ball%6==1) return (float) (ball/6+0.1);
        else if(ball%6==2) return (float) (ball/6+0.2);
        else if(ball%6==3) return (float) (ball/6+0.3);
        else if(ball%6==4) return (float) (ball/6+0.4);
        else return (float) (ball/6+0.5);
    }
    public void validate(innings inning, int lastRun){
        inning.setCurrBowler(inning.getCurrBowler()+1);
        if(inning.getCurrBowler()==11)
            inning.setCurrBowler(6);
        if(lastRun%2==0){
            int temp1=inning.getNonStriker();
            inning.setNonStriker(inning.getStriker());
            inning.setStriker(temp1);
        }
    }
    public int startOver(innings inning){
        over newOver = new over();
        int temp=0,lastRun=-1;
        for(int j=1;j<=6;j++)
        {
            if((inning.getInningsNumber()==2 && inning.getRuns()>inning.getTarget()) || (inning.getWickets()==10))
                return lastRun;
            int next=nextBall(inning);
            newOver.setBallInfo(next);
            if(next>=0 && next<=6)
                temp+=next;
            if(next==7)
                wicket(inning);
            else
                run(inning,next);
            if(j==6)
                lastRun=next;
            inning.getBowling().setBowlerNoOfBallsBowled(inning.getCurrBowler(),inning.getBowling().getBowlerNoOfBallsBowled(inning.getCurrBowler())+1);
            inning.getBatting().setBatsmenNoOfBallsPlayed(inning.getStriker(),inning.getBatting().getBatsmenNoOfBallsPlayed(inning.getStriker())+1);
            inning.setBalls(inning.getBalls()+1);
        }
        if(temp==0)
            inning.getBowling().setBowlerMaidenOvers(inning.getCurrBowler(),inning.getBowling().getBowlerMaidenOvers(inning.getCurrBowler())+1);
        inning.addOver(newOver);
        return lastRun;
    }
    public int nextBall(innings inning){
        //Generate a random number between 0 and 100. If the number is greater than the batting rating of the player, then the
        //player is out. Otherwise another random number is generated which is equally distributed between 0 and 6, which adds
        //this number of runs to the player
        double prob=Math.random()*100;
        int next;
        if(prob>inning.getBatting().getBatsmenBattingRating(inning.getStriker())){
            next=7;
        }
        else{
            Random rand = new Random();
            next = rand.nextInt(7);
        }
        return next;
    }
    public void wicket(innings inning){
        inning.setWickets(inning.getWickets()+1);
        inning.getBatting().setWickets(inning.getBatting().getWickets()+1);
        inning.getBowling().setBowlerWicketsTaken(inning.getCurrBowler(),inning.getBowling().getBowlerWicketsTaken(inning.getCurrBowler())+1);
        if(inning.getWickets()!=10) {
            if (inning.getStriker() > inning.getNonStriker())
                inning.setStriker(inning.getStriker() + 1);
            else if (inning.getStriker() < inning.getNonStriker())
                inning.setStriker(inning.getNonStriker() + 1);
        }
    }
    public void run(innings inning,int next){
        inning.getBatting().setBatsmenNoOfRuns(inning.getStriker(),inning.getBatting().getBatsmenNoOfRuns(inning.getStriker())+next);
        inning.getBowling().setBowlerRunsGiven(inning.getCurrBowler(),inning.getBowling().getBowlerRunsGiven(inning.getCurrBowler())+next);
        inning.getBatting().setRuns(inning.getBatting().getRuns()+next);
        inning.setRuns(inning.getRuns()+next);
        if(next==4)
            inning.getBatting().setBatsmenNoOfFours(inning.getStriker(),inning.getBatting().getBatsmenNoOfFours(inning.getStriker())+1);
        if(next==6)
            inning.getBatting().setBatsmenNoOfSixes(inning.getStriker(),inning.getBatting().getBatsmenNoOfSixes(inning.getStriker())+1);
        if(next%2==1)
        {
            int temp1=inning.getNonStriker();
            inning.setNonStriker(inning.getStriker());
            inning.setStriker(temp1);
        }
    }
}
