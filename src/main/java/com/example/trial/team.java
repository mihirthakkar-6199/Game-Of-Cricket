package com.example.trial;

public class team {
    private String name;
    private int runs=0;
    private int wickets=0;
    private int balls=0,oversPlayed;
    private int[] players;
    public team(String name){
        this.name=name;
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
    /*public int getball(){
        return balls;
    }*/
    public float getOversPlayed(){
        return find(balls);
    }
    public void setrun(int runs){
        this.runs=runs;
    }
    public void setwicket(int wickets){
        this.wickets=wickets;
    }
    public void setball(int balls){
        this.balls=balls;
    }
    public float find(int ball){
        if(ball%6==0) return ball/6;
        else if(ball%6==1) return (float) (ball/6+0.1);
        else if(ball%6==2) return (float) (ball/6+0.2);
        else if(ball%6==3) return (float) (ball/6+0.3);
        else if(ball%6==4) return (float) (ball/6+0.4);
        else return (float) (ball/6+0.5);
    }
}
