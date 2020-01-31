package com.company;

import java.util.Random;

public class Administrator {
    private Match match;

    public Administrator(Match match) {
        this.match = match;
    }

    public void assignPointsToCricketers() {
        Team[] teams = this.match.getTeams();

        for(Team team : teams) {
            for(Cricketer cricketer : team.getCricketers())
                cricketer.setScore(generateRandomInt());
        }
    }

    private int generateRandomInt(){
        Random random = new Random();
        return random.nextInt(100);
    }
}
