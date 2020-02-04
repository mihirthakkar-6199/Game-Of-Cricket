package com.example.trial.Beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class match {
    private int overs;
    private String tossWon,wonAction;
    private team teamOne,teamTwo;
    innings firstInnings;
    innings secondInnings;
    private String result;
    public match(String team1,String team2,int over){
        teamOne = new team(team1);
        teamTwo = new team(team2);
        firstInnings = new innings();
        secondInnings = new innings();
        overs = over;
    }
}
