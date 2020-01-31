package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class User {

    private String name;

    private int credit = 800;

    private final Cricketer[] cricketers = new Cricketer[11];

    private int points;

    private Set<String> playersPresent;

    public User(String name) {
        this.name = name;
        playersPresent = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public void getCricketers() {
        for(Cricketer cricketer : cricketers)
            System.out.println(cricketer.getName());
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints() {
        int val = 0;
        for(Cricketer cricketer : cricketers)
            val += cricketer.getScore();

        this.points = val;
    }

    public void setTeam(List<Cricketer> cricketerList) {
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
            //System.out.println("random int generated: " + i);
            System.out.println("first loop cricketerCounter: " + cricketerCounter);
            Cricketer cricketer = cricketerList.get(i);
            //System.out.println("cricketer generated: " + cricketer.getName());
            if (!playersPresent.contains(cricketer.getName()) && cricketer.getValue() < credit) {

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
                credit -= cricketer.getValue();
            }

            if(cricketer.getValue() > credit) {
                System.out.println("cricketer generated: " + cricketer.getName() + " " + cricketer.getValue());
                System.out.println("Credit exhausted:: " + credit);
                break;
            }
        }

        System.out.println("cricketerCounter after first loop: " + cricketerCounter);

        while (cricketerCounter < 11) {
            System.out.println("second loop cricketerCounter: " + cricketerCounter);
            int i = generateRandomInt(cricketerList.size());
            Cricketer cricketer = cricketerList.get(i);
            if (!playersPresent.contains(cricketer.getName()) && cricketer.getValue() < credit) {
                cricketers[cricketerCounter++] = cricketer;
                playersPresent.add(cricketer.getName());
                credit -= cricketer.getValue();
            }
            if(cricketer.getValue() > credit) {
                System.out.println("cricketer generated: " + cricketer.getName() + " " + cricketer.getValue());
                System.out.println("Credit exhausted:: " + credit);
                break;
            }
        }
    }

    public boolean isValidTeam() {
        int keeperCount = 0;
        int batsmanCount = 0;
        int bowlerCount = 0;

        for(int i = 0; i < 11; i++) {
            if(cricketers[i].getRole() == Role.KEEPER)
                keeperCount++;
            else if(cricketers[i].getRole() == Role.BATSMAN)
                batsmanCount++;
            else if(cricketers[i].getRole() == Role.BOWLER)
                bowlerCount++;
        }

        return keeperCount >= 1 && batsmanCount >= 3 && bowlerCount >= 3;
    }


    private int generateRandomInt(int upperRange){
        Random random = new Random();
        return random.nextInt(upperRange);
    }
}
