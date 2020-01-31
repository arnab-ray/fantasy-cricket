package com.company;

public class Match {

    private Team[] teams = new Team[2];

    public Match(Team team1, Team team2) {
        this.teams[0] = team1;
        this.teams[1] = team2;
    }

    public Team[] getTeams() {
        return this.teams;
    }

    public Team getTeamDetails(String name) {
        for(int i = 0; i < 2; i++) {
            if(teams[i].getName().equalsIgnoreCase(name))
                return teams[i];
        }

        return null;
    }
}
