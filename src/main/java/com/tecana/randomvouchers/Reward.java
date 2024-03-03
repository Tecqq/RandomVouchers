package com.tecana.randomvouchers;

public class Reward {
    private final String command;
    private final String message;

    public Reward(String command, String message) {
        this.command = command;
        this.message = message;
    }

    public String getCommand() {
        return command;
    }

    public String getMessage() {
        return message;
    }
}