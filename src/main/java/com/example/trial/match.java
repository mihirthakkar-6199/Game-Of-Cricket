package com.example.trial;

import java.util.Random;

public class match {
    private team one;
    private team two;
    private int balls,firInigs,target,totalOvers;
    private String tossWon,wonAction,result;
    public match(String team1,String team2,int over){
        one = new team(team1);
        two = new team(team2);
        balls = over*6;
        totalOvers=over;
    }
    public team getOne(){
        return one;
    }
    public team getTwo(){
        return two;
    }
    public int getTotalOvers(){
        return totalOvers;
    }
    public String getTossWon(){
        return tossWon;
    }
    public String getWonAction(){
        return wonAction;
    }
    public String getResult(){
        return result;
    }
    public void startMatch(){
        toss();
       // System.out.println(balls);
        //String s="<b>" + one.getname()+ " VS " +two.getname()+"</b><br>";
        //s += "Team "+tossWon+" won the toss and have decided to "+wonAction+" first.<br><br>\n<b>SCORECARD</b><br>\n";
        play(1);
        play(2);
        if(firInigs==0){
           // float over_fir=find(one.getball());
            //s+=one.getname()+" : "+one.getrun()+"/"+one.getwicket()+"("+over_fir+")<br>\n";
           // float over_sec =find(two.getball());
           // s+=two.getname()+" : "+two.getrun()+"/"+two.getwicket()+"("+over_sec+")<br>\n";
            if(one.getrun()>two.getrun())
            {
                int rem=one.getrun()-two.getrun();
             //   s+=one.getname()+" won by "+rem+" runs.<br>\n";
                result=one.getname()+" won by "+rem+" runs";
            }
            else if(one.getrun()==two.getrun())
            {
                //s+="Match was a tie!<br>\n";
                result="Match was a tie!";
            }
            else
            {
                int rem=10-two.getwicket();
            //    s+=two.getname()+" won by "+rem+" wickets.<br>\n";
                result=two.getname()+" won by "+rem+" wickets";
            }
        }
        else{
        //    float over_fir=find(two.getball());
         //   s+=two.getname()+" : "+two.getrun()+"/"+two.getwicket()+"("+over_fir+")<br>\n";
          //  float over_sec =find(one.getball());
           // s+=one.getname()+" : "+one.getrun()+"/"+one.getwicket()+"("+over_sec+")<br>\n";
            if(two.getrun()>one.getrun())
            {
                int rem=two.getrun()-one.getrun();
                //s+=two.getname()+" won by "+rem+" runs.<br>\n";
                result=two.getname()+" won by "+rem+" runs";
            }
            else if(one.getrun()==two.getrun())
            {
                //s+="Match was a tie!<br>\n";
                result="Match was a tie!";
            }
            else
            {
                int rem=10-one.getwicket();
                //s+=one.getname()+" won by "+rem+" wickets.<br>\n";
                result=one.getname()+" won by "+rem+" wickets";
            }
        }
        //s+="Thanks! Bye!";
       // s="mihi"+"\n"+"harsh";
       // System.out.println(s);
       // return "mihi"+"\n"+"harsh";
      //  return this;
    }
    public void toss(){
        Random rand = new Random();
        int won = rand.nextInt(2);
        int action =rand.nextInt(2);
        if(won==0) tossWon=one.getname();
        else tossWon=two.getname();
        if(action==0) wonAction="Bat";
        else wonAction="Bowl";
        if(won==0 && action==0) firInigs=0;
        else if(won==0 && action==1) firInigs=1;
        else if(won==1 && action==0) firInigs=1;
        else firInigs=0;
    }
    public void play(int inigs){
        int run=0;
        int wicket=0;
        int ball=balls;
        for(int i=1;i<=balls;i++)
        {
            if(inigs==2 && run>target)
            {
                ball=i-1;
                break;
            }
            if(wicket==10){
                ball=i-1;
                break;
            }
            Random rand = new Random();
            int next = rand.nextInt(8);
            if(next==7)
            {
                wicket++;
            }
            else
            {
               // System.out.println(run+" "+next);
                run+=next;
            }
        }
        if(inigs==1){
            target=run;
            if(firInigs==0)
            {
               // System.out.println(ball);
                one.setrun(run);
                one.setball(ball);
                one.setwicket(wicket);
            }
            else
            {
               // System.out.println(ball);
                two.setrun(run);
                two.setball(ball);
                two.setwicket(wicket);
            }
        }
        if(inigs==2){
            if(firInigs==0)
            {
                two.setrun(run);
                two.setball(ball);
                two.setwicket(wicket);
            }
            else
            {
                one.setrun(run);
                one.setball(ball);
                one.setwicket(wicket);
            }
        }
    }
    /*public String toString(){
        String s = ""+this.run+"/"+this.wicket;
        return s;
    }*/
}
