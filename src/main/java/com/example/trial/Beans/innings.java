package com.example.trial.Beans;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class innings {
    private team batting, bowling;
    private int runs, wickets, balls, striker=0, nonStriker=1, currBowler, inningsNumber, target;
    private ArrayList<over> overData = new ArrayList<>();

    public void addOver(over newOver) {
        overData.add(newOver);
    }

    public ArrayList<over> getoverData() {
        return overData;
    }
}