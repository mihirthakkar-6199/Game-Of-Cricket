package com.example.trial;

public class team {
    private String name;
    private int runs=0;
    private int wickets=0;
    private int balls=0;
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
    public int getball(){
        return balls;
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
}
