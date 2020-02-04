package com.example.trial.Service;

import com.example.trial.Beans.match;

public interface GameService {
    match start(String team1, String team2, int over);
}
