package com.example.trial.Beans;

import java.util.List;
import java.util.ArrayList;

public class over {
    private List<Integer> ballInfo = new ArrayList<>();
    public void setBallInfo(int next){
        ballInfo.add(next);
    }
    public List<Integer> getBallInfo(){
        return ballInfo;
    }
}
