package com.example.trial;

import java.util.ArrayList;

public class over {
    private ArrayList<Integer> ballInfo = new ArrayList<>();
    public void setBallInfo(int next){
        ballInfo.add(next);
    }
    public ArrayList<Integer> getBallInfo(){
        return ballInfo;
    }
}
