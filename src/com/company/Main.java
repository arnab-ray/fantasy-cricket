package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Cricketer> cricketerList = getCricketerPool();

        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of users");
        int userCount = scanner.nextInt();
        for (int i = 0; i < userCount; i++) {
            System.out.println("Please enter the name of user");
            String name = scanner.next();
            users.add(new User(name));
        }

        for (User user : users) {
            user.setTeam(cricketerList);
            System.out.println("Team for user: " + user.getName());
            user.getCricketers();
        }



        Team team1 = new Team("RCB");
        team1.assignCricketers(cricketerList);
        Team team2 = new Team("DD");
        team2.assignCricketers(cricketerList);
        Match match = new Match(team1, team2);

        Administrator administrator = new Administrator(match);
        administrator.assignPointsToCricketers();

        System.out.println("Points scored by each user");
        for (User user : users) {
            user.setPoints();
            System.out.println(user.getName() + ": " + user.getPoints());
        }

    }


    private static List<Cricketer> getCricketerPool() {
        List<Cricketer> cricketerList = new ArrayList<>();
        cricketerList.add(new Cricketer("Sachin", 20, 0, Role.BATSMAN));
        cricketerList.add(new Cricketer("Sourav", 20, 0, Role.BATSMAN));
        cricketerList.add(new Cricketer("Dravid", 10, 0, Role.BATSMAN));
        cricketerList.add(new Cricketer("Laxman", 10, 0, Role.BATSMAN));
        cricketerList.add(new Cricketer("Sehwag", 20, 0, Role.BATSMAN));
        cricketerList.add(new Cricketer("Yuvraj", 10, 0, Role.BATSMAN));
        cricketerList.add(new Cricketer("Raina", 20, 0, Role.BATSMAN));
        cricketerList.add(new Cricketer("Lara", 30, 0, Role.BATSMAN));
        cricketerList.add(new Cricketer("Anwar", 30, 0, Role.BATSMAN));
        cricketerList.add(new Cricketer("Misbah", 10, 0, Role.BATSMAN));
        cricketerList.add(new Cricketer("Imam", 10, 0, Role.BATSMAN));

        cricketerList.add(new Cricketer("Akram", 20, 0, Role.BOWLER));
        cricketerList.add(new Cricketer("Waqar", 20, 0, Role.BOWLER));
        cricketerList.add(new Cricketer("Zaheer", 10, 0, Role.BOWLER));
        cricketerList.add(new Cricketer("Kumble", 20, 0, Role.BOWLER));
        cricketerList.add(new Cricketer("Agarkar", 10, 0, Role.BOWLER));
        cricketerList.add(new Cricketer("McGrath", 10, 0, Role.BOWLER));
        cricketerList.add(new Cricketer("Lee", 10, 0, Role.BOWLER));
        cricketerList.add(new Cricketer("Warne", 20, 0, Role.BOWLER));
        cricketerList.add(new Cricketer("Pollock", 20, 0, Role.BOWLER));
        cricketerList.add(new Cricketer("Donald", 20, 0, Role.BOWLER));
        cricketerList.add(new Cricketer("Ambrose", 30, 0, Role.BOWLER));

        cricketerList.add(new Cricketer("Dhoni", 10, 0, Role.KEEPER));
        cricketerList.add(new Cricketer("Gilchrist", 10, 0, Role.KEEPER));
        cricketerList.add(new Cricketer("Boucher", 10, 0, Role.KEEPER));


        return cricketerList;
    }
}
