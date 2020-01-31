package com.company;

public class Cricketer {
    private String name;

    private int value;

    private int score;

    private Role role;

    public Cricketer(String name, Role role) {
        this.name = name;
        this.value = 0;
        this.score = 0;
        this.role = role;
    }

    public Cricketer(String name, int value, Role role) {
        this.name = name;
        this.value = value;
        this.score = 0;
        this.role = role;
    }

    public Cricketer(String name, int value, int score, Role role) {
        this.name = name;
        this.value = value;
        this.score = score;
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
