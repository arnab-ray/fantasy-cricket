package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Team {
    private String name;
    private Cricketer[] cricketers;

    public Team(String name) {
        this.name = name;
        this.cricketers = new Cricketer[11];
    }

    public String getName() {
        return this.name;
    }

    public void assignCricketers(List<Cricketer> cricketerList) {
        Set<String> playersPresent = new HashSet<>();

        int keeperCount = 0;
        int batsmanCount = 0;
        int bowlerCount = 0;

        int requiredKeeperCount = 1;
        int requiredBatsmanCount = 3;
        int requiredBowlerCount = 3;

        int cricketerCounter = 0;

        // while all players are not selected do this
        while (cricketerCounter < 7) {
            int i = generateRandomInt(cricketerList.size());
            Cricketer cricketer = cricketerList.get(i);
            if (!playersPresent.contains(cricketer.getName())) {
                Role role = cricketer.getRole();
                if (role == Role.KEEPER && keeperCount <= requiredKeeperCount) {
                    cricketers[cricketerCounter++] = cricketer;
                    keeperCount++;
                } else if (role == Role.BATSMAN && batsmanCount <= requiredBatsmanCount) {
                    cricketers[cricketerCounter++] = cricketer;
                    batsmanCount++;
                } else if (role == Role.BOWLER && bowlerCount <= requiredBowlerCount) {
                    cricketers[cricketerCounter++] = cricketer;
                    bowlerCount++;
                }
                playersPresent.add(cricketer.getName());
            }
        }

        while (cricketerCounter < 11) {
            int i = generateRandomInt(cricketerList.size());
            Cricketer cricketer = cricketerList.get(i);
            if (!playersPresent.contains(cricketer.getName())) {
                cricketers[cricketerCounter++] = cricketer;
                playersPresent.add(cricketer.getName());
            }
        }
    }

    public Cricketer[] getCricketers() {
        return this.cricketers;
    }

    private int generateRandomInt(int upperRange){
        Random random = new Random();
        return random.nextInt(upperRange);
    }
}
